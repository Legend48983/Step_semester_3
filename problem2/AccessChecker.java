public class AccessChecker {
    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if (fieldModifier == null || accessorContext == null) {
            return "DENIED";
        }

        switch (fieldModifier) {
            case "private":
                return "SAME_CLASS".equals(accessorContext) ? "ALLOWED" : "DENIED";
            case "default":
                return ("SAME_CLASS".equals(accessorContext)
                        || "SAME_PACKAGE".equals(accessorContext)) ? "ALLOWED" : "DENIED";
            case "protected":
                return ("SAME_CLASS".equals(accessorContext)
                        || "SAME_PACKAGE".equals(accessorContext)
                        || "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE".equals(accessorContext))
                        ? "ALLOWED" : "DENIED";
            case "public":
                return isKnownContext(accessorContext) ? "ALLOWED" : "DENIED";
            default:
                return "DENIED";
        }
    }

    public static String firstDeniedAttempt(String[][] attempts) {
        if (attempts == null) {
            return "None Denied";
        }

        for (int i = 0; i < attempts.length; i++) {
            String[] attempt = attempts[i];
            if (attempt == null || attempt.length < 2) {
                continue;
            }

            if ("DENIED".equals(classifyAccess(attempt[0], attempt[1]))) {
                return attempt[0] + " via " + attempt[1] + " (attempt #" + (i + 1) + ")";
            }
        }
        return "None Denied";
    }

    private static boolean isKnownContext(String context) {
        return "SAME_CLASS".equals(context)
                || "SAME_PACKAGE".equals(context)
                || "DIFFERENT_PACKAGE".equals(context)
                || "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE".equals(context)
                || "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE".equals(context);
    }
}
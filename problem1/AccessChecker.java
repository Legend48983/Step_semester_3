public class AccessChecker {
    private static final String[] MODIFIERS = {"private", "default", "protected", "public"};

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
                        || "SAME_PACKAGE".equals(accessorContext)) ? "ALLOWED" : "DENIED";
            case "public":
                return isKnownContext(accessorContext) ? "ALLOWED" : "DENIED";
            default:
                return "DENIED";
        }
    }

    public static String summarizeByModifier(String[][] attempts) {
        int[] allowed = new int[MODIFIERS.length];
        int[] denied = new int[MODIFIERS.length];

        if (attempts != null) {
            for (String[] attempt : attempts) {
                if (attempt == null || attempt.length < 2) {
                    continue;
                }
                int modifierIndex = modifierIndex(attempt[0]);
                if (modifierIndex < 0) {
                    continue;
                }
                if ("ALLOWED".equals(classifyAccess(attempt[0], attempt[1]))) {
                    allowed[modifierIndex]++;
                } else {
                    denied[modifierIndex]++;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < MODIFIERS.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }
            result.append(MODIFIERS[i])
                  .append(": ")
                  .append(allowed[i])
                  .append(" allowed / ")
                  .append(denied[i])
                  .append(" denied");
        }
        return result.toString();
    }

    private static int modifierIndex(String modifier) {
        for (int i = 0; i < MODIFIERS.length; i++) {
            if (MODIFIERS[i].equals(modifier)) {
                return i;
            }
        }
        return -1;
    }

    private static boolean isKnownContext(String context) {
        return "SAME_CLASS".equals(context)
                || "SAME_PACKAGE".equals(context)
                || "DIFFERENT_PACKAGE".equals(context);
    }
}
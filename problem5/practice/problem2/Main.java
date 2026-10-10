class AccessChecker {
    static String classifyAccess(String modifier, String context) {
        if (modifier == null || context == null) return "DENIED";
        switch (modifier) {
            case "private": return context.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";
            case "default": return context.equals("SAME_CLASS") || context.equals("SAME_PACKAGE") ? "ALLOWED" : "DENIED";
            case "protected":
                return context.equals("SAME_CLASS") || context.equals("SAME_PACKAGE") || context.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE") ? "ALLOWED" : "DENIED";
            case "public": return context.equals("SAME_CLASS") || context.equals("SAME_PACKAGE") || context.equals("DIFFERENT_PACKAGE") || context.startsWith("SUBCLASS_DIFFERENT_PACKAGE_") ? "ALLOWED" : "DENIED";
            default: return "DENIED";
        }
    }
    static String firstDeniedAttempt(String[][] attempts) {
        if (attempts == null) return "None Denied";
        for (int i = 0; i < attempts.length; i++) {
            String[] a = attempts[i];
            if (a != null && a.length >= 2 && classifyAccess(a[0], a[1]).equals("DENIED"))
                return a[0] + " via " + a[1] + " (attempt #" + (i + 1) + ")";
        }
        return "None Denied";
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println(AccessChecker.firstDeniedAttempt(new String[][]{
            {"public","SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
            {"protected","SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
            {"protected","SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        }));
    }
}
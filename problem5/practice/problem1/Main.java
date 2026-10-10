class AccessChecker {
    private static final String[] MODIFIERS = {"private", "default", "protected", "public"};
    static String classifyAccess(String modifier, String context) {
        if (modifier == null || context == null) return "DENIED";
        switch (modifier) {
            case "private": return context.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";
            case "default": return context.equals("SAME_CLASS") || context.equals("SAME_PACKAGE") ? "ALLOWED" : "DENIED";
            case "protected": return context.equals("SAME_CLASS") || context.equals("SAME_PACKAGE") ? "ALLOWED" : "DENIED";
            case "public": return context.equals("SAME_CLASS") || context.equals("SAME_PACKAGE") || context.equals("DIFFERENT_PACKAGE") ? "ALLOWED" : "DENIED";
            default: return "DENIED";
        }
    }
    static String summarizeByModifier(String[][] attempts) {
        int[] yes = new int[4], no = new int[4];
        if (attempts != null) for (String[] a : attempts) {
            if (a == null || a.length < 2) continue;
            int i = -1;
            for (int j = 0; j < 4; j++) if (MODIFIERS[j].equals(a[0])) i = j;
            if (i >= 0) { if (classifyAccess(a[0], a[1]).equals("ALLOWED")) yes[i]++; else no[i]++; }
        }
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < 4; i++) { if (i > 0) b.append(" | "); b.append(MODIFIERS[i]).append(": ").append(yes[i]).append(" allowed / ").append(no[i]).append(" denied"); }
        return b.toString();
    }
}
class LibraryMember {
    private String membershipPin;
    String branchCode;
    protected double finesOwed;
    public String displayName;
}
public class Main {
    public static void main(String[] args) {
        System.out.println(AccessChecker.classifyAccess("private", "SAME_CLASS"));
        System.out.println(AccessChecker.summarizeByModifier(new String[][]{
            {"private","SAME_CLASS"},{"private","SAME_PACKAGE"},{"default","SAME_PACKAGE"},
            {"default","DIFFERENT_PACKAGE"},{"protected","SAME_PACKAGE"},{"protected","SAME_CLASS"},{"public","DIFFERENT_PACKAGE"}
        }));
    }
}
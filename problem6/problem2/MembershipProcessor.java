public class MembershipProcessor {
    public static String classifyGeneration(GymMember member) {
        if (member instanceof EliteMember) {
            return "Multilevel descendant (3 generations deep)";
        }
        if (member instanceof GroupClassMember) {
            return "Hierarchical sibling (independent branch)";
        }
        return "Standard/Premium branch";
    }

    public static int getTotalSessionsAttended(GymMember[] members) {
        int total = 0;
        if (members != null) {
            for (GymMember member : members) {
                if (member != null) {
                    total += member.getSessionsAttended();
                }
            }
        }
        return total;
    }
}

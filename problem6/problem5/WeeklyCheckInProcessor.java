public class WeeklyCheckInProcessor {
    public static String processWeeklyCheckIn(GymMember[] members) {
        int processed = 0;
        int nullSkipped = 0;
        int group = 0;
        int individual = 0;

        if (members != null) {
            for (GymMember member : members) {
                if (member == null) {
                    nullSkipped++;
                    continue;
                }

                processed++;
                if (member instanceof GroupClassMember) {
                    group++;
                } else {
                    individual++;
                }
            }
        }

        return processed + " processed | "
                + nullSkipped + " null skipped | "
                + group + " group | "
                + individual + " individual";
    }
}

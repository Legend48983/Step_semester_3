public class LaundryService {
    public static String startWash(Student student, WashingMachine machine, WashType washType) {
        WashCycle cycle = machine.startWash(student, washType);
        if (cycle == null) {
            return "Machine " + machine.getMachineId() + " is currently busy.";
        }

        return cycle.getWashType().getName() + " wash started on "
                + machine.getMachineId() + " for " + student.getName()
                + " (" + cycle.getDurationMinutes() + " min). Charge: ₹"
                + String.format("%.2f", cycle.getCharge());
    }

    public static String completeWash(WashingMachine machine) {
        WashCycle cycle = machine.completeCycle();
        if (cycle == null) {
            return "Machine " + machine.getMachineId() + " is already free.";
        }
        cycle.markCompleted();
        return "Machine " + machine.getMachineId() + " cycle completed. "
                + machine.getMachineId() + " is now free.";
    }
}

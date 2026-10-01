public class WashingMachine {
    private final String machineId;
    private WashCycle currentCycle;

    public WashingMachine(String machineId) {
        if (machineId == null || machineId.trim().isEmpty()) {
            throw new IllegalArgumentException("Machine ID cannot be blank");
        }
        this.machineId = machineId;
    }

    public String getMachineId() {
        return machineId;
    }

    public boolean isFree() {
        return currentCycle == null;
    }

    public WashCycle startWash(Student student, WashType washType) {
        if (!isFree()) {
            return null;
        }
        currentCycle = new WashCycle(student, this, washType);
        return currentCycle;
    }

    public WashCycle completeCycle() {
        WashCycle completed = currentCycle;
        currentCycle = null;
        return completed;
    }
}

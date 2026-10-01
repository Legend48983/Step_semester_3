public class WashCycle {
    private final Student student;
    private final WashingMachine machine;
    private final WashType washType;
    private boolean completed;

    public WashCycle(Student student, WashingMachine machine, WashType washType) {
        if (student == null || machine == null || washType == null) {
            throw new IllegalArgumentException("Student, machine and wash type are required");
        }
        this.student = student;
        this.machine = machine;
        this.washType = washType;
    }

    public Student getStudent() { return student; }
    public WashingMachine getMachine() { return machine; }
    public WashType getWashType() { return washType; }
    public boolean isCompleted() { return completed; }

    void markCompleted() {
        completed = true;
    }

    public double getCharge() {
        return washType.getCharge();
    }

    public int getDurationMinutes() {
        return washType.getDurationMinutes();
    }
}

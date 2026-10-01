import java.time.LocalDate;

public class WrittenAssignment extends Assignment {
    public WrittenAssignment(String title, int maxMarks, LocalDate dueDate) {
        super(title, maxMarks, dueDate);
    }

    @Override
    public double applyLatePenalty(double awardedMarks, long lateDays) {
        return awardedMarks * Math.max(0.0, 1.0 - 0.20 * lateDays);
    }
}

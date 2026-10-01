import java.time.LocalDate;

public class CodingAssignment extends Assignment {
    public CodingAssignment(String title, int maxMarks, LocalDate dueDate) {
        super(title, maxMarks, dueDate);
    }

    @Override
    public double applyLatePenalty(double awardedMarks, long lateDays) {
        return awardedMarks * Math.max(0.0, 1.0 - 0.10 * lateDays);
    }
}

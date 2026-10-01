import java.time.LocalDate;

public abstract class Assignment {
    private final String title;
    private final int maxMarks;
    private final LocalDate dueDate;

    protected Assignment(String title, int maxMarks, LocalDate dueDate) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be blank");
        }
        if (maxMarks <= 0 || dueDate == null) {
            throw new IllegalArgumentException("Invalid assignment details");
        }
        this.title = title;
        this.maxMarks = maxMarks;
        this.dueDate = dueDate;
    }

    public String getTitle() { return title; }
    public int getMaxMarks() { return maxMarks; }
    public LocalDate getDueDate() { return dueDate; }

    public abstract double applyLatePenalty(double awardedMarks, long lateDays);
}

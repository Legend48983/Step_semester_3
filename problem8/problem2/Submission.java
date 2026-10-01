import java.time.LocalDate;

public class Submission {
    public enum Status { SUBMITTED, GRADED }

    private final Student student;
    private final Assignment assignment;
    private final LocalDate submissionDate;
    private Status status;
    private Double finalMarks;

    public Submission(Student student, Assignment assignment, LocalDate submissionDate) {
        if (student == null || assignment == null || submissionDate == null) {
            throw new IllegalArgumentException("Submission details are required");
        }
        this.student = student;
        this.assignment = assignment;
        this.submissionDate = submissionDate;
        this.status = Status.SUBMITTED;
    }

    public void grade(double awardedMarks) {
        if (status == Status.GRADED) {
            throw new IllegalStateException("Submission is already graded");
        }
        if (awardedMarks < 0 || awardedMarks > assignment.getMaxMarks()) {
            throw new IllegalArgumentException("Marks must be between 0 and maximum marks");
        }

        long lateDays = Math.max(0, java.time.temporal.ChronoUnit.DAYS.between(
                assignment.getDueDate(), submissionDate));
        finalMarks = assignment.applyLatePenalty(awardedMarks, lateDays);
        status = Status.GRADED;
    }

    public boolean canResubmit() {
        return status != Status.GRADED;
    }

    public Student getStudent() { return student; }
    public Assignment getAssignment() { return assignment; }
    public LocalDate getSubmissionDate() { return submissionDate; }
    public Status getStatus() { return status; }
    public Double getFinalMarks() { return finalMarks; }

    public long getLateDays() {
        return Math.max(0, java.time.temporal.ChronoUnit.DAYS.between(
                assignment.getDueDate(), submissionDate));
    }
}

import java.time.LocalDate;

public class SubmissionPortal {
    public static Submission submit(Student student, Assignment assignment, LocalDate date) {
        return new Submission(student, assignment, date);
    }
}

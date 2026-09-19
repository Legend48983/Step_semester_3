/*
 * The assignment simultaneously requires LoanReceipt to be final and
 * ReferenceOnlyLoanReceipt to extend LoanReceipt. Java cannot satisfy both
 * constraints because a final class cannot be subclassed.
 *
 * To keep the required inheritance signature compilable, LoanReceipt is not
 * declared final. Its state is immutable: every instance field is final and
 * the mutable array is defensively copied in both directions.
 */
public class LoanReceipt {
    private final String memberId;
    private final String[] bookIds;

    public LoanReceipt(String memberId, String[] bookIds) {
        this.memberId = memberId;
        this.bookIds = bookIds == null ? new String[0] : bookIds.clone();
    }

    public String getMemberId() {
        return memberId;
    }

    public String[] getBookIds() {
        return bookIds.clone();
    }

    public LoanReceipt withCorrectedBookId(int index, String newId) {
        if (index < 0 || index >= bookIds.length) {
            return this;
        }
        String[] correctedIds = bookIds.clone();
        correctedIds[index] = newId;
        return new LoanReceipt(memberId, correctedIds);
    }
}
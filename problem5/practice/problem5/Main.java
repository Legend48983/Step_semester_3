import java.util.Arrays;
class LoanReceipt {
    private final String memberId;
    private final String[] bookIds;
    LoanReceipt(String memberId, String[] ids) { this.memberId = memberId; this.bookIds = ids == null ? new String[0] : ids.clone(); }
    String getMemberId() { return memberId; }
    String[] getBookIds() { return bookIds.clone(); }
    LoanReceipt withCorrectedBookId(int index, String id) {
        if (index < 0 || index >= bookIds.length) return this;
        String[] copy = bookIds.clone(); copy[index] = id;
        return new LoanReceipt(memberId, copy);
    }
}
class ReferenceOnlyLoanReceipt extends LoanReceipt {
    private final String roomNumber;
    ReferenceOnlyLoanReceipt(String member, String[] ids, String room) { super(member, ids); roomNumber = room; }
    String getRoomNumber() { return roomNumber; }
}
class CirculationLedger {
    private static final String BRANCH_CODE;
    static { BRANCH_CODE = "PT-MAIN"; }
    static String processNightlyCirculation(LoanReceipt[] receipts) {
        int processed = 0, skipped = 0, reference = 0, regular = 0;
        if (receipts != null) for (LoanReceipt r : receipts) {
            if (r == null) { skipped++; continue; }
            processed++;
            if (r instanceof ReferenceOnlyLoanReceipt) reference++; else regular++;
        }
        return processed + " processed | " + skipped + " null skipped | " + reference + " reference-only | " + regular + " regular";
    }
}
public class Main {
    public static void main(String[] args) {
        String[] ids = {"B1","B2"};
        LoanReceipt first = new LoanReceipt("M1", ids);
        ids[0] = "CHANGED";
        System.out.println(Arrays.toString(first.getBookIds()));
        LoanReceipt corrected = first.withCorrectedBookId(1, "B9");
        System.out.println(Arrays.toString(corrected.getBookIds()));
        System.out.println(CirculationLedger.processNightlyCirculation(new LoanReceipt[]{first, new ReferenceOnlyLoanReceipt("M2", new String[]{"R1"}, "R-2"), null}));
    }
}
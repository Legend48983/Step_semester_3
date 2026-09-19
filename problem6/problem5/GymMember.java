public class GymMember {
    private static int membersEnrolled = 2000;

    public final String membershipNumber;
    private final int monthlyFee;
    private int feesPaid;
    private String lastPaymentMode;

    public GymMember(int monthlyFee) {
        if (monthlyFee <= 0) {
            throw new IllegalArgumentException("monthlyFee must be positive");
        }
        membersEnrolled++;
        membershipNumber = "GYM-" + membersEnrolled;
        this.monthlyFee = monthlyFee;
    }

    public void payFee(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be positive");
        }
        feesPaid += amount;
    }

    public void payFee(int amount, String mode) {
        lastPaymentMode = mode;
        payFee(amount);
    }

    public int getFeesPaid() {
        return feesPaid;
    }

    public String getLastPaymentMode() {
        return lastPaymentMode;
    }

    public int getMonthlyFee() {
        return monthlyFee;
    }

    public static boolean isValidReferralCode(String code) {
        if (code == null || code.length() != 4) {
            return false;
        }
        return code.charAt(0) == 'G'
                && Character.isDigit(code.charAt(1))
                && Character.isDigit(code.charAt(2))
                && Character.isUpperCase(code.charAt(3));
    }

    public static int getMembersEnrolled() {
        return membersEnrolled - 2000;
    }
}

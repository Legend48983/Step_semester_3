public class GymMember {
    private final String memberId;
    private final int monthlyFee;
    private int sessionsAttended;
    private final int[] lateFeeHistory = new int[10];
    private int lateFeeCount;

    public GymMember(String memberId, int monthlyFee) {
        if (memberId == null || memberId.trim().length() < 4) {
            throw new IllegalArgumentException("memberId must be at least 4 characters");
        }
        if (monthlyFee <= 0) {
            throw new IllegalArgumentException("monthlyFee must be positive");
        }
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
    }

    public void attendSession() {
        sessionsAttended++;
    }

    public int getSessionsAttended() {
        return sessionsAttended;
    }

    protected void chargeLateFee(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be positive");
        }
        if (lateFeeCount < lateFeeHistory.length) {
            lateFeeHistory[lateFeeCount++] = amount;
        }
    }

    public int[] getLateFeeHistory() {
        int[] copy = new int[lateFeeCount];
        System.arraycopy(lateFeeHistory, 0, copy, 0, lateFeeCount);
        return copy;
    }

    public int getTotalLateFees() {
        int total = 0;
        for (int i = 0; i < lateFeeCount; i++) {
            total += lateFeeHistory[i];
        }
        return total;
    }
}

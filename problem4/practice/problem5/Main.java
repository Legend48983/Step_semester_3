class FeeAccount {
    public void pay(double amount) {
        System.out.println("Paid in one go (day-scholar account)");
    }
}

class HostelFeeAccount extends FeeAccount {
    public void payInInstallments(double amount) {
        System.out.println("Paid in two installments (hostel account)");
    }
}

public class Main {
    public static int hostelCount = 0;
    public static int dayScholarCount = 0;

    public static void processPayment(FeeAccount account, double amount) {
        if (account instanceof HostelFeeAccount) {
            HostelFeeAccount hostelAccount = (HostelFeeAccount) account;
            hostelAccount.payInInstallments(amount);
            hostelCount++;
        } else {
            account.pay(amount);
            dayScholarCount++;
        }
    }

    public static void main(String[] args) {
        FeeAccount[] accounts = {
            new HostelFeeAccount(),
            new HostelFeeAccount(),
            new FeeAccount(),
            new FeeAccount()
        };

        for (FeeAccount account : accounts) {
            processPayment(account, 60000);
        }

        System.out.println("Hostel accounts processed: " + hostelCount
                + " | Day-scholar accounts processed: " + dayScholarCount);
    }
}

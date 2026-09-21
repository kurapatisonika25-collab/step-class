class PiggyBank {
    private double savings;
    private final String id;

    PiggyBank(String id) {
        this.id = id;
        savings = 0;
    }

    void deposit(double amount) {
        savings += amount;
        System.out.println("Deposited: " + amount + " -> savings = " + savings);
    }

    void withdraw(double amount) {
        if (amount > savings) {
            System.out.println("Withdrawal rejected -> savings = " + savings);
        } else {
            savings -= amount;
            System.out.println("Withdrawn: " + amount + " -> savings = " + savings);
        }
    }

    double getSavings() {
        return savings;
    }

    String getId() {
        return id;
    }
}

public class W7PPQ1 {
    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");

        pb.deposit(100);
        pb.withdraw(30);
        pb.withdraw(500);

        System.out.println("Final savings: " + pb.getSavings());
    }
}
package mybank;

public class OverDraftAmountException extends Exception {
    private double amount;

    public OverDraftAmountException(double amount, String message) {
        super(message);
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
package mybank;

public class CheckingAccount extends Account {
    private double creditLimit;

    public CheckingAccount(String accountType, double balance, double creditLimit) {
        super(accountType, balance);
        this.creditLimit = creditLimit;
    }

    @Override
    public boolean withdraw(double amt) throws OverDraftAmountException {
        if (amt > balance + creditLimit) {
            throw new OverDraftAmountException(amt, "Insufficient funds");
        }
        balance -= amt;
        return true;
    }

    public double getCreditLimit() {
        return creditLimit;
    }
}
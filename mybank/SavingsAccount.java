package mybank;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountType, double balance, double interestRate) {
        super(accountType, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public boolean withdraw(double amt) throws OverDraftAmountException {
        if (amt > balance) {
            throw new OverDraftAmountException(amt, "Insufficient funds");
        }
        balance -= amt;
        return true;
    }
}
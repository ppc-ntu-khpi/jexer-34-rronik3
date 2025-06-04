package mybank;

public abstract class Account {

    protected double balance;
    protected String accountType; // Додаємо поле для типу рахунку

    protected Account(String accountType, double balance) {
        this.accountType = accountType;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() { // Додаємо метод для отримання типу рахунку
        return accountType;
    }

    public boolean deposit(double amt) {
        balance = balance + amt;
        return true;
    }

    public abstract boolean withdraw(double amt) throws OverDraftAmountException;

}

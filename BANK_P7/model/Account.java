package model;

import model.annotation.Id;
import model.annotation.Positive;
import model.annotation.MaxLength;

public abstract class Account implements Transactable, InterestBearing {
    @Id
    private final String accountNumber;
    @MaxLength(30)
    private String ownerName;
    @Positive
    private long balance;
    private boolean active;

    private static int counter = 0;

    public Account(String ownerName, long balance) {
        counter++;
        accountNumber = "AC" + String.format("%04d", counter);
        this.ownerName = ownerName;
        this.balance = balance;
        active = true;
    }

    public Account(String ownerName) {
        this(ownerName, 0);
    }

    public void deposit(long amount) {
        if (amount > 0) {
            balance = balance + amount;
        }
    }

    public boolean withdraw(long amount) {
        if (canWithdraw(amount)) {
            balance = balance - amount;
            return true;
        }
        return false;
    }

    public abstract double interestRate();

    public abstract boolean canWithdraw(long amount);

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public long getBalance() {
        return balance;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public String toString() {
        return accountNumber + " | " + ownerName + " | " + balance;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Account) {
            Account a = (Account) o;
            return accountNumber.equals(a.accountNumber);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return accountNumber.hashCode();
    }
}

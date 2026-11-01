package service;

import model.Account;
import exception.BankException;

public class TransferService {

    public static void transfer(Account from, Account to, long amount)
            throws BankException {

        Account first = from;
        Account second = to;

        if (from.getAccountNumber().compareTo(to.getAccountNumber()) > 0) {
            first = to;
            second = from;
        }

        synchronized (first) {
            synchronized (second) {
                from.withdraw(amount);
                to.deposit(amount);
                System.out.println(Thread.currentThread().getName() + " transfer completed");
            }
        }
    }
}

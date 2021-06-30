package com.techelevator;

public class CreditCardAccount implements Accountable {
    private final String accountHolder;
    private final String accountNumber;
    private int debt = 0;

    public CreditCardAccount(String accountHolder, String accountNumber) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getDebt() {
        return debt;
    }

    public int pay(int amountToPay) {
        this.debt -= amountToPay;
        return debt;
    }

    public int charge(int amountToCharge) {
        this.debt += amountToCharge;
        return debt;
    }

    @Override
    public int getBalance() {
        return -debt;
    }

    @Override
    public int transferTo(BankAccount destinationAccount, int transferAmount) {
        return 0;
    }
}

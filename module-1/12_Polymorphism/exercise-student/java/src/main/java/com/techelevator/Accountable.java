package com.techelevator;

public interface Accountable {
    public int getBalance();
    public int transferTo(BankAccount destinationAccount, int transferAmount);
}

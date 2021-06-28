package com.techelevator;
import com.techelevator.BankAccount;

public class CheckingAccount extends BankAccount {

    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    @Override
    public int withdraw(int amountToWithdraw) {
        double potentialBalance = this.balance - amountToWithdraw;
        if (potentialBalance > -100) {
            this.balance -= amountToWithdraw;
            if (this.balance < 0) {
                this.balance -= 10;
            }
        }
        return balance;
    }
}

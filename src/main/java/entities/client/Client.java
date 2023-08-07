package entities.client;

import entities.loan.Loan;

public interface Client {

    String offer(double amount, int months);
    String newLoan(double amountLoan, int periodInMonths);
    void payment();
    String getName();
    Loan getLoan();
}

package entities.loan;

import entities.loan_calculator.LoanCalculator;

public class LoanImpl implements Loan {

    private LoanCalculator loanCalculator;
    private double amountLoan;
    private double interestRate;
    private int periodInMonths;

    @Override
    public void payment(double amountForPayment) {

    }

    @Override
    public void remodeling(double amountLeft, double interestRate, int periodInMonths) {

    }
}

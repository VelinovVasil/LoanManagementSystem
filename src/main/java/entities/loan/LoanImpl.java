package entities.loan;

import constants.InterestRate;

public class LoanImpl implements Loan {
    private double amountLoan;
    private double interestRate;
    private int periodInMonths;
    private double amountForPayment;

    public LoanImpl(double amountLoan, int periodInMonths) {
        this.setAmountLoan(amountLoan);
        this.setPeriodInMonths(periodInMonths);

        double monthlyInterestRate = InterestRate.INTEREST_RATE / 12.0;

        this.amountForPayment = (this.amountLoan * monthlyInterestRate)
                / (1 - Math.pow(1 + monthlyInterestRate, -this.periodInMonths));

        this.payment();
    }

    private void setAmountLoan(double amountLoan) {
        if (amountLoan <= 0) {
            throw new IllegalArgumentException("Amount cannot be below or equal to zero.");
        }
        this.amountLoan = amountLoan;
    }

    private void setPeriodInMonths(int periodInMonths) {
        if (periodInMonths <= 0) {
            throw new IllegalArgumentException("Period cannot be below or equal to zero.");
        }
        this.periodInMonths = periodInMonths;
    }

    @Override
    public String payment() {
        if (this.amountLoan - this.amountForPayment <= 0) {

            this.amountLoan = 0;
            return String.format("Your loan is being paid!");

        }

        this.amountLoan -= amountForPayment;

        return String.format("Successfully paid %.2f as a monthly payment for your loan.", this.amountForPayment);
    }

    @Override
    public double getAmountForPayment() {
        return this.amountForPayment;
    }

    @Override
    public boolean isPaid() {
        if (this.amountLoan <= 0) {
            return true;
        }
        return false;
    }


}

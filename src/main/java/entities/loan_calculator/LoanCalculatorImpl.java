package entities.loan_calculator;

import constants.InterestRate;

public class LoanCalculatorImpl implements LoanCalculator{

    private double amount;
    private int months;

    public LoanCalculatorImpl(double amount, int months) {
        this.setAmount(amount);
        this.setMonths(months);
    }

    private void setAmount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount should be a positive number.");
        }
        this.amount = amount;
    }

    private void setMonths(int months) {
        if (months <= 0) {
            throw new IllegalArgumentException("Months should be a positive number.");
        }
        this.months = months;
    }

    @Override
    public String calculate() {

        double monthlyInterestRate = InterestRate.INTEREST_RATE / 12.0;

        double monthlyPayment = (this.amount * monthlyInterestRate)
                / (1 - Math.pow(1 + monthlyInterestRate, -this.months));

        return String.format("Your monthly payment is %.2f for %d", monthlyPayment, this.months);
    }
}

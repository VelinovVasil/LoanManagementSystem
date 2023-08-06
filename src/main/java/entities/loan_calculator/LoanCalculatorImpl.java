package entities.loan_calculator;

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
        return null;
    }
}

package entities.client;

import entities.loan.Loan;
import entities.loan.LoanImpl;
import entities.loan_calculator.LoanCalculator;
import entities.loan_calculator.LoanCalculatorImpl;

public class ClientImpl implements Client {

    private String name;
    private String ID;
    private Loan loan;
    private double funds;

    public ClientImpl(String name, String ID, double funds) {
        this.setName(name);
        this.setID(ID);
        this.setFunds(funds);
    }

    private void setName(String name) {
        if (name == null || name.equals(" ")) {
            throw new NullPointerException("Name cannot be null or empty.");
        }
        this.name = name;
    }

    private void setFunds(double funds) {
        if (funds <= 0) {
            throw new IllegalArgumentException("Funds should be a positive number.");
        }
        this.funds = funds;
    }

    private void setID(String ID) {
        if (ID == null || ID.equals(" ")) {
            throw new NullPointerException("ID cannot be null or empty.");
        }
        this.ID = ID;
    }


    @Override
    public String offer(double amount, int months) {

        LoanCalculator loanCalculator = new LoanCalculatorImpl(amount, months);

        return loanCalculator.calculate();
    }

    @Override
    public String newLoan(double amountLoan, int periodInMonths) {

        Loan loan = new LoanImpl(amountLoan, periodInMonths);

        this.loan = loan;

        this.payment();

        return "Your new loan is being created. The first payment is now paid.";
    }

    @Override
    public void payment() {
        if (this.funds - this.loan.getAmountForPayment() <= 0) {
            throw new IllegalStateException("Insufficient funds to make a monthly payment.");
        }

        this.funds -= this.loan.getAmountForPayment();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Loan getLoan() {
        return this.loan;
    }


}

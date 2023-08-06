package entities.loan;

public interface Loan {

    void payment(double amountForPayment);
    void remodeling(double amountLeft, double interestRate, int periodInMonths);

}

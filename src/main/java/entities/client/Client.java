package entities.client;

public interface Client {

    String offer(double amount, int months);
    String newLoan(double amountLoan, int periodInMonths);
    void payment();
    String getName();
}

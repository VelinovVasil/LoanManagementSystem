package controller;

public interface Controller {

    String addClient(String name, String ID, double funds);
    String removeClient(String name);
    String offer(String clientName, double amount, int months);
    String newLoan(String clientName, double amountLoan, int periodInMonths);
    String monthlyPayment(String clientName);

}

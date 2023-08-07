package controller;

import entities.client.Client;
import entities.client.ClientImpl;
import repositories.ClientRepository;

public class ControllerImpl implements Controller {

    private ClientRepository clientRepository;

    public ControllerImpl() {
        this.clientRepository = new ClientRepository();
    }

    @Override
    public String addClient(String name, String ID, double funds) {

        Client client = new ClientImpl(name, ID, funds);
        this.clientRepository.addClient(client);

        return String.format("Successfully added %s as a new client.", name);
    }

    @Override
    public String removeClient(String name) {

        this.clientRepository.removeClient(this.clientRepository.findByName(name));

        return String.format("Successfully added %s as a new client.", name);
    }

    @Override
    public String offer(String clientName, double amount, int months) {

        return this.clientRepository.findByName(clientName).offer(amount, months);
    }

    @Override
    public String newLoan(String clientName, double amountLoan, int periodInMonths) {

        if (this.clientRepository.findByName(clientName).getLoan() != null) {

            throw new IllegalStateException("This client has an unpaid loan!");

        }

        return this.clientRepository.findByName(clientName).newLoan(amountLoan, periodInMonths);

    }

    @Override
    public String monthlyPayment(String clientName) {

        this.clientRepository.findByName(clientName).payment();

        if (this.clientRepository.findByName(clientName).getLoan().isPaid()) {

            return "This was the last payment. Your loan is now paid.";

        }
        return this.clientRepository.findByName(clientName).getLoan().payment();
    }
}

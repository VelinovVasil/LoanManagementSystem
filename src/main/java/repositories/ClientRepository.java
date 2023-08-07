package repositories;

import entities.client.Client;

import java.util.LinkedHashMap;
import java.util.Map;

public class ClientRepository implements Repository{

    private Map<String, Client> clients;

    public ClientRepository() {
        this.clients = new LinkedHashMap<>();
    }

    @Override
    public void addClient(Client client) {
        this.clients.put(client.getName(), client);
    }

    @Override
    public void removeClient(Client client) {
        this.clients.remove(client.getName());
    }

    @Override
    public Client findByName(String name) {
        return this.clients.get(name);
    }
}

package repositories;

import entities.client.Client;

public interface Repository {

    void addClient(Client client);
    void removeClient(Client client);
    Client findByName(String name);

}

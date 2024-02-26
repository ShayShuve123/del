package com.example.myfragapp.classes;

import java.util.ArrayList;

public class ClientsData {
    private static ClientsData instance;

    private ArrayList<Clients> clients;

    public ClientsData() {
        clients = new ArrayList<>();
    }
    //singleton pattern--> ClientsData.getInstance() to get the single instance of ClientsData and then add clients or access the list of clients.
    public static ClientsData getInstance() {
        if (instance == null) {
            instance = new ClientsData();
        }
        return instance;
    }

    public ArrayList<Clients> getClients() {
        return clients;
    }

    public void addClient(Clients client) {
        clients.add(client);
    }

    public boolean ifExist(Clients client) {

        for (Clients c : clients) {
            if (c.getPassword().equals(client.getPassword()) || c.getPhone().equals(client.getPhone()) || c.getUsername().equals(client.getUsername())) {
                return true;
            }
        }
        return false;
    }
    public Clients findUserByUsername(String username) {
        for (Clients c : clients) {
            if (c.getUsername().equals(username)) {
                return c;
            }
        }
        return null;
    }


}

package se.lexicon.Model;

import java.time.LocalDate;
import java.util.Arrays;

public class SalesPerson extends Employee {
    //Fields
    private String[] clients;//500

    private String[] aquiredClients;//1000


    //Constructors

    public SalesPerson(String name, LocalDate dateHired) {
        super(name, dateHired);
        clients = new String[0];
        aquiredClients = new String[0];

    }

    //Setters

    //Getters

    public String[] getClients() {
        return clients;
    }

    public String[] getAquiredClients() {
        return aquiredClients;
    }


    //Methods

    @Override
    public void calculateSalary() {
        double totalSalary;
        totalSalary = Salary.BASESALARY.getSalary() + ((500 * clients.length) + (1000 * aquiredClients.length));
        super.setSalary(totalSalary);


    }

    // Method to add a maintained client
    public void addClient(String clientName) {
        if (clientName == null || clientName.trim().isEmpty()) {
            throw new IllegalArgumentException("clientName cannot be null or empty");
        }

        for (String existingClient : clients) {
            if (existingClient.equals(clientName)) {
                throw new IllegalArgumentException("Client '" + clientName + "' already exists");
            }
        }

        String[] newClients = Arrays.copyOf(clients, clients.length + 1);
        newClients[newClients.length - 1] = clientName;
        clients = newClients;

        calculateSalary();
    }


    // Method to add a newly acquired client
    public void addAcquiredClient(String clientName) {
        if (clientName == null || clientName.trim().isEmpty()) {
            throw new IllegalArgumentException("clientName cannot be null or empty");
        }

        for (String existingClient : aquiredClients) {
            if (existingClient.equals(clientName)) {
                throw new IllegalArgumentException("Client '" + clientName + "' already exists");
            }
        }


        String[] newClients = Arrays.copyOf(aquiredClients, aquiredClients.length + 1);
        newClients[newClients.length - 1] = clientName;
        aquiredClients = newClients;

        calculateSalary();
    }

    public void removeClients(String clientName) {
        //Todo: validation
        if (clientName == null || clientName.trim().isEmpty()) {
            throw new IllegalArgumentException("Client name cannot be null or empty");
        }

        //Remove from string
        String[] removeClient = new String[clients.length - 1];
        int index = 0;
        for (String name : clients) {
            if (!name.equalsIgnoreCase(clientName)) {
                removeClient[index++] = name;
            }
        }
        clients=removeClient;
        calculateSalary();
    }

    public void removeAquiredClients(String clientName) {
        if (clientName == null || clientName.trim().isEmpty()) {
            throw new IllegalArgumentException("Client name cannot be null or empty");
        }

        //Remove from string
        String[] removeClient = new String[aquiredClients.length - 1];
        int index = 0;
        for (String name : aquiredClients) {
            if (!name.equalsIgnoreCase(clientName)) {
                removeClient[index++] = name;
            }
        }
        aquiredClients=removeClient;
        calculateSalary();
    }

    // Override the toString() method to include information about clients
    @Override
    public String toString() {
        return "ID: " + getId() + "\n" +
                "Name: " + getName() + "\n" +
                "DateHired: " + getDateHired() + "\n" +
                "Clients: " + clients.length + "\n" +
                "Acquired Clients: " + aquiredClients.length + "\n" +
                "Salary: " + getSalary();
    }
}



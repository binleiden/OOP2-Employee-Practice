package se.lexicon.Model;

import java.time.LocalDate;

public abstract class Employee {
    //Fields
    private int sequencer = 0;
    private int id;
    private String name;
    private double salary;
    private LocalDate dateHired;


    //Constructors
    public Employee(String name, LocalDate dateHired) {
        setName(name);
        setDateHired(dateHired);
        this.salary = Salary.BASESALARY.getSalary();
        this.id = nextId();
    }
    //Setters

    public int nextId() {
        return ++sequencer;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Firstname cannot be null or empty");
        }
        this.name = name;
    }

    public void setDateHired(LocalDate dateHired) {
        this.dateHired = LocalDate.now();
    }

    //Getters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getDateHired() {
        return dateHired;
    }

    //Methods

    public abstract void calculateSalary();

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", DateHired: " + dateHired + ", Salary:" + salary;
    }
}

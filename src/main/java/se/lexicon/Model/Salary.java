package se.lexicon.Model;

public enum Salary {
    BASESALARY(25000);
    private final double salary;
    Salary(double salary){
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}

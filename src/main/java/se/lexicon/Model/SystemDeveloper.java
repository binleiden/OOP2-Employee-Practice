package se.lexicon.Model;

import java.time.LocalDate;
import java.util.Arrays;

public class SystemDeveloper extends Employee{

    //Fields
    private static String[] certificate;//1000

    private static String[] programmingLanguages;//1500
    //Constructors


    public SystemDeveloper(String name, LocalDate dateHired) {
        super(name, dateHired);
        certificate = new String[0];
        programmingLanguages = new String[0];
    }

    //Setters

    //Getters

    //Methods
    @Override
        public void calculateSalary() {
            double totalSalary;
            totalSalary = Salary.BASESALARY.getSalary() +((1000* certificate.length)+(1500*programmingLanguages.length));
            super.setSalary(totalSalary);
        }
    // Method to add a maintained certificate
    public void addCertificate(String newCertificate){
        if (certificate == null && newCertificate.trim().isEmpty()){
            throw new IllegalArgumentException("Certificate cannot be null or empty.");
        }
        for (String certificate: certificate){
            if (newCertificate.equalsIgnoreCase(certificate)){
                throw new IllegalArgumentException("Certificate already exist.");
            }
        }

        String[] addCertificate = Arrays.copyOf(certificate, certificate.length +1);
        addCertificate[addCertificate.length -1] = newCertificate;
        certificate = addCertificate;

        calculateSalary();
    }

    // Method to add a programmingLanguages
    public void addProgrammingLanguages(String newProgrammingLanguages){
        if (programmingLanguages == null && newProgrammingLanguages.trim().isEmpty()){
            throw new IllegalArgumentException("Programminglanguage cannot be empty.");
        }
        for (String programmingLanguage: programmingLanguages){
            if (newProgrammingLanguages.equals(programmingLanguages)){
                throw new IllegalArgumentException("ProgrammingLanguage already exist.");
            }
        }
        String[] addProgrammingLanguage = Arrays.copyOf(programmingLanguages, programmingLanguages.length +1);
        addProgrammingLanguage[addProgrammingLanguage.length-1] = newProgrammingLanguages;
        programmingLanguages=addProgrammingLanguage;

        calculateSalary();
    }

    // Method to remove certificate

    public void removeCertificates(String certificateName){
        if (certificate == null && certificateName.trim().isEmpty()){
            throw new IllegalArgumentException("Certificate cannot be null or empty.");
        }

        String[] removeCertificate = new String[certificate.length -1];
        int index = 0;
        for (String certificate: certificate){
            if (!certificate.equalsIgnoreCase(certificateName)){
                removeCertificate[index++] = certificateName;
            }
        }
        certificate=removeCertificate;
        calculateSalary();

    }

    // Method to remove  programmingLanguages
    public void removeProgrammingLanguage(String languageToRemove){
        if (languageToRemove==null && languageToRemove.trim().isEmpty()){
            throw new IllegalArgumentException("ProgramingLanguage cannot be null och empty.");
        }
        String[] removeProgrammingLanguage = new String[programmingLanguages.length -1];
        int index = 0;
        for (String programmingLanguage : programmingLanguages){
            if (!programmingLanguage.equalsIgnoreCase(languageToRemove)){
                removeProgrammingLanguage[index++]=languageToRemove;
            }
        }
        programmingLanguages=removeProgrammingLanguage;
        calculateSalary();
    }
    @Override
    public String toString() {
        return "ID: " + getId() + "\n" +
                "Name: " + getName() + "\n" +
                "DateHired: " + getDateHired() + "\n" +
                "Certificates: " + certificate.length + "\n" +
                "Programming languages: " + programmingLanguages.length + "\n" +
                "Salary: " + getSalary();
    }
}

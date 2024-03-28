package se.lexicon;

import se.lexicon.Model.SalesPerson;
import se.lexicon.Model.SystemDeveloper;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        //salesperson
        SalesPerson salesperson1 = new SalesPerson("Daniel", LocalDate.now());
        System.out.println();
        //Add newly acquired client
        salesperson1.addAcquiredClient("Lena Olsson");
        //Add client
        salesperson1.addClient("Lennart Karlsson");
        salesperson1.addClient("Rolf Larsson");

        System.out.println(salesperson1.toString());
        System.out.println();
        // Remove client and newly acquired client
        salesperson1.removeClients("Lennart Karlsson");
        salesperson1.removeAcquiredClients("Lena Olsson");
        System.out.println(salesperson1.toString());

        //SystemDeveloper
        SystemDeveloper developer1 = new SystemDeveloper("Daniel Petersson", LocalDate.now());
        System.out.println();

        //Add Certificate
        developer1.addCertificate("AWS");
        developer1.addCertificate("Cloudera");

        //Add Programming language
        developer1.addProgrammingLanguages("Java");
        developer1.addProgrammingLanguages("Sql");
        System.out.println(developer1.toString());
        //Remove certificate and programming language
        developer1.removeCertificates("AWS");
        developer1.removeProgrammingLanguage("SQL");
        System.out.println(developer1.toString());
    }
}

package se.lexicon;

import se.lexicon.Model.SalesPerson;

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
        System.out.println(salesperson1.toString());
        System.out.println();

        salesperson1.addAcquiredClient("lennart");

        salesperson1.addClient("leffe");
        salesperson1.addClient("roffe");

        System.out.println(salesperson1.toString());
        System.out.println();

        salesperson1.removeClients("roffe");
        salesperson1.removeAquiredClients("lennart");
        System.out.println(salesperson1.toString());

    }
}

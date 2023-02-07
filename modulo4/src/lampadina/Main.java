package lampadina;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int scelta;
        Scanner scanner = new Scanner(System.in);
        Lampadina lampadina = new Lampadina();
        Interruttore interruttore1 = new Interruttore(lampadina);    //Associo la lampadina a questo interruttore
        Interruttore interruttore2 = new Interruttore(lampadina);    //Associo la stessa lampadina a quest'altro interruttore

        lampadina.ripristinaAlimentazione();        //Faccio in modo che ci sia corrente nell'impianto (vale per tutte le lampadine)
        System.out.println(lampadina.getStato());

        do {
            System.out.print("\n0 -> ESCI" +
                    "\n1 -> PREMI INTERRUTTORE 1" +
                    "\n2 -> PREMI INTERRUTTORE 2" +
                    "\nInserisci scelta: ");
            scelta = scanner.nextInt();

            if (scelta == 1) {
                interruttore1.premiInterruttore();
                System.out.println("\n" +lampadina.getStato());
            }
            else if (scelta == 2) {
                interruttore2.premiInterruttore();
                System.out.println("\n" +lampadina.getStato());
            }

        } while (scelta!=0);

        lampadina.interrompiAlimentazione();
        System.out.println("\n" +lampadina.getStato());
        lampadina.ripristinaAlimentazione();
        System.out.println("\n" +lampadina.getStato());
    }
}

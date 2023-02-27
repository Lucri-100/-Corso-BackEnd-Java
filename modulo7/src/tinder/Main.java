package tinder;

public class Main {
    public static void main(String[] args) {
        TinderLike tinder = new TinderLike();

        Utente u1 = new Utente("Gigi");
        Utente u2 = new Utente("Maria");
        Utente u3 = new Utente("Salvo");
        Utente u4 = new Utente("Monica");
        Utente u5 = new Utente("Pino");

        Interesse e1 = new Interesse(1, "sport");
        Interesse e2 = new Interesse(2, "dolci");
        Interesse e3 = new Interesse(3, "lettura");
        Interesse e4 = new Interesse(4, "giardinaggio");
        Interesse e5 = new Interesse(5, "musica");

        u1.addInteresse(e1);
        u1.addInteresse(e5);
        u1.addInteresse(e3);
        u2.addInteresse(e1);
        u2.addInteresse(e5);
        u3.addInteresse(e3);
        u3.addInteresse(e2);
        u4.addInteresse(e4);
        u4.addInteresse(e3);

        tinder.addUtente(u1);
        tinder.addUtente(u2);
        tinder.addUtente(u3);
        tinder.addUtente(u4);

        System.out.println(tinder.toString());
        System.out.println("----------------------------------------------------------");

        System.out.println(tinder.cercaUtenteConInteressiComuni(u1));
    }
}

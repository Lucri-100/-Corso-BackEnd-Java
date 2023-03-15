package turista_facoltoso.utenti;

import turista_facoltoso.Abitazione;
import turista_facoltoso.Feedback;
import java.util.HashSet;

public class Host extends Utente {
    private int codice_host;
    private boolean super_host = false;
    private HashSet<Abitazione> abitazioni = new HashSet<>(1);
    private HashSet<Feedback> feedback = new HashSet<>(1);


    public Host(String nome, String email, String indirizzo) {
        super(nome, email, indirizzo);
        codice_host = nome.hashCode() + email.hashCode();

        if (codice_host < 0)
            codice_host *= -1;
    }

    public int getCodiceHost() {
        return codice_host;
    }

    public void setSuperHost(boolean super_host) {
        this.super_host = super_host;
    }

    public boolean isSuperHost() {
        return super_host;
    }

    /**
     * Questo metodo permette di aggiungere l'abitazione all'host che invoca il metodo
     * @param abitazione abitazione da aggiungere in quelle messe a disposizione dall'host
     */
    public void aggiungiAbitazione(Abitazione abitazione) {
        abitazioni.add(abitazione);
    }

    /**
     * Questo metodo stampa tutte le abitazioni dell'host che invoca il metodo
     */
    public void mostraAbitazioni() {
        for (Abitazione abitazione : abitazioni)
            System.out.println(abitazione+ "\n");
    }

    public HashSet<Abitazione> getAbitazioni() {
        return abitazioni;
    }


    @Override
    public String toString() {
        return "Codice host: " +codice_host+ "\n" +super.toString();
    }
}
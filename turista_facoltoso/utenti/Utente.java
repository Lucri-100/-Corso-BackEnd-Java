package turista_facoltoso.utenti;

import turista_facoltoso.Prenotazione;
import java.util.LinkedHashSet;

public class Utente {
    protected int ID;
    protected String nome;
    protected String email;
    protected String indirizzo;
    private LinkedHashSet<Prenotazione> prenotazioni_effettuate = new LinkedHashSet<>();    //Questa collezione mantiene l'ordine di inserimento


    public Utente(String nome, String email, String indirizzo) {
        this.nome = nome;
        this.email = email;
        this.indirizzo = indirizzo;
        ID = email.hashCode();

        if (ID < 0)
            ID *= -1;
    }

    public String getNome() {
        return nome;
    }

    public void aggiungiPrenotazione(Prenotazione prenotazione) {
        prenotazioni_effettuate.add(prenotazione);
    }

    public LinkedHashSet<Prenotazione> getPrenotazioni() {
        return prenotazioni_effettuate;
    }

    public int getID() {
        return ID;
    }


    @Override
    public String toString() {
        return "ID: " +ID+ "\nNome: " +nome+ "\nEmail: " +email;
    }
}
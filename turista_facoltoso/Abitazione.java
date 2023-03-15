package turista_facoltoso;

import java.time.LocalDate;
import java.util.HashSet;

public class Abitazione {
    private int ID;
    private float prezzo;
    private String nome;
    private String indirizzo;
    private int numero_locali;
    private int posti_letto;
    private int piano;
    private LocalDate inizio_disponibilita;
    private LocalDate fine_disponibilita;
    private HashSet<Prenotazione> prenotazioni_ricevute = new HashSet<>(1);


    public Abitazione(String nome, String indirizzo, float prezzo, int numero_locali, int posti_letto, int piano, LocalDate inizio_disponibilita, LocalDate fine_disponibilita) {
        this.prezzo = prezzo;
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.numero_locali = numero_locali;
        this.posti_letto = posti_letto;
        this.piano = piano;
        this.inizio_disponibilita = inizio_disponibilita;
        this.fine_disponibilita = fine_disponibilita;
        ID = indirizzo.hashCode() + nome.hashCode();

        //Se l'ID è negativo, lo rendo positivo
        if (ID < 0)
            ID *= -1;
    }

    public int getID() {
        return ID;
    }

    public LocalDate getInizioDisponibilita() {
        return inizio_disponibilita;
    }

    public LocalDate getFineDisponibilita() {
        return fine_disponibilita;
    }

    public int getPosti_letto() {
        return posti_letto;
    }

    /**
     * Questo metodo permette di aggiungere una prenotazione per un'abitazione
     * @param prenotazione prenotazione che si vuole effettuare
     */
    public void aggiungiPrenotazione(Prenotazione prenotazione) {
        prenotazioni_ricevute.add(prenotazione);
    }

    /**
     * Questo metodo permette di accedere alle prenotazioni di un appartamento
     * @return restituisce la lista delle prenotazioni di una data abitazione
     */
    public HashSet<Prenotazione> getPrenotazioni() {
        return prenotazioni_ricevute;
    }


    @Override
    public String toString() {
        return "ID: " +ID+ "\nNome: " +nome+ "\nIndirizzo: " +indirizzo+ "\nPrezzo: " +prezzo+ "€\nPiano: " +piano+ "\nPosti letto: " +posti_letto;
    }
}
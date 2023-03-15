/* Un facoltoso turista americano ci ha chiesto di creare una piattaforma ispirata ad un famoso sito per affittare case vacanza. Tutti
 * possono registrarsi alla piattaforma e, se approvati come host, caricare una o più abitazioni e specificare un prezzo, un periodo (data di
 * inizio e data di fine) durante il quale l'abitazione è prenotabile da altri utenti. Ogni abitazione ha id, nome, indirizzo, numero di locali,
 * numero di posti letto e piano. Ogni utente ha nome cognome, email, indirizzo e ogni host ha un codice host. In più, un super-host è tale se
 * ha ricevuto, da quando si è registrato, almeno 100 prenotazioni. Di ogni prenotazione si deve mantenere un id univoco, le date di inizio e
 * fine, l'abitazione relativa e l'utente che ha soggiornato. Ogni utente che ha soggiornato presso un'abitazione può lasciare un feedback al
 * proprietario dell'abitazione. Ogni feedback ha un id, un titolo, un testo e un punteggio (da 1 a 5). Deve essere possibile effettuare le
 * seguenti operazioni nel sistema:
 * ottenere le abitazioni corrispondente ad un certo codice host
 * ottenere l'ultima prenotazione dato un id utente
 * ottenere l'abitazione più gettonata nell'ultimo mese
 * ottenere gli host con più prenotazioni nell'ultimo mese
 * ottenere tutti i super-host
 * ottenere i 5 utenti con più giorni prenotati nell'ultimo mese
 * ottenere il numero medio di posti letto calcolato in base a tutte le abitazioni caricate dagli host
 * Per le date e i periodi potete utilizzare java.time.LocalDateTime e java.time.Duration esempio: Period.between(aDate, sixtyDaysBehind).
 *
 * Nota: gestite tutto con le collection
 * Nota: inserire eccezioni dove pensate siano opportune
 */
package turista_facoltoso;

import turista_facoltoso.utenti.Utente;
import turista_facoltoso.utenti.Host;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Alcune date da utilizzare per istanziare le abitazioni
        LocalDate data1 = LocalDate.of(2023, 1, 10);
        LocalDate data2 = LocalDate.of(2023, 2, 27);
        LocalDate data3 = LocalDate.of(2023, 3, 6);
        LocalDate data4 = LocalDate.of(2023, 4, 19);
        LocalDate data5 = LocalDate.of(2023, 5, 22);
        LocalDate data6 = LocalDate.of(2023, 6, 30);

        //Date per effettuare le prenotazioni
        LocalDate data_1 = LocalDate.of(2023, 1, 11);
        LocalDate data_2 = LocalDate.of(2023, 2, 5);
        LocalDate data_3 = LocalDate.of(2023, 2, 20);
        LocalDate data_4 = LocalDate.of(2023, 3, 5);
        LocalDate data_5 = LocalDate.of(2023, 5, 30);

        LocalDate data_6 = LocalDate.of(2023, 2, 6);
        LocalDate data_7 = LocalDate.of(2023, 2, 13);
        LocalDate data_8 = LocalDate.of(2023, 2, 14);
        LocalDate data_9 = LocalDate.of(2023, 2, 16);

        LocalDate data_lontra1 = LocalDate.of(2023, 2, 17);
        LocalDate data_lontra2 = LocalDate.of(2023, 2, 25);

        //Il sito web attraverso il quale è possibile eseguire tutte le azioni
        SitoWeb sitoWeb = new SitoWeb();

        //I proprietari delle abitazioni
        Host host1 = new Host("Giuseppe", "dambone1@gmail.com", "Via Sicilia, 2");
        Host host2 = new Host("Lucrezia", "lucrezia2@gmail.com", "Via Non Lo So, 85");

        //Istanzio dei clienti
        Utente utente1 = new Utente("Michele1", "damone9@gmail.com", "Via bari, 8");
        Utente utente2 = new Utente("Michele2", "damone10@gmail.com", "Via bari, 9");
        Utente utente3 = new Utente("Michele3", "damone11@gmail.com", "Via bari, 10");

        Utente lontra1 = new Utente("Lontra1", "damone11@gmail.com", "Via bari, 10");
        Utente lontra2 = new Utente("Lontra2", "damone11@gmail.com", "Via bari, 10");
        Utente lontra3 = new Utente("Lontra3", "damone11@gmail.com", "Via bari, 10");

        //Le abitazioni che saranno poi associate ai vari host
        Abitazione abitazione1 = new Abitazione("ab1", "Via uno, 1", 20, 4, 8, 0, data1, data6);
        Abitazione abitazione2 = new Abitazione("ab2", "Via due, 2", 18, 2, 1, 3, data1, data6);
        Abitazione abitazione3 = new Abitazione("ab3", "Via tre, 3", 25, 1, 2, 1, data3, data6);
        Abitazione abitazione4 = new Abitazione("ab4", "Via four, 4", 30, 3, 6, 3, data4, data6);

        //Creo delle prenotazioni
        Prenotazione prenotazione1 = new Prenotazione(abitazione1.getID(), utente1.getID(), data_1, data_2);
        Prenotazione prenotazione2 = new Prenotazione(abitazione1.getID(), utente1.getID(), data_3, data_4);
//        Prenotazione prenotazione3 = new Prenotazione(abitazione2.getID(), utente1.getID(), data_1, data_2);
        Prenotazione prenotazione4 = new Prenotazione(abitazione1.getID(), utente1.getID(), data_3, data_4);

        Prenotazione prenotazione5 = new Prenotazione(abitazione1.getID(), utente2.getID(), data_6, data_7);
        Prenotazione prenotazione6 = new Prenotazione(abitazione1.getID(), utente3.getID(), data_8, data_9);

        //Prenotazioni delle lontre
        Prenotazione prenotazione7 = new Prenotazione(abitazione2.getID(), lontra1.getID(), data_6, data_7);
        Prenotazione prenotazione8 = new Prenotazione(abitazione2.getID(), lontra2.getID(), data_8, data_9);
        Prenotazione prenotazione9 = new Prenotazione(abitazione2.getID(), lontra3.getID(), data_lontra1, data_lontra2);

        //Associo alcune abitazioni agli host
        host1.aggiungiAbitazione(abitazione1);
        host1.aggiungiAbitazione(abitazione2);
        host1.aggiungiAbitazione(abitazione4);
        host2.aggiungiAbitazione(abitazione3);

        //Aggiungo l'host al sito web e stampo le sue abitazioni
        sitoWeb.aggiungiHostAlSito(host1);
        sitoWeb.stampaAbitazioni(host1.getCodiceHost());

        //Registro l'utente al sito web
        sitoWeb.aggiungiUtenteAlSito(utente1);
        sitoWeb.aggiungiUtenteAlSito(utente2);
        sitoWeb.aggiungiUtenteAlSito(utente3);
        sitoWeb.aggiungiUtenteAlSito(lontra1);
        sitoWeb.aggiungiUtenteAlSito(lontra2);
        sitoWeb.aggiungiUtenteAlSito(lontra3);

        //Effettuo delle prenotazioni
        sitoWeb.prenota(utente1, prenotazione1);
        sitoWeb.prenota(utente1, prenotazione4);
//        sitoWeb.prenota(utente1, prenotazione3);

        sitoWeb.prenota(utente2, prenotazione5);
        sitoWeb.prenota(utente3, prenotazione6);

        sitoWeb.prenota(lontra1, prenotazione7);
        sitoWeb.prenota(lontra2, prenotazione8);
        sitoWeb.prenota(lontra3, prenotazione9);

        System.out.println("\nUltima prenotazione effettuata:\n" +sitoWeb.ultimaPrenotazioneUtente(utente1));
        System.out.println("\nAbitazione con più prenotazioni:\n" +sitoWeb.abitazionePiuGettonata(2));
        System.out.println("\nHost più richiesto:\n" +sitoWeb.hostPiuPrenotazionioMese(2));

        System.out.println("\nSUPER HOSTS");
        sitoWeb.stampaSuperHosts();

        System.out.println("\nNumero medio di posti letto: " +sitoWeb.numeroMedioPostiLetto()+ "\n");
        System.out.println("\nSTAMPA UTENTI PIU' ATTIVI");
        sitoWeb.utentiPiuAttivi(Month.FEBRUARY);

        //Set prenotazione1
        prenotazione1.setCosto(40);
        List<Prenotazione> prenotaziones=List.of(prenotazione1,prenotazione2,prenotazione4,prenotazione6);
        System.out.println("\nProvaLambdaPrenotazione");
        System.out.println(sitoWeb.lambdaPrenotazioniN(prenotaziones,35));

        System.out.println("\nLista Utenti con prenotazione");
        System.out.println(sitoWeb.lambdaPrenotazioneUtenti(prenotaziones));

        System.out.println("\nLista Prenotazione Utente1");
        System.out.println(sitoWeb.lambdaPrenotazioneUtente(prenotaziones,utente1.getID()));

        //Set Abitazione
        List<Abitazione> abitaziones= List.of(abitazione1,abitazione2,abitazione3,abitazione4);
        System.out.println("\nNumero Abitazioni nella lista Host1 con più di 2 posti letto");
        System.out.println(sitoWeb.lambdaAbitazioneHost(abitaziones,host1.getCodiceHost()));
    }
}
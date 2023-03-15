package turista_facoltoso;

import turista_facoltoso.utenti.Utente;
import turista_facoltoso.utenti.Host;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class SitoWeb {
    private HashSet<Utente> utenti = new HashSet<>(0);
    private HashSet<Host> hosts = new HashSet<>(0);


    /**
     * Questo metodo permette di stampare le abitazioni appartenenti ad un certo host
     * @param codice_host attraverso il codice_host si può risalire alle abitazioni proprietarie dell'host
     */
    public void stampaAbitazioni(int codice_host) {
        /* Una sintassi alternativa al for-each prevede di utilizzare un iterator con la seguente sintassi:
         * Iterator<Host> iterator = host.iterator();
         * In questa maniera viene dichiarato un oggetto iterator di tipo "Host", utilizzando il metodo iterator() sulla collezione che si
         * desidera iterare.
         *
         * I metodi a disposizione con un iteratore sono 3:
         * boolean hasNext(): restituisce true se l'iteratore ha ancora elementi da restituire, false altrimenti;
         * E next(): restituisce l'elemento generico E successivo della collezione e sposta l'iteratore avanti di un'unità;
         * void remove(): rimuove l'ultimo elemento restituito dall'iteratore dalla collezione sottostante.
         *
         * Per utilizzare un iteratore, bisogna prima ottenere un'istanza di esso chiamando il metodo iterator() sulla collezione che si
         * vuole attraversare. È possibile mettere il metodo hasNext() in un ciclo while() e stampare, mediante il metodo next(), l'elemento
         * successivo della collezione. In questa maniera, finché sarà presente un elemento dopo quello "attuale", la condizione all'interno
         * del ciclo while sarà "true" e l'iterazione continuerà.
         */
        /*
        for (Host host : hosts)
            if(host.getCodiceHost() == codice_host) {
                host.mostraAbitazioni();
                break;
            }
         */
        hosts.stream().map(host->host.getCodiceHost()).filter(e->e==codice_host).forEach(System.out::println);
    }

    /**
     * Questo metodo permette di registrare un host al sito web
     * @param host host da aggiungere al sito
     */
    public void aggiungiHostAlSito(Host host) {
        this.hosts.add(host);
    }

    /**
     * Questo metodo permette di registrare un utente al sito web
     * @param utente utente da registrare
     */
    public void aggiungiUtenteAlSito(Utente utente) {
        this.utenti.add(utente);
    }

    /**
     * Questo metodo permette di far prenotare un'abitazione ad un cliente
     * @param utente utente che vuole effettuare la prenotazione
     * @param prenotazione prenotazione che si vorrebbe convalidare
     */
    public void prenota(Utente utente, Prenotazione prenotazione) {
        for (Host host : hosts)
            for (Abitazione abitazione : host.getAbitazioni())
                if (abitazione.getID() == prenotazione.getIDAbitazione())

                    if (checkDate(prenotazione, abitazione)) {
                        utente.aggiungiPrenotazione(prenotazione);
                        abitazione.aggiungiPrenotazione(prenotazione);

                        if (!host.isSuperHost())
                            checkSuperHost(host);

                        System.out.println("Prenotazione effettuata con successo.");
                        return;
                    }
/*
      List<List<Abitazione>> abitazione2=hosts.stream().map(host->host.getAbitazioni().stream().filter(abitazione->abitazione.getID()== prenotazione.getIDAbitazione()).collect(Collectors.toList())).collect(Collectors.toList());
       Abitazione abitazione3= abitazione2.get(0).get(0);
        if(checkDate(prenotazione,abitazione3)){
            utente.aggiungiPrenotazione(prenotazione);
            abitazione3.aggiungiPrenotazione(prenotazione);

            System.out.println("Prenotazione effettuata con successo.");
            return;
        }
 */
        System.out.println("Non è stato possibile prenotare");
    }

    /**
     * Questo metodo restituisce l'ultima prenotazione effettuata da un utente
     * @param utente utente di cui si vuole conoscere l'ultima prenotazione
     * @return restituisce la prenotazione (oggetto di tipo Prenotazione)
     */
    public Prenotazione ultimaPrenotazioneUtente(Utente utente) {
        /*
        Iterator<Prenotazione> iterator = utente.getPrenotazioni().iterator();
        Prenotazione ultima_prenotazione = null;

        //Mi salvo l'ultimo elemento della collezione, ovvero l'ultima prenotazione effettuata
        while (iterator.hasNext())
            ultima_prenotazione = iterator.next();

        return ultima_prenotazione;
         */

        Optional<Prenotazione> optional_prenotazione2=utente.getPrenotazioni().stream().reduce((a,b)->b);
        Prenotazione ultima_prenotazione2=optional_prenotazione2.orElse(null);
        return ultima_prenotazione2;
    }

    /**
     * Questo metodo restituisce l'abitazione più prenotata nel mese passato come parametro
     * @param mese mese di cui si vuole conoscere l'abitazione più gettonata (numero intero)
     * @return restituisce l'abitazione
     */
    public Abitazione abitazionePiuGettonata(int mese) {
        int contatore, temp=0;
        Abitazione abitazione_temp = null;

        //Scorro tutti gli host, dai quali accedo alle abitazioni da loro messe a disposizione
        for (Host host : hosts)
            for (Abitazione abitazione : host.getAbitazioni()) {
                contatore=0;

                //Tramite un contatore, memorizzo l'abitazione con più prenotazione in quel mese
                for (Prenotazione prenotazione : abitazione.getPrenotazioni())
                    if (mese >= prenotazione.getDataInizio().getMonth().getValue() && mese <= prenotazione.getDataFine().getMonth().getValue())
                        contatore++;

                if (contatore > temp) {
                    abitazione_temp = abitazione;
                    temp = contatore;
                }
            }

        return abitazione_temp;
    }

    /**
     * Questo metodo restituisce l'host che ha "subito" più prenotazioni nel mese passato come parametro
     * @param mese mese di cui si vuole conoscere questa informazione
     * @return restituisce l'host in questione
     */
    public Host hostPiuPrenotazionioMese(int mese) {
        int contatore, temp=0;
        Host host_temp = null;

        for (Host host : hosts) {
            contatore=0;

            for (Abitazione abitazione : host.getAbitazioni()) {
                for (Prenotazione prenotazione : abitazione.getPrenotazioni()) {
                    if (mese == prenotazione.getDataInizio().getMonth().getValue() || mese == prenotazione.getDataFine().getMonth().getValue())
                        contatore++;
                }
            }

            if (contatore > temp) {
                host_temp = host;
                temp = contatore;
            }
        }

        return host_temp;
    }

    /**
     * Stampa la lista dei superhost
     */
    public void stampaSuperHosts() {
        /*
        for (Host host : hosts)
            if (host.isSuperHost())
                System.out.println(host+ "\n");
         */
        hosts.stream().filter(host->host.isSuperHost()).forEach(System.out::println);
    }

    /**
     * Restituisce il numero di posti letto di tutte le abitazioni presenti nel sito
     * @return restituisce il numero di posti letto
     */
    public int numeroMedioPostiLetto() {
        int numero_posti=0;
        int numero_abitazioni=0;
/*
        for (Host host : hosts)
            for (Abitazione abitazione : host.getAbitazioni()) {
                numero_posti += abitazione.getPosti_letto();
                numero_abitazioni++;
            }

        return numero_posti/numero_abitazioni;
 */
      List<List<Integer>> posti_letto_list= hosts.stream().map(host-> host.getAbitazioni().stream().map(abitazione->abitazione.getPosti_letto()).collect(Collectors.toList())).collect(Collectors.toList());
      return posti_letto_list.get(0).stream().mapToInt(n->n).sum()/posti_letto_list.get(0).size();

    }

    /**
     * Stampa gli utenti più attivi nel mese passato come parametro
     * @param mese mese di cui si vogliono conoscere gli utenti più attivi
     */
    public void utentiPiuAttivi(Month mese) {
        LinkedHashMap<String, Integer> lista_5_utenti = new LinkedHashMap<>();

        for (Utente utente : utenti) {
            int contatore=0;

            for (Prenotazione prenotazione : utente.getPrenotazioni())
                contatore += contaGiorni(prenotazione, mese);

            if (contatore>0) {
                if (lista_5_utenti.size() < 5)
                    lista_5_utenti.put(utente.getNome(), contatore);
                else {
                    Integer ultimoValore = new LinkedList<>(lista_5_utenti.values()).getLast();

                    if (contatore > ultimoValore) {
                        //Rimuove l'ultima coppia chiave-valore
                        Set<Map.Entry<String, Integer>> entries = lista_5_utenti.entrySet();
                        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();

                        while (iterator.hasNext()) {
                            Map.Entry<String, Integer> entry = iterator.next();
                            if (!iterator.hasNext()) {
                                iterator.remove();
                            }
                        }
                        lista_5_utenti.put(utente.getNome(), contatore);
                    }
                }
                ordinaLinkedHashMap(lista_5_utenti);
            }
        }

        //Stampa dei valori
        for (Map.Entry<String, Integer> entry : lista_5_utenti.entrySet())
            System.out.println("Nome utente: " +entry.getKey()+ "\nPrenotazione: " +entry.getValue());
    }

    /**
     * Questo metodo permette di ordinare una TreeMap passata come parametro in base ai valori
     * @param linkedHashMap TreeMap da ordinare
     */
    private void ordinaLinkedHashMap(LinkedHashMap<String, Integer> linkedHashMap) {

        List<Integer> valuesList = new ArrayList<>(linkedHashMap.values());   //Crea una lista dei valori associati alle chiavi del TreeMap
        Collections.sort(valuesList, Collections.reverseOrder());       //Ordina la lista dei valori in ordine decrescente
        LinkedHashMap<String, Integer> sortedTreeMap = new LinkedHashMap<>();       //Crea un nuovo TreeMap basato sull'ordine della lista dei valori

        for (Integer value : valuesList)
            for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet())
                if (entry.getValue().equals(value)) {
                    sortedTreeMap.put(entry.getKey(), entry.getValue());
                    break;
                }

        linkedHashMap = sortedTreeMap;
    }

    private int contaGiorni(Prenotazione prenotazione, Month mese) {
        LocalDate data_inizio;
        LocalDate data_fine;

        //Controllo se la prenotazione rientra nel mese passato come parametro
        if (prenotazione.getDataInizio().getMonth().getValue() <= mese.getValue() && prenotazione.getDataFine().getMonth().getValue() >= mese.getValue()) {

            if (prenotazione.getDataInizio().getMonth().getValue() < mese.getValue())
                data_inizio = LocalDate.of(prenotazione.getDataInizio().getYear(), mese, 1);
            else
                data_inizio = prenotazione.getDataInizio();

            if (prenotazione.getDataFine().getMonth().getValue() > mese.getValue())
                //Alla fine della riga controllo se l'anno è bisestile
                data_fine = LocalDate.of(prenotazione.getDataFine().getYear(), mese, mese.length(prenotazione.getDataFine().isLeapYear()));
            else
                data_fine = prenotazione.getDataFine();

            return data_fine.getDayOfMonth() - data_inizio.getDayOfMonth();
        }

        return 0;
    }

    /**
     * Questo metodo controlla se è possibile effettuare una prenotazione, controllando le date disponibili e tenendo conto di altre
     * eventuali prenotazioni dell'abitazione
     * @param prenotazione prenotazione che si vorrebbe effettuare
     * @param abitazione abitazione che si vorrebbe prenotare
     * @return restituisce vero o falso, rispettivamente, se è possibile o meno prenotare
     */
    private boolean checkDate(Prenotazione prenotazione, Abitazione abitazione) {
        //Controllo se la prenotazione avviene prima o dopo del periodo di disponibilità dell'abitazione
        if (prenotazione.getDataInizio().isBefore(abitazione.getInizioDisponibilita()) || prenotazione.getDataFine().isAfter(abitazione.getFineDisponibilita()))
            return false;

        for (Prenotazione prenotazione1 : abitazione.getPrenotazioni()) {
            if (prenotazione.getDataInizio().isBefore(prenotazione1.getDataFine()) && prenotazione.getDataInizio().isAfter(prenotazione1.getDataInizio()))
                return false;
            if (prenotazione.getDataFine().isBefore(prenotazione1.getDataFine()) && prenotazione.getDataFine().isAfter(prenotazione1.getDataInizio()))
                return false;
            if (prenotazione.getDataInizio().isEqual(prenotazione1.getDataInizio()) || prenotazione.getDataInizio().isEqual(prenotazione1.getDataFine()))
                return false;
            if (prenotazione.getDataFine().isEqual(prenotazione1.getDataInizio()) || prenotazione.getDataFine().isEqual(prenotazione1.getDataFine()))
                return false;
        }

        return true;
    }

    /**
     * Questo metodo permette di controllare (ed eventualmente settare) se l'host passato come parametro supera le 10 prenotazioni
     * @param host host che si vuole controllare
     */
    private void checkSuperHost(Host host) {
        int contatore=0;

        for (Abitazione abitazione : host.getAbitazioni())
            contatore += abitazione.getPrenotazioni().size();

        if (contatore >= 10)
            host.setSuperHost(true);
    }

    //ottenere, dati in input una lista di oggetti prenotazione e un double n, il numero di prenotazioni con costo >= n
    public List<Prenotazione> lambdaPrenotazioniN(List<Prenotazione> prenotaziones, double n){
       return prenotaziones.stream().filter(prenotazione -> prenotazione.getCosto()>=n).collect(Collectors.toList());
    }
    /*ottenere, data in input una lista di oggetti prenotazione, la lista di
    tutti gli utenti distinti che hanno effettuato almeno una prenotazione tra quelle in input.
     */
    public List<Utente> lambdaPrenotazioneUtenti(List<Prenotazione> prenotaziones) {
        List<Utente> results= new ArrayList<>();
        for (Prenotazione prenotazione : prenotaziones) {
           results= utenti.stream().filter(utente -> utente.getID() == prenotazione.getID_cliente()).collect(Collectors.toList());
        }
        return results;
    }

    /*ottenere, dati in input una lista di oggetti prenotazione e un id utente,
     l'insieme delle prenotazioni effettuate dall'utente.
     */

    public List<Prenotazione> lambdaPrenotazioneUtente(List<Prenotazione> prenotaziones, int ID){
        return prenotaziones.stream().filter(prenotazione -> prenotazione.getID_cliente()==ID).collect(Collectors.toList());
    }

    /*ottenere, data una lista di abitazioni e un codice host,
    il numero di abitazioni di quell'host che hanno un numero di posti letto > 2.
     */

    public int lambdaAbitazioneHost(List<Abitazione> abitaziones, int codice_host){
       List<Host> hostList= hosts.stream().filter(host -> host.getCodiceHost()==codice_host).collect(Collectors.toList());
       Host host=hostList.get(0);
        return (int) abitaziones.stream().filter(abitazione ->host.getAbitazioni().contains(abitazione)).filter(abitazione -> abitazione.getPosti_letto()>2).count();
    }
}


package negozio;

import java.util.Arrays;

public class Cliente {
    //attributi
    private int eta;
    private Carrello carrello; //carrello del cliente
    private int numeroPunti;

    //costruttore
    public Cliente(int eta) {
        this.eta = eta;
        this.numeroPunti = 0;
        carrello = new Carrello(this); //gli devo passare questo cliente
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public Carrello getCarrello() {
        return carrello;
    }

    //metodo per aggiungere un prodotto p nel carrello del cliente in quantità q
    public void aggiungiAlCarrello(Prodotto p, int q){
        //1. Controllare se il prodotto è disponibile in tale quantita in negozio (->devo costruire il negozio)
        //1.1 Se c'è disponibilità aggiungo nella prossima casella libera dei due array che compongono il carrello p e q
        //1.2 Altrimenti stampo un messaggio di errore
        Prodotto[] prodottiNegozio = Negozio.getProdotti();
        //controllo se il prodotto p è disponibile in quantita q dentro il negozio
        if(Negozio.isDisponibile(p, q)){
            //se è disponibile allora lo aggiungo al carrello -> metodo nel carrello per aggiungere il prodotto.
            carrello.aggiungiProdotto(p, q);
        }
        else System.out.println("Prodotto non disponibile!");
    }

    //metodo per svuotare il carrello del cliente
    public void svuotaCarrello(){
        carrello.setProdotti(new Prodotto[100]);
        carrello.setQuantita(new int[100]);
        carrello.setIndice(0);
    }

    //questo metodo ritorna true se il cliente ha diritto allo sconto in questo momento
    public boolean isSconto(Giorni giorno){
        if(eta>=60 && (giorno.equals(Giorni.LUNEDI) || giorno.equals(Giorni.MERCOLEDI))) return true;
        return false;
    }

    //questo metodo permette di effettuare l'acquisto
    //0. Inizializzo il conto
    //1.Controllo se i prodotti nel carrello sono ancora disponibili, per fare ciò:
    //faccio un for sui prodotti p e le rispettive quantità p
    //1.1 Se quel prodotto p è ancora disponibile in quantità q nel negozio:
    //  Confermo l'acquisto del prodotto p in quatità q, quindi vado a rimuovere dal negozio quella quantita di prodotto.
    //Aggiungo al conto totale il prezzo di p moltiplicato per q
    //1.2 Altrimenti: permetto l'acquisto solamente della quantità q rimanente
    // (che può essere 0 quindi in tal caso non verrà calcolato nel conto finale)
    //1.3 Aggiungo al conto il prezzo di p moltiplicato per q rimanente e aggiorno il negozio
    //2. svuotare il carrello
    //3. ritornare il prezzo totale.
    public double checkOut(Giorni giorno, boolean sconto){
        double conto = 0;
        for(int i=0; i< carrello.getIndice(); i++){  //mi scorro il carrello(non tutto ma fino all'indice del carrello perché so che è pieno fino a li)
            Prodotto p = carrello.getProdotti()[i];  //prendo l'i-esimo prodotto dal carrello
            int q = carrello.getQuantita()[i];       //prendo l'i-esima quantita dell'i-esimo prodotto nel carrello
            if(Negozio.isDisponibile(p, q)){         //controllo se il prodotto in quella quantita sia ancora disponibile
                if(isSconto(giorno) && p.isAlimentare()){  //se posso applicare lo sconto
                    double prezzoScontato = (p.getPrezzo()/100.0)*80;
                    conto+=q*prezzoScontato;  //lo calcolo aumentando il conto con il prezzo scontato
                }
                else {
                    conto += q * p.getPrezzo();     //lo calcolo per intero
                }
                Negozio.rimuoviDopoAcquisto(p, q);   //se si decremento la quantità del prodotto nel negozio
            }
            else{
                if(isSconto(giorno) && p.isAlimentare()){
                    double prezzoScontato = (p.getPrezzo()/100.0)*80;
                    conto+=p.getQuantita()*prezzoScontato;
                }
                else {
                    conto += q * p.getPrezzo();
                }
                Negozio.rimuoviDopoAcquisto(p, p.getQuantita()); //"svuoto" le scorte di quel prodotto
            }
        }
        svuotaCarrello();
        numeroPunti += conto/10;
        if(sconto){
            double euroScontati = numeroPunti/10;
            return conto-euroScontati;
        }
        return conto;
    }

    //overload del metodo precedente, dove in questo caso il pagamento viene rateizzato
    //e il metodo ritorna il costo della prima rata
    public double checkout(Giorni giorno, boolean sconto, int nMesi){
        double prezzoTot = checkOut(giorno, sconto);
        return prezzoTot/nMesi;
    }
}

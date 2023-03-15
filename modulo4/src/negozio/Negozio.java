package negozio;

public class Negozio {
    private static Prodotto[] prodotti = new Prodotto[100];  //prodotti del negozio

    public static Prodotto[] getProdotti() {
        return prodotti;
    }

    //questo metodo aggiunge un prodotto o ne incremente la quantità se è già presente al negozio
    public static void addProdotto(Prodotto p, int q){  //50 tipi mandarini
        for(int i=0; i<prodotti.length; i++){  //ciclo i prodotti
            if(p.equals(prodotti[i])) {  //se trovo il prodotto che cerco
                prodotti[i].addQuantita(q); //aggiungo la quantità q
                return;
            }
        }
        //nel caso in cui non trovo prodotto p che sto cercando
        for(int i=0; i<prodotti.length; i++){
            if(prodotti[i]==null){
                prodotti[i]=p;
                prodotti[i].setQuantita(q);
                return;
            }
        }
    }

    //questo metodo rimuove un prodotto p all'interno dell'array dei prodotti
    public static void removeProdotto(Prodotto p){
        for(int i=0; i<prodotti.length; i++){  //ciclo i prodotti
            if(prodotti[i].equals(p)) {  //se trovo il prodotto che cerco
                prodotti[i] = null;
                return;
            }
        }
    }

    //questo metodo stampa a video tutti i prodotti del negozio con le rispettive quantita
    public static void stampaProdotti(){
        for(Prodotto p: prodotti){
            if(p==null) continue; {
                System.out.println(p.getNome() + ": " + p.getQuantita());
            }
        }
    }

    //questo metodo ritorna true se il prodotto p è disponibile in quantita q dentro il negozio
    public static boolean isDisponibile(Prodotto p, int q){
        for(Prodotto prod: prodotti){  //mi scrro l'array di prodotti del negozio
            if(p.equals(prod)){ //controllo con equals se trovo il prodotto cercato
                if(prod.getQuantita() >= q) return true; //se la quantita è sufficiente ritorno true
                else return false; //altrimenti ritorno false
            }
        }
        return false;
    }

    //questo metodo prende in input un prodotto p disponibile e una data quantità p
    //e rimuove q prodotti di quel tipo dal negozio
    public static void rimuoviDopoAcquisto(Prodotto p, int q){
        //cerchiamo il prodotto dentro l'array
        for(Prodotto prod : prodotti){ //scorro l'array
            if(prod.equals(p)){
                prod.decreaseQuantita(q);
                break;
            }
        }
    }
}

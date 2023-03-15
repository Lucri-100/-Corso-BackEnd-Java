package negozio;

public class Carrello {
    private Cliente cliente;  //di chi è il carrello?
    private Prodotto[] prodotti;
    private int[] quantita;
    private int indice; //dove inserisco il prossimo prodotto

    public Carrello(Cliente cliente) {
        this.cliente = cliente;
        this.prodotti = new Prodotto[100];
        this.quantita = new int[100];
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Prodotto[] getProdotti() {
        return prodotti;
    }

    public void setProdotti(Prodotto[] prodotti) {
        this.prodotti = prodotti;
    }

    public int[] getQuantita() {
        return quantita;
    }

    public void setQuantita(int[] quantita) {
        this.quantita = quantita;
    }

    public void aggiungiProdotto(Prodotto p, int q){
        prodotti[indice] = p;
        quantita[indice] = q;
        this.indice++;
    }

    public void stampaCarrello(){
        for(int i=0; i< prodotti.length; i++){
            if(prodotti[i] == null) continue;
            System.out.println(prodotti[i].getNome() + ":" + quantita[i]);
        }
    }
}

package negozio;

public class Prodotto {
    private String nome;
    private double prezzo;
    private int quantita;
    private boolean alimentare;

    public Prodotto(String nome, double prezzo, int quantita, boolean alimentare) {
        this.nome = nome;
        this.prezzo = prezzo; //qui è da mettere una eccezione per controllare se prezzo >= 0
        this.quantita = quantita; //qui è da mettere una eccezione per controllare se quantità è >= 0
        this.alimentare = alimentare;
    }

    //setter valori che posso cambiare successivamente->nel caso del nome non ha senso.
    //idem per il caso se sia alimentare o meno
    public String getNome() {
        return nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public boolean isAlimentare() {
        return alimentare;
    }

    //questo metodo aggiunge una quantita del prodotto alla quantità precedente
    public void addQuantita(int quantita){
        this.quantita += quantita;
    }

    //questo metodo decrementa la quantità di un prodotto
    public void decreaseQuantita(int quantita){
        this.quantita = quantita;
    }

    //questo metodo aggiorna di 1 la quantità disponibile del prodotto
    public void addSingolaQuantita(){
        this.quantita++;
    }

    //ritorna true se i due oggetti hanno lo stesso nome
    public boolean equals(Object obj){
        //controlliamo se il parametro obj sia null oppure sia della classe Prodotto
        if(obj == null || obj.getClass()!= this.getClass()) return false;
        Prodotto newp = (Prodotto) obj; //casting->forzo obj a diventare Prodotto
        if(this.nome.equals(newp.nome)) return true;
        return false;
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "nome='" + nome + '\'' +
                ", prezzo=" + prezzo +
                ", quantita=" + quantita +
                ", alimentare=" + alimentare +
                '}';
    }
}

package gestoreVeicoli;

public class Veicolo {
    protected String targa;
    protected int nPosti;

    public Veicolo(String targa, int nPosti) {
        this.targa = targa;
        this.nPosti = nPosti;
    }

    @Override
    public String toString() {
        return "targa=" + targa;
    }
}

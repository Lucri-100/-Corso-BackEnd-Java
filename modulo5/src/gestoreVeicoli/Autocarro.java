package gestoreVeicoli;

public class Autocarro  extends Veicolo{
    protected int capacitaMax;

    public Autocarro(String targa, int nPosti, int capacitaMax) {
        super(targa, nPosti);
        this.capacitaMax = capacitaMax;
    }

    @Override
    public String toString() {
        return "Autocarro{" +
                super.toString() + "" +
                " capacitaMax=" + capacitaMax +
                '}';
    }
}

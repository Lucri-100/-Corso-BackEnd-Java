package gestoreVeicoli;

public class Automobile extends Veicolo{
    protected int nPorte;

    public Automobile(String targa, int nPosti, int nPorte) {
        super(targa, nPosti);
        this.nPorte = nPorte;
    }

    @Override
    public String toString() {
        return "Automobile{" +
                super.toString() + "" +
                " nPorte=" + nPorte +
                '}';
    }
}

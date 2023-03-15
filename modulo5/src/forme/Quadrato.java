package forme;
public class Quadrato extends Rettangolo {

    public Quadrato(int a) {
        super(a, a);
    }

    @Override
    public String toString() {
        return "Quadrato{" +
                "a=" + a + "}";
    }
}

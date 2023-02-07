package lampadina;

public class Interruttore {
    Lampadina lampadina;


    public Interruttore(Lampadina lampadina) {
        this.lampadina = lampadina;
    }

    public void premiInterruttore() {
        lampadina.click();
    }
}

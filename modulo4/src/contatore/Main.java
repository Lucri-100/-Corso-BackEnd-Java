package contatore;

public class Main {
    public static void main(String[] args) {
        Contatore c1 = new Contatore();
        c1.inc();
        c1.inc();

        Contatore c2 = new Contatore(10);
        c2.inc();

        System.out.println(c1.getVal());
        System.out.println(c2.getVal());
    }
}
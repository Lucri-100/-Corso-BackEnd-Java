package forme;

public class Main {
    public static void main(String[] args) {

        Quadrato quadrato = new Quadrato(10);
        Cerchio cerchio = new Cerchio(5);

        quadrato.stampaQuadrato();
        System.out.println("\nCirconferenza cerchio: " +cerchio.circonferenza());
        System.out.println("Area cerchio: " +cerchio.area());
        System.out.println("Colore cerchio");
        System.out.println("R: " +cerchio.getColore().getR()+ "\nG: " +cerchio.getColore().getG()+ "\nB: " +cerchio.getColore().getB());
    }
}

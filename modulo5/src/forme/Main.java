package forme;

public class Main {
    public static void main(String[] args) {
        Quadrato quadrato = new Quadrato(5);
        Rettangolo rettangolo = new Rettangolo(5,6);

        System.out.println(quadrato.toString());
        System.out.println(rettangolo.toString());

        System.out.println("Perimetro rettangolo: " +rettangolo.calcolaPerimetro());
        System.out.println("Area rettangolo: " +rettangolo.calcolaArea());
        System.out.println(rettangolo.toString());

        System.out.println("\nPerimetro quadrato: " +quadrato.calcolaPerimetro());
        System.out.println("Area quadrato: " +quadrato.calcolaArea());
        System.out.println(quadrato.toString());
    }
}

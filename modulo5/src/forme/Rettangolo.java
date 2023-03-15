package forme;
public class Rettangolo {
    protected int a;
    protected int b;

    public Rettangolo(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public double calcolaPerimetro(){
        return 2*(a*b);
    }

    public double calcolaArea(){
        return a*b;
    }

    @Override
    public String toString() {
        return "Rettangolo{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}

package generics;

public class Nodo<T>{
    protected T valore;
    protected Nodo<T> prossimo = null;

    public Nodo(T valore) {
        this.valore = valore;
    }

    public void setProssimo(Nodo<T> prossimo) {
        this.prossimo = prossimo;
    }

    @Override
    public String toString() {
        return  valore + ((prossimo != null)? "," + prossimo: "");
    }
}

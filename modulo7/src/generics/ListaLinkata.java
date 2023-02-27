package generics;

public class ListaLinkata<T>{
    private Nodo<T> testa; //primo elemento della lista


    //metodo per il rimuovere il primo elemento della lista
    public void removeFirst(){
        if(testa == null)
            System.out.println("La lista è vuota!");
        testa = testa.prossimo;
    }

    //metodo per aggiungere in testa un elemento della lista
    public void addFirst(T valore){
        Nodo<T> nuovoNodo = new Nodo<>(valore);
        nuovoNodo.setProssimo(testa);
        testa = nuovoNodo;
    }

    @Override
    public String toString() {
        return "Lista["+ testa +
                ']';
    }
}

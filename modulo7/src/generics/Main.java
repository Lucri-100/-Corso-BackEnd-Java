package generics;

public class Main {
    public static void main(String[] args) {
        ListaLinkata<Integer> lista = new ListaLinkata<>();
        lista.addFirst(1);
        lista.addFirst(2);
        lista.addFirst(3);
        System.out.println(lista);
        lista.removeFirst();
        System.out.println(lista);

        System.out.println("---------------------------------------------------\n");


    }
}

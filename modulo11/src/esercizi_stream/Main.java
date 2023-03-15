package esercizi_stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        System.out.println("Ordinare una lista di stringhe senza modificarla");
        List<String> lista1 = Arrays.asList("15", "B", "E", "4", "C", "T", "1", "R", "O");
        List<String> lista_ordianta = lista1.stream().sorted().collect(Collectors.toList());
        System.out.println(lista1);
        System.out.println(lista_ordianta);

        System.out.println("--------------------------------------------");

        System.out.println("Convertire in maiuscolo le stringhe in una lista");
        List<String> lista2 = Arrays.asList("a", "b", "c", "d", "e");
        List<String> lista_maiuscolo = lista2.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(lista2);
        System.out.println(lista_maiuscolo);

        System.out.println("--------------------------------------------");

        System.out.println("Metodo che aggiunga l’IVA ad ogni prezzo contenuto ad una lista di prezzi e li stampi");
        List<Double> prezzi = Arrays.asList(10.9, 19.9, 28.0, 40.0, 50.0);
        double iva = 0.22;
        prezzi.stream().map(prezzo -> prezzo + (prezzo * iva)).forEach(System.out::println);

        System.out.println("--------------------------------------------");

        System.out.println("Stampa i numeri dispari da 1 a 10");
        List<Integer> numeri = List.of(1,2,3,4,5,6,7,8,9,10);
        Set<Integer> numeri_disperi = numeri.stream().filter(x->x%2!=0).collect(Collectors.toSet());
        System.out.println(numeri_disperi);

        System.out.println("--------------------------------------------");

        System.out.println("Metodo per ottenere una stringa che rappresenta la concatenzaione delle stringhe contenute in una lista, rese maiuscole e separate d virgola");
        List<String> stringhe = Arrays.asList("sono", "lucrezia", "ciao", "a", "tutti");
        String s = "";
        s = stringhe.stream().map(e -> e.toUpperCase()).collect(Collectors.joining(", "));
        System.out.println(s);

        System.out.println("--------------------------------------------");

        System.out.println("Metodo per ottenere, a partire da una lista di numeri, una mappa dove ad ogni numero dispari è associata la sua rappresentazione di stringa");
        List<Integer> lista_numeri = Arrays.asList(1, 2, 3, 4, 5, 6);
        Map<Integer, String> mapNumeriDisperi = lista_numeri.stream().filter(x -> x%2!=0).collect(Collectors.toMap(Function.identity(), x->String.valueOf(x)));
        System.out.println(mapNumeriDisperi);

        System.out.println("--------------------------------------------");

        System.out.println("Metodo per ottenere, a partire da una lista di stringhe una mappa con chiave la stringa e il valore il numero di occorrenze nella lista");
        List<String> lista_stringhe2 = Arrays.asList("ciao", "ciao", "io", "tu", "bu");
        Map<String, Long> mappa = lista_stringhe2.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(mappa);

        System.out.println("--------------------------------------------");

        System.out.println("Metodo per ottenere, a partire da una lista di stringhe, che restituisca una mappa che ha come chiave la prima lettera (univoca) e come valore la somma delle occorrenze delle stringhe che iniziano con tale lettera");
        List<String> ciao = Arrays.asList("ciao", "che", "facciamo", "oggi", "usciamo", "cane");
        Map<String, Long> mappa_ciao = ciao.stream().collect(Collectors.groupingBy(x->x.charAt(0)+"", Collectors.counting()));
        System.out.println(mappa_ciao);

        System.out.println("--------------------------------------------");

        System.out.println("Metodo che restituisce la somma di una lista di interi");
        List<Integer> numeriDaSommare = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer somma = numeriDaSommare.stream().collect(Collectors.summingInt(x->x));
        System.out.println(somma);











    }
}

package mappa_di_righe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, List<String>> mappa = new HashMap<>();
        //Path path = Paths.get("src", "mappa_di_righe", "testo.txt");
        BufferedReader reader = new BufferedReader(new FileReader("src/mappa_di_righe/testo.txt"));

        String riga;
        while((riga = reader.readLine()) != null){
            String[] riga_lista = riga.split(":");
            String chiave = riga_lista[0];
            String[] valori = riga_lista[1].split(",");
            List<String> valori_lista = new ArrayList<>();

            for(String valore : valori){
                valori_lista.add(valore);
            }

            mappa.put(chiave, valori_lista);
        }

        reader.close();

        System.out.println(mappa);
    }
}

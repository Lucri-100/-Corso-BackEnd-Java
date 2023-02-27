package righe_inverse;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try{
        //leggiamo il file righe.txt
        reader = new BufferedReader(new FileReader("src/righe_inverse/righe.txt"));
        List<String> righe = new ArrayList<>();
        String riga;
        while((riga = reader.readLine())!=null){
            righe.add(riga);
        }
            //invertiamo l'ordine delle righe
            Collections.reverse(righe);

            //scrivere le righe inverse nel file righeInverse
            writer = new BufferedWriter(new FileWriter("src/righe_inverse/righe_inverse.txt"));
            for(String rigaInversa: righe){
                writer.write(rigaInversa);
                writer.newLine();
            }
            reader.close();
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

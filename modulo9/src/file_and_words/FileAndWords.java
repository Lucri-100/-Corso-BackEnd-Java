package file_and_words;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class FileAndWords {

    protected static void printWords(Path file){
        String line;
        try(BufferedReader br= Files.newBufferedReader(file)){
            while((line=br.readLine())!=null){
                System.out.println(line);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    protected static HashMap<String,Integer> occorrenzaParole(Path file){
        HashMap<String,Integer> map= new HashMap<>();
        String line;
        try(BufferedReader br= Files.newBufferedReader(file)){
            while((line=br.readLine())!=null){
                for(String s:line.split(" ")){
                    if(!map.containsKey(s))
                        map.put(s,1);
                    else
                        map.put(s,map.get(s)+1);
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return map;
    }
    protected static HashMap<String,Integer> occorrenzaParoleTesto(Path file){
        HashMap<String,Integer> map= new HashMap<>();
        String line;
        try(BufferedReader br= Files.newBufferedReader(file)){
            while((line=br.readLine())!=null){
                if(line.equals(""))
                    continue;

                for(String s:line.split("\\W+")){
                    s=s.toLowerCase();
                    if(!map.containsKey(s))
                        map.put(s,1);
                    else
                        map.put(s,map.get(s)+1);
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return map;
    }
    protected static HashMap<String, ArrayList<String>> paroleInRima(Path file){
        HashMap<String,ArrayList<String>> map= new HashMap<>();
        String line;
        ArrayList<Character> vowels= new ArrayList<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        try(BufferedReader br= Files.newBufferedReader(file)){
            while((line=br.readLine())!=null) {
                if (line.equals(""))
                    continue;
                for (String s : line.split("\\W+")){
                    System.out.println(s);
                    s = s.toLowerCase();
                    if(s.length()>4){   //check parola ha più di 4 lettere
                        //stiamo assumendo che il testo sia in italiano e che le parole con più
                        //di quattro lettere finiscano con sempre con (vocale-consonante-vocale) o (vocale-consonante-consonante-vocale)
                        if(vowels.contains(s.charAt(s.length()-3))){ //verifico che la terzultima parola sia una vocale altrimenti rientrerò nel caso  (vocale-consonante-consonante-vocale)
                            if(map.containsKey(s.substring(s.length()-3))){ //verifico che la desinenza Es. "ato", "ito", ecc. sia già presente
                                map.get(s.substring(s.length()-3)).add(s);     //aggiungo ai valori già associato alla chiave
                            }
                            else{
                                ArrayList<String> arr=new ArrayList<>();  //creo nuova coppia chiave valore (desinenza,parola)
                                arr.add(s);
                                map.put(s.substring(s.length()-3),arr);
                            }
                        }
                        else{
                            if(map.containsKey(s.substring(s.length()-4))){ //qui verifico che sia la desinenza "esso","ando", ecc ad essere presente
                                map.get(s.substring(s.length()-4)).add(s);
                            }
                            else{
                                ArrayList<String> arr=new ArrayList<>();
                                arr.add(s);
                                map.put(s.substring(s.length()-4),arr);
                            }
                        }
                    }
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return map;
    }

}


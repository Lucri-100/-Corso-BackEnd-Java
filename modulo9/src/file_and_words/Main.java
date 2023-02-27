package file_and_words;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Path path= Paths.get("src","file_and_words", "file.txt");
        Path path2= Paths.get("src","file_and_words", "file1.txt");
        FileAndWords.printWords(path);
        HashMap<String,Integer> map=FileAndWords.occorrenzaParole(path);
        System.out.println(map);
        map=FileAndWords.occorrenzaParoleTesto(path);
        System.out.println(map);
        HashMap<String, ArrayList<String>> rime=FileAndWords.paroleInRima(path2);
        System.out.println(rime);
    }
}
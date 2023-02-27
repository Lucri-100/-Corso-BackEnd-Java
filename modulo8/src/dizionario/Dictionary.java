package dizionario;

import javax.lang.model.util.AbstractElementVisitor7;
import javax.lang.model.util.ElementFilter;
import java.util.HashSet;
import java.util.TreeMap;

public class Dictionary {
    TreeMap<Character, TreeMap<String, HashSet<String>>> calepinus = new TreeMap<>();

    public Dictionary(){
    }

    public TreeMap<Character, TreeMap<String, HashSet<String>>> getCalepinus() {
        return calepinus;
    }

    public void addWord(String word, String meaning){
        HashSet<String> hashset_definition = new HashSet<>(1);

        if(calepinus.containsKey(word.charAt(0))) {
            //deve inserire la parola nei values
            //devo accedere alla mappa di quella determinata chiave e inserire la nuova
            //coppia chiave-valore(set)
            //check su parola già contenuta
            if(calepinus.get(word.charAt(0)).containsKey(word)){ //se abbiamo già inserito quella parola
                calepinus.get(word.charAt(0)).get(word).add(meaning);

            }
            else{
                hashset_definition.add(meaning);
                calepinus.get(word.charAt(0)).put(word, hashset_definition);
            }

        } else{  //abbiamo la prima lettera nuova, quindi parola nuova.
            TreeMap<String, HashSet<String>> map_word = new TreeMap<>();
            hashset_definition.add(meaning);
            map_word.put(word, hashset_definition);
            calepinus.put(word.charAt(0), map_word);
        }
    }

    public void removeWordMeaning (String word) throws WordNotPresentException{
        if(calepinus.containsKey(word.charAt(0)) && calepinus.get(word.charAt(0)).containsKey(word)){
            calepinus.get(word.charAt(0)).remove(word);
        }
        else{
            throw new WordNotPresentException(word);
        }
    }

    public void addKey(char c){
        try{
            if(!calepinus.containsKey(c)){
                calepinus.put(c, null);
            }
            else{
                throw new ElementAlreadyContainedException(c);
            }

        }catch (ElementAlreadyContainedException e){
                e.printStackTrace();
            }


    }

    @Override
    public String toString() {
        StringBuilder stringa = new StringBuilder();
        int i=1;

        for (Character character : calepinus.keySet()) {
            stringa.append(character);

            for (String parola : calepinus.get(character).keySet()) {
                stringa.append("\n" + parola);

                for (String definizione : calepinus.get(character).get(parola))
                    stringa.append("\n[" +(i++)+ "] " +definizione);

                stringa.append("\n");
                i=1;
            }
            stringa.append("\n");
        }

        return stringa.toString();
    }
}

package dizionario;

public class Main {
    public static void main(String[] args) {
        String parola1 = "calcio";
        String parola2 = "carro";

        String definizione1_1 = "La parte inferiore della cassa del fucile";
        String definizione1_2 = "Gioco di squadra che prevede di tirare calci ad un pallone e inseguirlo";
        String definizione1_3 = "Elemento chimico (numero atomico 20)";

        String definizione2_1 = "Mezzo di trasporto";

        Dictionary calepinus = new Dictionary();

        calepinus.addWord(parola1, definizione1_1);
        calepinus.addWord(parola2, definizione2_1);
        calepinus.addWord(parola1, definizione1_2);
        calepinus.addWord(parola1, definizione1_3);

        System.out.println(calepinus);

        System.out.println("Rimuoviamo un elemento che non esiste");
        try{
            calepinus.removeWordMeaning("giggino");
        }catch (WordNotPresentException e){
            e.printStackTrace();
        }

        System.out.println("Rimuoviamo un elemento che esiste");
        try{
            calepinus.removeWordMeaning("carro");
        }catch (WordNotPresentException e){
            e.printStackTrace();
        }

        System.out.println(calepinus);



    }
}

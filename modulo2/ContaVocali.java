package src;

import java.util.Scanner;

public class ContaVocali{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Inserisci parola: ");
        String parola = in.nextLine();
        parola.toLowerCase();

        int cons=0, voc=0;
        for(int i=0; i<parola.length(); i++){
            char c = parola.charAt(i);
                switch (c) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                        voc++;
                        break;
                    default:
                        cons++;
                }
        }
        System.out.println(voc);
        System.out.println(cons);
    }

}

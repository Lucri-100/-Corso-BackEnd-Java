import java.util.Arrays;
import java.util.Scanner;

public class Labirinto {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input;
        int[] posizione, arrivo;
        char risposta;

        char[][] labirinto_statico = {{'-', '-', 'W', 'W', '-'},
                {'-', 'W', '-', 'W', '-'},
                {'P', 'W', '-', 'W', 'W'},
                {'-', '-', 'W', '-', 'E'},
                {'W', '-', '-', '-', 'W'}};

        arrivo = trovaPosizioneGiocatore(labirinto_statico, 'E');
        posizione = trovaPosizioneGiocatore(labirinto_statico, 'P');
        stampaLabirinto(labirinto_statico);

        while (posizione[0] != arrivo[0] || posizione[1] != arrivo[1]) {

            System.out.print("\nInserisci prossima mossa: ");
            input = scanner.nextLine();
            risposta = input.toLowerCase().charAt(0);

            movimentoGiocatore(risposta, labirinto_statico);
            posizione = trovaPosizioneGiocatore(labirinto_statico, 'P');
        }
    }

    private static void stampaLabirinto(char[][] labirinto) {
        for (char[] chars : labirinto)
            System.out.println(Arrays.toString(chars));
    }

    //Scorro le righe della matrice fino a trovare la 'P'
    private static int[] trovaPosizioneGiocatore(char[][] labirinto, char carattere_da_trovare) {
        int[] posizione = new int[2];

        for (int i=0; i<labirinto.length; i++) {
            for (int j=0; j<labirinto[i].length; j++) {

                if (labirinto[i][j] == carattere_da_trovare) {      //Mi serve per trovare 'P' oppure 'E'
                    posizione[0] = i;
                    posizione[1] = j;

                    break;
                }
            }
        }
        return posizione;
    }

    private static void movimentoGiocatore(char risposta, char[][] labirinto) {

        int[] posizione_corrente = trovaPosizioneGiocatore(labirinto, 'P');
        int[] nuova_posizione = Arrays.copyOf(posizione_corrente, 2);

        switch (risposta) {
            case 'w':
                //Controllo se esiste una riga su || se non c'è un muro su
                if (posizione_corrente[0]-1 < 0 || labirinto[posizione_corrente[0]-1][posizione_corrente[1]] == 'W')
                    System.err.println("\nNon puoi andare più su!");
                else {
                    nuova_posizione[0]--;       //Decremento la riga poiché sto andando su
                    aggiornaLabirinto(posizione_corrente, nuova_posizione, labirinto);
                }
                break;

            case 'a':
                //Controllo se esiste una colonna a sx || se non c'è un muro a sx
                if (posizione_corrente[1]-1 < 0 || labirinto[posizione_corrente[0]][posizione_corrente[1]-1] == 'W')
                    System.err.println("\nNon puoi andare più a sx!");
                else {
                    nuova_posizione[1]--;       //Decremento la colonna poiché sto andando a sx
                    aggiornaLabirinto(posizione_corrente, nuova_posizione, labirinto);
                }
                break;

            case 's':
                //Controllo se esiste una colonna giù || se non c'è un muro giù
                if (posizione_corrente[0]+1 > labirinto.length-1 || labirinto[posizione_corrente[0]+1][posizione_corrente[1]] == 'W')
                    System.err.println("\nNon puoi andare più giù!");
                else {
                    nuova_posizione[0]++;       //Decremento la colonna poiché sto andando giù
                    aggiornaLabirinto(posizione_corrente, nuova_posizione, labirinto);
                }
                break;

            case 'd':
                //Controllo se esiste una colonna a dx || se non c'è un muro a dx
                if (posizione_corrente[1]+1 > labirinto[0].length-1 || labirinto[posizione_corrente[0]][posizione_corrente[1]+1] == 'W')
                    System.err.println("\nNon puoi andare più a destra!");
                else {
                    nuova_posizione[1]++;       //Decremento la colonna poiché sto andando a dx
                    aggiornaLabirinto(posizione_corrente, nuova_posizione, labirinto);
                }
                break;
        }
    }

    private static void aggiornaLabirinto(int[] posizione_corrente, int[] nuova_posizione, char[][] labirinto) {

        if (labirinto[nuova_posizione[0]][nuova_posizione[1]] == 'E') {
            System.out.println("\nHai vinto!\n");

            /* Questo passaggio serve per poter aggiornare la P con la E, condizione necessaria per far terminare il programma, poiché
             * */
            labirinto[nuova_posizione[0]][nuova_posizione[1]] = 'P';
            labirinto[posizione_corrente[0]][posizione_corrente[1]] = '-';
        }
        else {
            labirinto[nuova_posizione[0]][nuova_posizione[1]] = 'P';
            labirinto[posizione_corrente[0]][posizione_corrente[1]] = '-';

            stampaLabirinto(labirinto);
        }
    }
}


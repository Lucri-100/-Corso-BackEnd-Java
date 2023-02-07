import java.sql.SQLOutput;

public class Tombola {
    public static void main(String[] args) {
        int[][] cartella1 = {{1, 3, 9, 21, 24}, {5, 37, 41, 60, 67}, {42, 71, 86, 87, 90}};         //Ambo e terno nelle righe 2 e 3
        int[][] cartella2 = {{42, 48, 55, 56, 4}, {72, 84, 86, 88, 90}, {60, 63, 20, 50, 89}};      //Quaterna e cinquina nelle righe 1 e 2
        int[][] cartella3 = {{1, 5, 11, 23, 24}, {30, 39, 42, 48, 55}, {56, 61, 62, 69, 70}};       //Tombola
        int[] vettore = {1, 5, 11, 23, 24, 30, 39, 42, 48, 55, 56, 61, 62, 69, 70, 72, 84, 86, 88, 90};

        giochiamo(cartella1, vettore);
        giochiamo(cartella2, vettore);
        giochiamo(cartella3, vettore);
    }

    static void giochiamo(int[][] cartella, int[] estrazioni) {
        int[] risultato = {0, 0, 0, 0};
        for (int i = 0; i < cartella.length; i++) {
            int cont = 0;
            for (int j = 0; j < cartella[0].length; j++) {
                for (int k = 0; k < estrazioni.length; k++) {
                    if (cartella[i][j] == estrazioni[k])
                        cont += 1;
                }
            }

            switch (cont) {
                case 2:
                    risultato = new int[]{risultato[0] + 1, risultato[1], risultato[2], risultato[3]};
                    break;
                case 3:
                    risultato = new int[]{risultato[0], risultato[1] + 1, risultato[2], risultato[3]};
                    break;
                case 4:
                    risultato = new int[]{risultato[0], risultato[1], risultato[2] + 1, risultato[3]};
                    break;
                case 5:
                    risultato = new int[]{risultato[0], risultato[1], risultato[2], risultato[3] + 1};
                    break;
                default:
                    break;
            }

        }

        if (risultato[3] == 3)
            System.out.println("TOMBOLA");
        else
            System.out.println("AMBO: " + risultato[0] + " TERNO: " + risultato[1] + " QUATERNA: " + risultato[2] + " CINQUINA: " + risultato[3]);
    }
}


import java.util.Arrays;

public class TartagliaRicorsiva {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(rigaTriangolo(7)));
    }

    private static int[] rigaTriangolo(int rigaT) {
        int[] riga = new int[rigaT+1];
        riga[0] = 1;

        for (int i=0; i<riga.length; i++)
            riga[i] = coefficienteBinomiale(rigaT, i);

        return riga;
    }

    private static int coefficienteBinomiale(int n, int k) {
        if (k==0 || k==n)
            return 1;
        else {
            return coefficienteBinomiale(n-1, k-1) + coefficienteBinomiale(n-1, k);
        }
    }
}
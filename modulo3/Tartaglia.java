import java.util.Arrays;
import java.util.Scanner;
public class Tartaglia {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a:");
        int b=sc.nextInt();
        crea(b);
    }
    public static void crea (int n) {
        int[][] tartaglia;
        int i, j;

        tartaglia = new int[n][];
        for (i = 0; i < tartaglia.length; i++)
            tartaglia[i] = new int[i + 1];

        for (i = 0; i < tartaglia.length; i++) {
            tartaglia[i][0] = 1;
            tartaglia[i][i] = 1;
            for (j = 1; j < i; j++)
                tartaglia[i][j] = tartaglia[i - 1][j - 1] + tartaglia[i - 1][j];
        }

        for (i = 0; i < tartaglia.length; i++) {
            for (j = 0; j < tartaglia[i].length; j++)
                System.out.print(tartaglia[i][j] + "");
            System.out.println("");
        }
    }
}
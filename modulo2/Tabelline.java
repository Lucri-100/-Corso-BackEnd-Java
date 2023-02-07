package src;

public class Tabelline {

    public static void main(String[] a) {

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                int prodotto = i*j;
                if (prodotto < 10)
                    System.out.print("   ");
                else if (prodotto < 100)
                    System.out.print("  ");
                else
                    System.out.print(" ");
                System.out.print(i*j);
            }
            System.out.println();
        }
    }

}
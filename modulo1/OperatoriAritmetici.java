import java.util.Scanner;

public class OperatoriAritmetici {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a:");
        int a=sc.nextInt();
        System.out.print("Enter b:");
        int b=sc.nextInt();
        computeValues(a, b);
    }
    private static void computeValues(int a, int b) {
        int somma = a + b;
        int differenza = a - b;
        int prodotto = a * b;
        int quoziente = a / b;
        System.out.println("Somma= " + somma +   "\nDifferenza= " + differenza +
                "\nProdotto= " + prodotto + "\nQuoziente= " + quoziente);
    }
}
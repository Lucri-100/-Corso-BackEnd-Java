package src;

import java.util.Scanner;

public class Quadrati {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a:");
        int a = sc.nextInt();
        System.out.println(quadratoDisp(a));
    }
    public static int quadratoDisp (int n){
        int result = 0;
        for (int i=1; i <= n; i++) {
            result += i * 2 - 1;
        }
        return result;
    }
}

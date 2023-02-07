package src;

import java.util.Scanner;
public class tempo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a:");
        int a = sc.nextInt();
        calcoladata(a);
    }
        public static void calcoladata(int in){
            int secondi=0;
            int minuti=in/60;
            int ore=minuti/60;
            int giorni=ore/24;

            if (minuti!=0)
                secondi=in%minuti;
            if(ore!=0)
                minuti=minuti%ore;
            if(giorni!=0)
                ore=ore%giorni;
            System.out.println("Sono Giorni:" + giorni + " Ore:" + ore+ " Minuti:" + minuti+ " Secondi:" + secondi);
        }
}

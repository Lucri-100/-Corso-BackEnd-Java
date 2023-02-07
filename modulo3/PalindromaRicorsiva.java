import java.util.Scanner;

public class PalindromaRicorsiva {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter string:");
        String a=sc.nextLine();
        System.out.print("Enter a:");
        int b=sc.nextInt();
        if (isPalindrome(a, b, a.length() - 1)) {
            System.out.print("Palindroma");
        }
        else {
            System.out.print("No Palindroma");
        }
    }

    public static boolean isPalindrome(String s, int primo, int ultimo){
        if (primo >= ultimo) {
            return true;
        }
        if (s.charAt(primo) != s.charAt(ultimo)) {
            return false;
        }
        return isPalindrome(s, primo + 1, ultimo - 1);
    }

}

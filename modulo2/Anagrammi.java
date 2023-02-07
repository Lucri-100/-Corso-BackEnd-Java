import java.util.Arrays;
import java.util.Scanner;

public class Anagrammi {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter string a:");
        String a = sc.nextLine();
        System.out.print("Enter string b:");
        String b =sc.nextLine();
        anagrams(a, b);
    }

    static void anagrams(String a, String b) {
        if(a.length() != b.length())
            System.out.println("Non sono anagrammi");
        else{
            boolean flag = true;
            char[] charArrayA = a.toLowerCase().toCharArray();
            char[] charArrayB = b.toLowerCase().toCharArray();

            System.out.println(Arrays.toString(charArrayA) + " " + Arrays.toString(charArrayB));
            Arrays.sort(charArrayA);
            Arrays.sort(charArrayB);
            System.out.println(Arrays.toString(charArrayA) + " " + Arrays.toString(charArrayB));

            for(int i = 0; i<a.length(); i++)
                if(charArrayA[i] != charArrayB[i])
                    flag = false;

            if (flag)
                System.out.println("Sono anagrammi");
            else
                System.out.println("Non sono anagrammi");
        }
    }
}
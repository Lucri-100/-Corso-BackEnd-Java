import java.util.Scanner;
public class StringaInversa {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter string:");
        String a = sc.nextLine();
        stringReverse(a);
    }

    static void stringReverse(String s){
        StringBuilder s1 = new StringBuilder();
        s1.append(s);
        s1=s1.reverse();
        System.out.println(s1);
    }

}
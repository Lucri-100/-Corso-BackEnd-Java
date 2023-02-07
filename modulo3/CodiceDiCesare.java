import java.util.Scanner;

public class CodiceDiCesare {
    public static void main(String[] args) {

        System.out.println(criptaStringa("abxyz", 3));
        System.out.println(decriptaStringa("deabc", 3));
    }

    private static String criptaStringa(String messaggio, int chiave) {
        char[] caratteri = messaggio.toLowerCase().toCharArray();

        for (int i=0; i<caratteri.length; i++) {
            if (chiave>0)
                caratteri[i] = (char)(((int)caratteri[i] + chiave - 96) % 26 + 96);
            else {
                caratteri[i] = (char)(((int)caratteri[i] + chiave + 26 - 97) % 26 + 97);
            }
        }
        return new String(caratteri);
    }

    private static String decriptaStringa(String messaggio, int chiave) {
        return criptaStringa(messaggio, -chiave);
    }
}

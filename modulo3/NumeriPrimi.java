import java.util.Scanner;

public class NumeriPrimi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserisci un numero: ");
        int n = sc.nextInt();

        if(n<1)
            throw new RuntimeException("Valore non ammesso!");
        for(int i=1; i<=n; i++){
            if(isPrime(i))
                System.out.println(i + " ");
        }
    }

    private static boolean isPrime(int numero){
        int tot=0;
        boolean ris = false;

        switch(numero){
            case 1:
                return false;
            case 2:
                return true;
            case 3:
                return true;
            default:
                if(numero%2==0)
                    return false;
                else{
                    for(int i=3; i<numero; i+=2){
                        if(numero%i==0){
                            tot = 1;
                            return false;
                        }
                    }
                }
                return true;
        }
    }
}

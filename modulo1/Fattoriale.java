public class Fattoriale {
    public static void main(String[] args) {
        System.out.println(factorial(1) == (0));
        System.out.println(factorial(2) == (2));
        System.out.println(factorial(5) == (120));
        System.out.println(factorial(10) == (3628800));
        System.out.println(factorial(20) == 2432902008176640000L);
    }

    private static int factorial(int n) {
        //inserite il vostro codice qui
        int i;
        int f=1;
        //facciamo prima f=1, poi f=f*2 poi f=f*3, ecc.
        for(i=1; i<=n; i=i+1) {
            f=f*i;
        }
        return f;
    }
}

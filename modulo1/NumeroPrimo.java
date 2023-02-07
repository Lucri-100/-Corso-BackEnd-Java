public class NumeroPrimo {
    public static void main(String[] args) {
        int number = 0;
        System.out.println(isPrime(number));
        number = 1;
        System.out.println(isPrime(number));
        number = 2;
        System.out.println(isPrime(number));
        number = 17;
        System.out.println(isPrime(number));
        number = 631;
        System.out.println(isPrime(number));
        number = 634;
        System.out.println(!isPrime(number));
        number = 999;
        System.out.println(!isPrime(number));
        number = 997;
        System.out.println(isPrime(number));
    }

    private static boolean isPrime(int number) {
        //inserite qui il vostro codice
        if (number<2)
            return false;
        if (number<=3)
            return true;
        if (number%2==0)
            return false;
        for (int i=3;i<number;i=i+2){
            /* si fa un ciclo partendo con i che da 3 assume i numeri dispari minori al numero da esaminare n,
            non serve controllare con i numeri pari perchè n non è pari  */
            if (number%i==0)
                return false;
        }
        return true;
    }
}
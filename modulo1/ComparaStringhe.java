public class ComparaStringhe {
    public static void main(String[] args) {
        String a = "ciao come va ?";
        String b = "cIao come vA ?";
        String c = "ciao come va ";
        System.out.println("2".equals(""+compareStrings(a, b, c)));
        a = "ciao come va ?";
        b = "cIaoo come vA ?";
        c = "ciao come va a";
        System.out.println("1".equals(""+compareStrings(a, b, c)));
        a = "ciao come va ?";
        b = "cIao come va ?";
        c = "ciao come vA ?";
        System.out.println("3".equals(""+compareStrings(a, b, c)));
    }

    private static int compareStrings(String a, String b, String c) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        c = c.toLowerCase();
        if(a.equals(b)){
            if(b.equals(c)) {
                System.out.println("3");
                return 3;
            } else {
                System.out.println("2");
                return 2;
            }
        }
        else if(b.equals(c)){
            System.out.println("2");
            return 2;
        }
        else{
            System.out.println("Tutte diverse");
            return 1;
        }
    }
}
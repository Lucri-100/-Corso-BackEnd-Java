public class TrovaPerfetti {
    public static void main(String[] args) {
        perfetti(1000);
    }

    public static void perfetti(int max){
        int n = 1;
        while(n < max)
        {
            int divisore;
            int sommaDivisori;
            divisore = 1;
            sommaDivisori = 0;
            while(divisore <= n/2)
            {
                if(n%divisore == 0)
                    sommaDivisori = sommaDivisori + divisore;
                divisore = divisore + 1;
            }
            if(sommaDivisori == n)
                System.out.println(n+" e' perfetto");
            n = n + 1;
        }
    }
}

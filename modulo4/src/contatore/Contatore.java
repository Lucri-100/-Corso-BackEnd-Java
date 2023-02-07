package contatore;

public class Contatore {
    private int val;

    public Contatore(){
        val = 0;
    }

    public Contatore(int k){
        val = k;
    }

    public void reset(){
        val = 0;
    }

    public void reset(int k){
        val = k;
    }

    public void inc(){
        val++;
    }

    public void inc(int k){
        val += k;
    }

    public int getVal(){
        return val;
    }

    public String toString(){
        return "Contatore: " + val;
    }
}

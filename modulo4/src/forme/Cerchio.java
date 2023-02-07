package forme;

public class Cerchio {
    public int raggio;
    private Colore colore;
    public Cerchio(int r){
        raggio = r;
        colore = Colore.NERO;
    }
    public double circonferenza(){
        return 2*Math.PI*raggio;
    }

    public double area(){
        return raggio*raggio*Math.PI;
    }

    public void setColore(int r, int g, int b){
        colore = new Colore(r, g, b);
    }

    public Colore getColore(){
        return colore;
    }
}

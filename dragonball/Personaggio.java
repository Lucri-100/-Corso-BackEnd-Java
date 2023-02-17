package dragonball;

public class Personaggio implements Comparable<Personaggio>{
    private String nome;
    private double pv;
    private int power;
    private double schivata;
    private double resistenza;
    private Razza razza;
    private Attacco[] attacchi = new Attacco[5];
    //private double txc = Math.random();

    public Personaggio(String nome, double pv, int power, Razza razza, Attacco[] attacchi) {
        this.nome = nome;
        this.pv = pv;
        this.power = power;
        this.schivata = Math.random()+0.01;
        this.resistenza = Math.random()+0.01;
        this.razza = razza;
        this.attacchi = attacchi;
        attacchi[0].setDanno(this.power);
    }

    public double getSchivata() {
        return schivata;
    }

    public double getPv() {
        return pv;
    }

    public String getNome() {
        return nome;
    }

    public Attacco[] getAttacchi() {
        return attacchi;
    }

    public void setPv(double pv) {
        this.pv = pv;
    }

    public double getResistenza() {
        return resistenza;
    }



    @Override
    public int compareTo(Personaggio p) {
        if(p==null || p.getClass()!=this.getClass())
            return -2;
        //Personaggio p1=(Personaggio)p;
        if(this.pv>p.pv) return 1;
        else if (this.pv==p.pv) return 0;
        return -1;
    }
}

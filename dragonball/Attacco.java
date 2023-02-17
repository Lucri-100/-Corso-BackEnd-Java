package dragonball;

public class Attacco {
    private String nome;
    private int danno;
    private double txc;

    public Attacco(String nome) {
        this.nome = nome;
        this.txc = Math.random()+0.01;
    }

    public Attacco(String nome, int danno) {
        this.nome = nome;
        this.danno = danno;
        this.txc = Math.random()+0.01;
    }

    public String getNome() {
        return nome;
    }

    public int getDanno() {
        return danno;
    }

    public double getTxc() {
        return txc;
    }

    public void setDanno(int danno) {
        this.danno = danno;
    }
}

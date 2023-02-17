package dragonball;

import java.util.Random;

public class Combattimento {
    private Personaggio personaggio1;
    private Personaggio personaggio2;

    public static void combatti(Personaggio personaggio1, Personaggio personaggio2){
        // 1. Scelta chi inizia -> Random
        tiroIniziativa(personaggio1, personaggio2);
    }

    public static void tiroIniziativa(Personaggio personaggio1, Personaggio personaggio2){
        double tiro=Math.random();
        if(tiro>0.49) {
            Personaggio temp;
            temp=personaggio1;
            personaggio1=personaggio2;
            personaggio2=temp;
        };
        combattimento(personaggio1, personaggio2);
    }

    public static void combattimento(Personaggio attaccante, Personaggio difensore){
        if(!checkCondizioni(attaccante, difensore)){
            stampaVincitore(attaccante, difensore);
            return;
        }
        //sceglie l'attacco
        Random rand = new Random();
        int attaccoScelto=rand.nextInt(5);
        if (Math.random() <= calcolaTxc(attaccante, difensore, attaccoScelto)) {
            //Il colpo è andato a segno
            System.out.println("Attaccante: " + attaccante.getNome() + " usa " + attaccante.getAttacchi()[attaccoScelto].getNome());
            assegnaDanno(difensore, attaccante.getAttacchi()[attaccoScelto]);
            combattimento(difensore, attaccante);
        }
        else{
            System.out.println("L'attacco di: " + attaccante.getNome() + " è andato a vuoto!");
            combattimento(difensore, attaccante);
        }
    }

    public static boolean checkCondizioni(Personaggio attaccante, Personaggio difensore){
        return (attaccante.getPv()<=0 || difensore.getPv()<=0) ? false : true;
    }

    public static void stampaVincitore(Personaggio personaggio1, Personaggio personaggio2){
        if(personaggio1.getPv()<=0) System.out.println("Il vincitore è " + personaggio2.getNome());
        else System.out.println("Il vincitore è: " + personaggio1.getNome());
    }

    public static double calcolaTxc(Personaggio att, Personaggio dif, int attaccoScelto){
        double probColpo;
        probColpo=att.getAttacchi()[attaccoScelto].getTxc()*dif.getSchivata();
        return probColpo;
    }

    public static void assegnaDanno(Personaggio difensore, Attacco attacco){
        difensore.setPv(difensore.getPv()-difensore.getResistenza()*attacco.getDanno());
        System.out.println("Il difensore " + difensore.getNome() + " è stato colpito, e la sua vita è scesa a " + difensore.getPv());
    }
}

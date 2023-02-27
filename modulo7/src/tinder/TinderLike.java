package tinder;

import java.util.*;

public class TinderLike {
    private List<Utente> utenti;

    public TinderLike(){
        this.utenti = new ArrayList<>();
    }

    public List<Utente> getUtenti() {
        return utenti;
    }

    public void addUtente(Utente utente){
        utenti.add(utente);
    }

    public void removeUtente(Utente utente){
        utenti.remove(utente);
    }

    public Utente cercaUtenteConInteressiComuni(Utente u1){
        Utente utenteConPiuInteressiComuni = null;
        int maggNumInteressiComuni = 0;

        for(Utente u2: utenti){
            if(!u2.equals(u1)){
                int numInteressiComuni = 0;
                for(Interesse interesseU1: u1.getInteressi()){
                    for(Interesse interesseU2: u2.getInteressi()){
                        if(interesseU1.getCodice() == interesseU2.getCodice()){
                            numInteressiComuni++;
                        }
                    }
                }
                if(numInteressiComuni > maggNumInteressiComuni){
                    maggNumInteressiComuni = numInteressiComuni;
                    utenteConPiuInteressiComuni = u2;
                }
            }
        }
        return utenteConPiuInteressiComuni;
    }

    @Override
    public String toString() {
        return utenti + "\n";

    }
}

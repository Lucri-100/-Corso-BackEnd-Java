package tinder;

import java.util.ArrayList;
import java.util.List;

public class Utente {
    private String nome;
    private List<Interesse> interessi;

    public Utente(String nome) {
        this.nome = nome;
        this.interessi = new ArrayList<>();
    }

    public List<Interesse> getInteressi() {
        return interessi;
    }

    public void addInteresse(Interesse interesse){
        interessi.add(interesse);
    }

    @Override
    public String toString() {
        return "Utente{" +
                "nome='" + nome + '\'' +
                ", interessi=" + interessi + "\n";
    }
}

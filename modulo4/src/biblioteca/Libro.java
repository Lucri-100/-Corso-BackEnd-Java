package biblioteca;

public class Libro {
    private int index;
    private String autore;
    private String nome;

    public Libro(int index, String autore, String nome) {
        this.index = index;
        this.autore = autore;
        this.nome = nome;
    }

    public int getIndex() {
        return index;
    }
}

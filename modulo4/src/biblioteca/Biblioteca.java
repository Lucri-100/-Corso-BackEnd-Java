package biblioteca;

public class Biblioteca {
    private Libro[] libri;

    public Biblioteca(Libro[] libri){
        this.libri = libri;
        this.ordinaLibri();
    }

    /**
     * Ordina gli indici dei libri tramite l'algoritmo Sort
     */
    public void ordinaLibri(){
        for(int i=0; i<libri.length; i++){
            int minIndex = i;
            for (int j=i+1; j<libri.length; j++)
                if(libri[j].getIndex()<libri[minIndex].getIndex())
                    minIndex = j;
            Libro minIndexBook = libri[minIndex];
            libri[minIndex] = libri[i];
            libri[i] = minIndexBook;
        }
    }

    public boolean esisteLibro(Libro libroDaCercare){
       return esisteLibro(libroDaCercare.getIndex());
    }

    public boolean esisteLibro(int libroDaCercare){
        for(Libro libro : libri)
            if(libro.getIndex() == libroDaCercare)
                return true;
        return false;
    }

    public Libro[] getLibriOrdinati(){
        return libri;
    }
    public int[] getIndiciLibriOrdinati(){
        Libro[] libriOrdinati = getLibriOrdinati();
        int[] indiciLibri = new int[libriOrdinati.length];
        for(int i=0; i<libriOrdinati.length; i++)
            indiciLibri[i] = libriOrdinati[i].getIndex();
        return indiciLibri;
    }

    public void aggiungiLibro(Libro libro){
        //1. Estendere l'array
        Libro[] newLibri = new Libro[libri.length+1];
        //2. Copiare tutti gli elementi
        for(int i=0; i<libri.length; i++)
            newLibri[i] = libri[i];
        //3. Aggiungere il nuovo libro
        newLibri[libri.length] = libro;
        //4. Ordinare nuovamente l'array
        ordinaLibri();
    }
}

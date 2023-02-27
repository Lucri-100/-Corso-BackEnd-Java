package dizionario;

public class ElementAlreadyContainedException extends Exception{

    public ElementAlreadyContainedException(char message) {
        super("La chiave già esiste!");
    }
}

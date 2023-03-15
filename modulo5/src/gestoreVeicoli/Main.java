package gestoreVeicoli;

public class Main {
    public static void main(String[] args) {
        Automobile automobile = new Automobile("cf123rm", 4, 4);
        Autocarro autocarro = new Autocarro("ca133sm", 4, 2);

        System.out.println(autocarro.toString());
        System.out.println(automobile.toString());
    }
}

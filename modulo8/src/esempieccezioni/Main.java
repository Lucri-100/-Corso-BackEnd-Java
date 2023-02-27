package esempieccezioni;

public class Main {
    public static void main(String[] args) {
        int array[] = {1, 2, 3, 4};

        try{
            System.out.println(array[5]);
        } catch(IndexOutOfBoundsException e) {
            System.out.println(e);
        }
        System.out.println("out of try catch");
    }
}

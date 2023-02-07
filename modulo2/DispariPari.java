package src;

import java.util.Arrays;
public class DispariPari {
    public static void main(String[] args) {
        int[] arrayInteri = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(arrayInteri));

        int[] copiaArray = new int [arrayInteri.length];
        for(int i = 0; i < arrayInteri.length; i++) {
            if(arrayInteri[i] % 2 != 0)
                copiaArray[i] = arrayInteri[i];
        }
        System.out.println(Arrays.toString(copiaArray));
    }
}

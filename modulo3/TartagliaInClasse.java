import java.util.Arrays;

public class TartagliaInClasse {
    /* questo metodo prende in input un numero n intero e ritorno un array lungo n+1 che rappresenti
    la n esima riga del triangolo di tartaglia */
    public static void main(String[] args) {
        int[]tartaglioso = genTriangle(5);
        System.out.println(Arrays.toString(tartaglioso));
    }
    public static int[] genTriangle(int n){

        //caso base
        if(n==0){
            int [] array={1};
            return array;
        }

        else{
            int[] oldArray = genTriangle(n-1);
            int[] newArray = new int[n+1];
            newArray[0]=1;
            newArray[newArray.length-1]=1;
            for(int i=1; i<newArray.length-1;i++){
                newArray[i] = oldArray[i-1] + oldArray[i];
            }
            return newArray;
        }
    }
}

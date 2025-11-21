import java.util.HashSet;
import java.util.Set;

/**
 * Escribir un metodo que determine si dos arrays de enteros
 * contienen los mismos elementos, sin importar el orden
 * */

public class EjercicioParcialJun2025 {

    public static void main(String[] args){
        int[] vector1 = {1,2,3,4,4,5};
        int[] vector2 ={ 1,2,3,4,4,5};
        int[] vector3 = {1,2,2,2,3};
        System.out.println("El vector 1 y 2 son iguales? " + iguales(vector1, vector2));
        System.out.println("El vector 1 y 3 son iguales? " + iguales(vector1, vector3));

    }

    public static boolean iguales(int[] v1, int[] v2){

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for(int v : v1)
            set1.add(v);

        for(int v : v2)
            set2.add(v);

        if(set1.equals(set2))
            return true;

        return false;
    }

}

import java.util.HashSet;
import java.util.Set;

public class Ejercicio2 {

    //*
    // Escribir un metodo que, dado un array de
    // enteros, devuelva un nuevo array SIN valores repetidos,
    // utilizando un HashSet
    // */

    public static void main (String[] args) {
        int[] vector = {1,2,3,3,4,5,5,6};

        Set <Integer> nuevoVec = borrarEliminados(vector);
        System.out.println(nuevoVec);

    }

    public static Set<Integer> borrarEliminados(int[] vector){
        Set<Integer> sinRepe = new HashSet<>();
        for (int v: vector){
            sinRepe.add(v);
        }
        return sinRepe;
    }

}

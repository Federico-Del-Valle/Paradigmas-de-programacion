import org.w3c.dom.ls.LSOutput;

import java.util.HashSet;
import java.util.Set;

/**
 * Escribir un metodo que analice si un array de objetos
 * contiene elementos repetidos. Utilizar las clases
 * del JFC que considere convenientes
 * boolean contieneRepetidos(Object[] elementos) ;
 */

public class EjercicioParcial2Jun2025 {


    public static void main(String [] args){
        Integer[] v1 = {1,2,3,4,5,6};
        Integer[] v2 = {1,2,3,4,5,6};
        Integer[] v3 = {1,2,2,2,3,4};

        System.out.println("El v1 tiene repetidos? " + contieneRepetidos(v1));
        System.out.println("El v2 tiene repetidos? " + contieneRepetidos(v2));
        System.out.println("El v2 tiene repetidos? " + contieneRepetidos(v3));
    }


    public static boolean contieneRepetidos(Object[] elementos){
        Set<Object> repetidos = new HashSet<>();
        for (Object o : elementos)
            if(!repetidos.add(o))
                return true;
        return false;
    }

}

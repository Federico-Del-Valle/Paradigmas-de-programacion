import java.util.HashMap;
import java.util.Map;

/**
 * Escribir un metodo que reciba un array de enteros
 * cuente cuantas veces aparece cada numero par
 * por ejemplo
 * array {1,2,2,3,4,4,4}
 * salida { 2- > 2, 4-> 3}
 */

public class Ejercicio3 {

    public static void main (String[] args){
        int[] vec1 = {1,2,2,2,3,4,4};
        int[] vec2 = {1};

        Map<Integer,Integer> pares = contarPares(vec1);

        System.out.println(pares);

    }


    public static Map<Integer, Integer> contarPares(int[] vector){
        Map <Integer, Integer> pares = new HashMap();

        for(int v : vector)
        {
            if(!pares.containsKey(v) && v% 2 == 0)
                pares.put(v, 1);
            else
            if( v% 2 == 0)
                pares.put(v, pares.get(v) + 1);
        }

        return pares;

    }
}

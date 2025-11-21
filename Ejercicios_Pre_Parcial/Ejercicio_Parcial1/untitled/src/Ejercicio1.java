import java.util.HashMap;
import java.util.Map;

public class Ejercicio1 {

    public static void main (String[] args) {
        int[] vector = {1,2,2,2,3,4,5,5};
        Map<Integer, Integer> mapa = contarRepetidos(vector);

        System.out.println(mapa);

    }

    public static Map<Integer, Integer> contarRepetidos(int[] vector){
        Map<Integer, Integer> numeros = new HashMap();
        int cont = 0;

        for(int v : vector) {
            if(numeros.containsKey(v))
                numeros.put(v, numeros.get(v) +1);
            else
                numeros.put(v,1);
        }
        return numeros;

    }
}

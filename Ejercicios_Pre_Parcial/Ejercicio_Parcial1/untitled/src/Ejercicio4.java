import java.util.HashMap;
import java.util.Map;

/**
 * Crear un metodo que reciba
 * un vector y un limite
 * contar cuantas veces aparecen numeros que esten por debajo del limite
 */


public class Ejercicio4 {

    public static void main(String[] args){

        int[] vec1 = {1,2,2,2,3,7,8,4};
        int limite = 5;
        Map<Integer, Integer> superan = superanLimite(vec1, limite);
        System.out.println(superan);

    }


    public static Map<Integer, Integer> superanLimite(int[] vector, int limite){
        Map<Integer, Integer> superan = new HashMap<>();

        for(int v : vector){
            if(!superan.containsKey(v) && v < limite)
                superan.put(v, 1);
            else
                if(v < limite)
                    superan.put(v, superan.get(v) +1);
        }
        return superan;
    }

}

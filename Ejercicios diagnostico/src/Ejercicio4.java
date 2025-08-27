import java.util.*;

public class Ejercicio4 {

    public static List<Integer> modasPorFila(int[][] matriz) {
        List<Integer> resultado = new ArrayList<>();

        for (int[] fila : matriz) {
            int moda = fila[0];
            int maxAparicion = 0;

            for (int num : fila) {
                int aparicion = 0;

                for (int i : fila) {
                    if (i == num) {
                        aparicion++;
                    }
                }

                // Actualizar moda si corresponde
                if (aparicion > maxAparicion ||
                        (aparicion == maxAparicion && num > moda)) {
                    moda = num;
                    maxAparicion = aparicion;
                }
            }
            resultado.add(moda);
        }

        return resultado;
    }

    public static void main(String[] args) {
        int[][] matriz = {
                {1, 2, 3, 4},
                {5, -6, -6, 20},
                {1, 1, 10, 10}
        };

        List<Integer> modas = modasPorFila(matriz);
        System.out.println(modas); // [4, -6, 10]
    }
}

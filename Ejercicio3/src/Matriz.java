public class Matriz {
    public static int[][] transformarMatriz(int[][] matriz) {
        int filas = matriz.length;
        int cols = matriz[0].length;
        int[][] resultado = new int[filas][cols];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                int suma = matriz[i][j];
                if (i > 0) suma += matriz[i - 1][j];
                if (i < filas - 1) suma += matriz[i + 1][j];
                if (j > 0) suma += matriz[i][j - 1];
                if (j < cols - 1) suma += matriz[i][j + 1];

                resultado[i][j] = suma;
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        int[][] matriz = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] nueva = transformarMatriz(matriz);

        for (int[] fila : nueva) {
            for (int val : fila) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}

public class Ejercicio2 {

    public static boolean matriz0(int[][] matriz){
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[i].length; j++){
                if(matriz[i][j] == 0){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int [][] matrizOk = new int[][]{
            {4, 2, 6},
            {7, 0, 2}
        };
        int[][] matriz = new int[][]{
                {4, 2, 6},
                {7, 8, 2}
        };
        if(matriz0(matriz))
            System.out.println("La matriz cumple con el ejercicio");
        else
            System.out.println("La matriz no cumple con el ejercicio");

    }
}

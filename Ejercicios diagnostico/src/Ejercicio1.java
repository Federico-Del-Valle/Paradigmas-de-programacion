
public class Ejercicio1 {


    public static boolean sumaDiagonal(int[][] matriz){
        int sumaDiagonal = 0;
        int valor ;

        for(int i = 0;i<matriz.length;i++){
            valor = matriz[i][i];

            if(i > 0)
                if (valor != sumaDiagonal)
                    return false;

            sumaDiagonal +=valor;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrizOk = {
                {1, 2, 3},
                {4, 1, 6},
                {7, 8, 2}
        };

        int[][] matrizNoOk = {
                {1, 2, 3},
                {4, 2, 6},
                {7, 8, 2}
        };
        System.out.println("La matriz es:");
        if(sumaDiagonal(matrizOk))
            System.out.println("La matriz supera el ejercicio");
        else
            System.out.println("La matriz no supera el ejercicio");
    }
}
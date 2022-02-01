package recursividadPracticaEnClase;

/**
 * 
 * Recorrer una matriz de forma recursiva.
 */
public class EP_08_recorreMatriz {
 
    public static void main(String[] args) {
 
        int[][] m = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int j = 0,i = 0;
        
        //llamada inicial
        recorrerMatrizRecursivo(m, i, j);
    }
 
    public static void recorrerMatrizRecursivo(int[][] m, int i, int j) {
 
        //Muestro el numero (sin salto de linea)
        System.out.print(m[i][j] + " ");
 
        //
        if (i != m.length - 1 || j != m[i].length - 1) {
 
            //Indico si llego al final de la fila
            if (j == m[i].length - 1) {
                //Paso a la siguiente fila
                i++;
                //Reinicio la j
                j = 0;
                //Salto de linea (solo formato)
                System.out.println("");
            } else {
                //Paso a la siguiente columna
                j++;
            }
 
            //Volvemos a llamar la función recursivamente
            recorrerMatrizRecursivo(m, i, j);
 
        }
    }
 
}
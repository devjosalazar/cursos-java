package recursividadPracticaEnClase;

public class EP_MatrizTranspuesta {

	public static void main(String[] args) {
		
		
		int[][] matriz = {
				{1,3,5,7},
				{2,4,6,8}		
		};
		
		int [][] matrizTranspuesta = new int [4][2];
		int i = 0;
		int j = 0; 
		
		obtenerMatrizTranspuesta(matriz, matrizTranspuesta,i,j);
		recorrerMatriz(matrizTranspuesta,i,j);

	}


	private static void obtenerMatrizTranspuesta(int[][] matriz, int[][] matrizTranspuesta, int i, int j) {
		
		matrizTranspuesta[j][i] =  matriz[i][j];
		
		//Caso recursivo
		if( i != matriz.length-1 || j != matriz[i].length-1){
			
			if(j == matriz[i].length-1){
				i++;
				j=0;
				System.out.println("");
			}else{
				j++;
			}
			
			obtenerMatrizTranspuesta(matriz, matrizTranspuesta, i, j);
		}
	}
	
	
	private static void recorrerMatriz(int[][] matrizTranspuesta) {
		
		for (int i = 0; i < matrizTranspuesta.length; i++) {
			for (int j = 0; j < matrizTranspuesta[i].length; j++) {
				System.out.print(matrizTranspuesta[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	private static void recorrerMatriz(int[][] matrizTranspuesta, int i, int j) {

		System.out.print(matrizTranspuesta[i][j]+" ");
		if( i != matrizTranspuesta.length-1 || j != matrizTranspuesta[i].length-1){

			if(j == matrizTranspuesta[i].length-1){
				i++;
				j=0;
				System.out.println("");
			}else{
				j++;
			}

			recorrerMatriz(matrizTranspuesta, i, j);
		}
	}
	

}

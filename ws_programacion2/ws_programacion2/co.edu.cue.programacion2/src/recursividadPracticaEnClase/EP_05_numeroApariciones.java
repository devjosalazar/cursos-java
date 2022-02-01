package recursividadPracticaEnClase;

public class EP_05_numeroApariciones {

	public static void main(String[] args) {
		
		
		int [] arreglo = new int[5];
		arreglo[0] = 1;
		arreglo[1] = 1;
		arreglo[2] = 1;
		arreglo[3] = 8;
		arreglo[4] = 5;
		
		int inicio = 0;
		int fin = arreglo.length-1;
		int elem  = 1;
		int apariciones = 0;
		
		apariciones = numeroAparicionesAvanzando(arreglo, inicio, fin, elem);
		
		System.out.println("Número de apariciones = "+ apariciones);

	}

	public static int numeroAparicionesAvanzando(int arreglo[], int inicio, int fin, int elem) {

		if(inicio == fin) {
			if(arreglo[inicio] == elem) {
				return 1;
			}else {
				return 0;
			}
		}else {
			if(arreglo[inicio]!=elem) {
				return numeroAparicionesAvanzando(arreglo, inicio+1, fin, elem);
			}else {
				return 1 + numeroAparicionesAvanzando(arreglo, inicio+1, fin, elem);
			}
		}

	}
	
	
	public static int numeroAparicionesRetrocediendo(int arreglo[], int inicio, int fin, int elem) {

		if(inicio == fin) {
			if(arreglo[inicio] == elem) {
				return 1;
			}else {
				return 0;
			}
		}else {
			if(arreglo[fin]!=elem) {
				return numeroAparicionesRetrocediendo(arreglo, inicio, fin-1, elem);
			}else {
				return 1 + numeroAparicionesRetrocediendo(arreglo, inicio, fin-1, elem);
			}
		}

	}
}

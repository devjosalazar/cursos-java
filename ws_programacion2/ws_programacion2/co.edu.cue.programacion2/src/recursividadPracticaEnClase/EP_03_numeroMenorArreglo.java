package recursividadPracticaEnClase;

public class EP_03_numeroMenorArreglo {

	public static void main(String[] args) {
		
		int [] arreglo = new int[5];
		arreglo[0] = 2;
		arreglo[1] = 3;
		arreglo[2] = 1;
		arreglo[3] = 8;
		arreglo[4] = 5;
		
		int inicio = 0;
		int fin = arreglo.length-1;
		int menor  = 0;
		
		menor = numeroMenor(arreglo, inicio, fin); 
		
		System.out.println("El menor del arreglo es: "+menor);


	}

	public static int numeroMenor(int arreglo[], int inicio, int fin) {
		
		if(inicio == fin) {
			return arreglo[inicio];			
		}else {
			int menor = numeroMenor(arreglo, inicio + 1, fin);
			
			if(menor < arreglo[inicio]) {
				return menor;
			}else {
				return arreglo[inicio];
			}
		}
	}
	
}

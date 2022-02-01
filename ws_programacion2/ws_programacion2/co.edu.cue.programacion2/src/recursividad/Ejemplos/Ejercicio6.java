package recursividad.Ejemplos;

public class Ejercicio6 {

	public static void main(String[] args) {
		
		int [] arreglo = new int[5];
		int i = 0;
		arreglo[0] = 1;
		arreglo[1] = 2;
		arreglo[2] = 3;
		arreglo[3] = 4;
		arreglo[4] = 5;
		
		
		recorrerArregloRecursivamente(arreglo, 0);
	}

	private static void recorrerArregloRecursivamente(int[] arreglo, int i) {
		
		if( i == arreglo.length){
			return;
		}else{
			System.out.println("Valor del arreglo en la posicion "+i+ " es = "+ arreglo[i]);
			recorrerArregloRecursivamente(arreglo, i+1);
		}
	}

}

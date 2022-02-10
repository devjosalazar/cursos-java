package collections.ejemplos;

import java.util.Arrays;

public class EjemplosArrays {
	
	
	public static void main(String[] args) {
		
		ordenarArray();
		busquedaArray();
		armarArrays();
		
		
	}
	
	

	public static void ordenarArray() 
	{
		Double [] array = {5.6,12.4,3.5,-2.0};
		Arrays.sort(array);
//		Arrays.sort(array,1,2);
		System.out.println(array[0]);
		System.out.println(array[1]);
		System.out.println(array[2]);
		System.out.println(array[3]);
	}

	public static void busquedaArray() 
	{
		int [] w = {14, -5, 3, 2, 6, -4, 22, 4};
		// llamada a sort() para ordenar w
		Arrays.sort(w);
		// búsqueda de un elemento
		int k;
		int buscar = 45;
		k = Arrays.binarySearch(w, buscar);
		if (k >= 0)
			System.out.println("Elemento de búsqueda<" + buscar + "> en la posicion: " + k);
		else
			System.out.println("Numero no encontrado");
		
	}
	
	
	public static void armarArrays() 
	{
		final int N = 10;
		int [] iv = new int[N];
		char [] cv = new char [N];
		String [] sv = new String [N];
		// llenado de los arrays
		Arrays.fill(iv, 0, iv.length/2, -1);
		Arrays.fill(iv, iv.length/2 +1, iv.length -1, 1);
		Arrays.fill(cv, 'a');
		Arrays.fill(sv, "Paloma");

		for (int i = 0; i < sv.length; i++) {
			System.out.println(sv[i]);
		}

	}
	
	
	

}

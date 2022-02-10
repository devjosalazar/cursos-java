package collections.ejemplos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EjemplosCollections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		variasOperaciones();

	}

	private static void variasOperaciones() {
		
		
		
		int n = 11;
		List lista1;
		// Crea una lista formada por n copias de "Pedro"
		lista1 = Collections.nCopies(n, "Pedro");
		System.out.println(lista1+"\n");
		
		
		
		
		// Crea una lista de objetos Integer, se ordena y se invierte
		List<Integer> lista2 = new ArrayList<Integer>();
		for (int i = 1; i <= n ; i++)
			lista2.add(new Integer((int)(Math.random()*100 +1)));		
		System.out.println(lista2);
		
		
		System.out.println("Máximo: " + Collections.max(lista2)
		+ " \t Mínimo: " + Collections.min(lista2)+"\n");
		
		System.out.println("Datos ordenados");
		Collections.sort(lista2);
		System.out.println(lista2+"\n");
		
		System.out.println("Datos invertidos");
		Collections.reverse(lista2);
		System.out.println(lista2);
		
	}
	
	
	
	
	
	

}

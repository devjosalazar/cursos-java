package collections.ejemplos;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import collections.clases.Cliente;

public class EjemplosConjuntos {

	public static void main(String[] args) {
				
//		ejemplo1_HashSet();
//		ejemplo2_HashSet();
		
//		ejemplo1_TreeSet();
//		ejemplo2_TreeSet();
//		ejemplo3_TreeSet();
		ejemplo4_TreeSetClientes();


	}

	private static void ejemplo2_HashSet() {
		
		Set<String> hs = new HashSet<String>();
		
		hs.add("Alonso");
		hs.add("ALonso");
		hs.add("Conchi");
		hs.add("Emilio");
		hs.add("Gomez");
		hs.add("Manuela");
		hs.add("Manuela");
		
		
		System.out.println(hs);
	}

	private static void ejemplo1_HashSet() {
		// TODO Auto-generated method stub
		Set<Cliente> listaClientes = new HashSet<Cliente>();
		
		Cliente cliente1 = new Cliente();
		cliente1.setNombres("Juan");
		cliente1.setCedula("1096");
		
		Cliente cliente2 = new Cliente();
		cliente2.setNombres("Carlos");
		cliente2.setCedula("1095");

		
		Cliente cliente3 = new Cliente();
		cliente3.setNombres("Juan");
		cliente3.setCedula("1094");

		
		listaClientes.add(cliente1);
		listaClientes.add(cliente2);
		listaClientes.add(cliente1);
		
		
		
		for (Cliente cliente : listaClientes) {
			System.out.println("Clientes:"+ cliente.getNombres());
		}
		
		
	}
	
	private static void ejemplo1_TreeSet() {
		
		class Comparacion implements Comparator {
			
			public int compare(Object o1, Object o2) {
				//Compara cadenas ignorando las may/min
				
				int resultado = ((String) o1).compareTo((String) o2);
				return resultado;
			}
		}
		
		System.out.println("Iniciando ejemplo TreeSet");
		
		
		
		
//		Set<String> ts = new TreeSet<String>();
		Set<String> ts = new TreeSet<String>(new Comparacion());
		
		System.out.println("aca");
		ts.add("Alonso");
		ts.add("alonso");
		ts.add("Conchi");
		ts.add("Emilio");
		ts.add("Gómez");
		ts.add("manuela");
		ts.add("Manuela");
		System.out.println(ts);
		
	}

	
	
	private static void ejemplo2_TreeSet() {
//		Crear dos conjuntos ordenados cuyos elementos sean cadenas de caracteres (String). Realizar
//		operaciones de insertar, eliminar, obtener subconjunto
		
		String [] cad1 = {"Libro", "Mesa", "mes", "Papel", "Papelera","armario", "globo"};
		
		TreeSet<String> conjunto1;
		conjunto1 = new TreeSet<String>();
		
		
		for (int i = 0; i < cad1.length; i++)
			conjunto1.add(cad1[i]);
		
		
		System.out.println("Conjunto ordenado, sin comparador: "+ conjunto1);
		System.out.println("-----------------------------------------------"+"\n");
		
		// eliminar un elemento
		if (conjunto1.remove("Mes"))
			System.out.println("Eliminado - Mes - de conjunto 1 "+ conjunto1);
		else
			System.out.println("No se encuentra - Mes - en conjunto 1 "+ conjunto1);
		System.out.println("-----------------------------------------------"+"\n");
		
		
		
		
		// Obtener un subconjunto y operaciones
		Set sc1;
		sc1 = conjunto1.subSet("Libro", "armario");
		System.out.println("Subconjunto : " + sc1);
		sc1.add("Marta");
		System.out.println("Subconjunto modificado: " + sc1);
		System.out.println("Conjunto origen modificado: " + conjunto1);
		conjunto1.add("lupi"); conjunto1.add("Luna");
		System.out.println("Subconjunto modificado: " + sc1);
		System.out.println("Conjunto origen modificado: " + conjunto1);
	}
	
	private static void ejemplo3_TreeSet() {
//		Crear dos conjuntos ordenados cuyos elementos sean cadenas de caracteres (String). Realizar
//		operaciones de insertar, eliminar, obtener subconjunto
		
		class Compara implements Comparator
		{
			public int compare (Object x1, Object x2)
			{
				String c1 = (String) x1;
				String c2 = (String) x2;
				c1 = c1.toUpperCase();
				c2 = c2.toUpperCase();
				int resultado = c1.compareTo(c2);
				return resultado;
			}
		}
		
		String [] cad2 = {"lupi", "Maria", "maria", "Julian","Esperanza", "Miguel", "maite", "marta"};
		
		
		TreeSet<String> conjunto2;
		conjunto2 = new TreeSet(new Compara());
		
		
		for (int i = 0; i < cad2.length; i++)
			conjunto2.add(cad2[i]);
		
		System.out.println("Conjunto ordenado, con comparador: "+ conjunto2);
		System.out.println("-----------------------------------------------"+"\n");
		
		
		
		if (conjunto2.remove("MAITE"))
			System.out.println("Eliminado - MAITE - de conjunto 2 "+ conjunto2);
		else
			System.out.println("No se encuentra - MAITE - en conjunto 2" + conjunto2);
		
		System.out.println("-----------------------------------------------"+"\n");
		
	}
	
	
	private static void ejemplo4_TreeSetClientes() {
	
		
//		class Comparacion implements Comparator {
//			public int compare(Object o1, Object o2) {
//				
//				Cliente c1 = (Cliente) o1;
//				Cliente c2 = (Cliente) o2;
//				int resultado = c1.getNombres().compareToIgnoreCase(c2.getNombres());
//				return resultado;
//			}
//		}
		
		
//		Set<Cliente> listaClientes = new TreeSet<>(new Comparacion());
		Set<Cliente> listaClientes = new TreeSet<>();
		
		Cliente cliente1 = new Cliente();
		cliente1.setNombres("juan");
		cliente1.setApellidos("arias");
		cliente1.setCedula("125454");
		
		listaClientes.add(cliente1);
		
		
		cliente1 = new Cliente();
		cliente1.setNombres("pedro");
		cliente1.setApellidos("arias");
		cliente1.setCedula("123");
		
		listaClientes.add(cliente1);
		
		
		cliente1 = new Cliente();
		cliente1.setNombres("Juan");
		cliente1.setApellidos("arias");
		cliente1.setCedula("125454");
		
		listaClientes.add(cliente1);
		
		for (Cliente cliente : listaClientes) {
			System.out.println(cliente.getNombres());
		}
		
		
	}


}

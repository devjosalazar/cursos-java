package collections.ejemplos;

import java.util.ArrayList;
import java.util.Iterator;

public class EjemplosArrayList {

	
	public static void main(String[] args) {
		
		//ArrayList
		adicionarELementos();
		eliminarELementos();
		variasFunciones();

	}

	private static void adicionarELementos() {
		
		ArrayList<String> lista=new ArrayList<>();
		
		System.out.println("Inicio array list");
		
		int valor = 0;
		
        lista.add("Elemento 1");
        lista.add("Elemento 2");
        lista.add("Elemento 3");
        lista.add("Elemento 4");
        
        for(Object objeto:lista){ 
            System.out.println(objeto); 
        }
        
        Iterator<String> ite = lista.iterator();
        Object objeto = null;
        while (ite.hasNext()){
        	objeto = ite.next();
          System.out.println(objeto);
      }

	}
	
	
	private static void eliminarELementos() {
		
		ArrayList<String> lista=new ArrayList<>();
        lista.add("1");
        lista.add("2");
        lista.add("3");
        lista.add("3");
        lista.add("4");
        
        
        
        for(Object objeto:lista){ 
            System.out.println(objeto); 
        }
        
        Iterator<String> ite = lista.iterator();
        String valor = "";
        while (ite.hasNext()){
        	valor = ite.next();
        	if(valor.equals("3"))
        		ite.remove();
        }

	}

	private static void variasFunciones() {

		ArrayList<Integer> lista = new ArrayList<>();
        
        //Metodo add. añade elementos a nuestra lista
        lista.add(1);
        lista.add(2);
        lista.add(3);
         
        System.out.println("Agregar");
        System.out.println(lista.toString()+"\n");
         
        //Metodo remove, elimina elementos de nuestra lista mediente indice
        lista.remove(2); //Elimino el ultimo elemento, no el elemento 2
         
        System.out.println("Eliminar");
        System.out.println(lista.toString()+"\n");
         
        //Metodo size, indica el numero de elementos de la lista
         
        System.out.println("Obtener el Tamaño");
        System.out.println(lista.size()+"\n");
         
        //Metodo get, devolvemos un elemento de un indice
         
        System.out.println("Obtener un elemento de la lista");
        System.out.println(lista.get(0)+"\n"); //Primer elemento
         
        //Metodo Iterator, util para recorrer un arrayList
        System.out.println("ITERATOR");
        Iterator<Integer> it = lista.iterator();
        int num;
        while (it.hasNext()){
            num = it.next();
            System.out.println(num);
        }
         
        //Metodo indexOf, util para saber la posicion de un elemento
        System.out.println("Posición de un elemento");
        System.out.println(lista.indexOf(5)+"\n");
         
        //Metodo Clear, elimina todos los elementos
        lista.clear();
//        lista.removeAll(lista);
        System.out.println("Limpiar toda la lista");
        System.out.println(lista.toString()+"\n");
         
        //Metodo isEmpty, indica si un arraylist esta vacio o no
        System.out.println("isEmpty");
        System.out.println(lista.isEmpty()+"\n");
	}
	
	

}

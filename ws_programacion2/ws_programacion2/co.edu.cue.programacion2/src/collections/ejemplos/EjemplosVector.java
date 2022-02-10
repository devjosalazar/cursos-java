package collections.ejemplos;

import java.util.Vector;

import javax.lang.model.type.DeclaredType;

public class EjemplosVector {

	
	public static void main(String[] args) {
		
//		declaracionDistintoTipo();
		declaracionMismoTipo();
	}



	private static void declaracionDistintoTipo() {
		Vector <String> vc = new Vector<String>();
		vc.addElement("Lontananza");
//		vc.addElement(new Integer(12)); // error de compilación
		
	}
	
	
	private static void declaracionMismoTipo() {

		Vector vc = new Vector ();
		vc.addElement("Lontananza");
		vc.addElement(new Integer(12)); // correcto
		
		System.out.println(vc.get(0));
		System.out.println(vc.get(1));
	}
}

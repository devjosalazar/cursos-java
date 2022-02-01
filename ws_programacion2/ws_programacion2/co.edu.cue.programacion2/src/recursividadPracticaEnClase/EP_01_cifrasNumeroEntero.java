package recursividadPracticaEnClase;

public class EP_01_cifrasNumeroEntero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int cifras  = 0;
		cifras = cifrasNumeroEntero(3245);
		System.out.println(cifras);
		
	}

//	1) Cantidad de cifras de un número:
//	Hallar la cantidad de cifras d un número entero.

public static int cifrasNumeroEntero(int n) {
	if(n < 10){
		return 1;
	}else 	{
		return cifrasNumeroEntero( n / 10 ) + 1;
	}
}
	
}

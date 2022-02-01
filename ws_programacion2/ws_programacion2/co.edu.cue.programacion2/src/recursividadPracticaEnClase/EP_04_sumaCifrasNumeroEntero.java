package recursividadPracticaEnClase;

public class EP_04_sumaCifrasNumeroEntero {

	public static void main(String[] args) {
		
		int n = 2345;
		int sumaCifras = 0;
//		sumaCifras = sumaCifras(n);
//		System.out.println("Valor suma cifras = "+ sumaCifras);

		sumaCifras = sumarCifrasEntero(n);
		System.out.println("Valor suma cifras = "+ sumaCifras);

		
	}

	public static int sumaCifras(int n) {

		if (n < 10) {
			return n;
		} else {
			return sumaCifras(n / 10) + n % 10;
		}
	}
	//Ho2la22021
	//222021
	
	public static int sumarCifrasEntero(int numero) {
		
		int suma = 0;
		
		while(numero > 10){
			
			suma = suma + (numero % 10);
			numero = numero /10;
		}
		suma = suma + numero;
		return suma;
	}
	
	
}

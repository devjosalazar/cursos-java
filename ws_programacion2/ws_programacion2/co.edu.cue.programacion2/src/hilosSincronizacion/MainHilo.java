package hilosSincronizacion;

public class MainHilo {

	public static void main(String[] args) {
		

//		HiloPropio1 miHilo1 = new HiloPropio1();
//		HiloPropio2 miHilo2 = new HiloPropio2();
//		miHilo1.runHilo("Hilo 1");
//		miHilo2.runHilo("Hilo 2");
		
		ManejadorHilos manejadorHilos = new ManejadorHilos();
		manejadorHilos.runHiloServicio1(2);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		manejadorHilos.runHiloServicio2();

		
	}


}

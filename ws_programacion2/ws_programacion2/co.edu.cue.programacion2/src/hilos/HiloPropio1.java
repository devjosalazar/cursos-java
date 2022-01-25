package hilos;

public class HiloPropio1 extends Thread{
	
	private boolean runHilo;
	private int contador = 1;
	private String nombreHilo;
	
	public HiloPropio1() {
		
	}
	
	public void runHilo(String nombreHilo){
		runHilo = true;
		this.nombreHilo = nombreHilo;
		this.start();
	}
	
	public void stopHilo() {
		runHilo = false;
	}
	
	@Override
	public void run() {

		while (runHilo == true) {
			
			
			
		}
	}
	
}

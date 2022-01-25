package hilos.ejercicios;

public class ManejadorHilos implements Runnable{
	
	Thread hiloServicio1;
	Thread hiloServicio2;
	
	private int contador;
	private int numeroBase;
	private String variable;
	
	
	public ManejadorHilos() {
		
	}

	
	public void runHiloServicio1() {
		hiloServicio1 = new Thread(this);
		contador = 1;
		hiloServicio1.start();
	}


	public void runHiloServicio2() {
		hiloServicio2 = new Thread(this);
		hiloServicio2.start();
	}
	
	
	@Override
	public void run() {
		
		//Semaforo
		
		Thread hiloActual = Thread.currentThread();
		
		if(hiloActual == hiloServicio1){
			iniciarOperacionHiloServicio1();
		}
		
		if(hiloActual == hiloServicio2){
			iniciarOperacionHiloServicio2();
		}
	}

	//Hilo 1: Escribir en consola cierta información que se 
	//va a estar concatenando a una variable String durante un tiempo determinado (6 s).
	
	private void iniciarOperacionHiloServicio1() {
		int resultado = 0;
		variable = "";
		Long tiempoActual = System.currentTimeMillis();// la hora actual del sistema en milisegundos
		
		Long tiempoFinal = tiempoActual + 6000;
		
		while (tiempoActual < tiempoFinal) {
			
			System.out.println("Tiempo actual = "+ tiempoActual);
			
			variable = variable + "-hola";
			System.out.println(variable);
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			tiempoActual = System.currentTimeMillis();
			
			System.out.println("Tiempo actual = "+ tiempoActual);
			System.out.println("Tiempo final = "+ tiempoFinal);
		}
	}

	private void iniciarOperacionHiloServicio2() {
	}

	
	
}

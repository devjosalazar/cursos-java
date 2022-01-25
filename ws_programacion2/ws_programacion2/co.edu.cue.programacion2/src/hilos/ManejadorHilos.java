package hilos;

public class ManejadorHilos implements Runnable{
	
	Thread hiloServicio1;
	Thread hiloServicio2;
	
	private int contador;
	private int numeroBase;
	
	
	public ManejadorHilos() {
		
	}

	
	public void runHiloServicio1(int numeroBase) {
		hiloServicio1 = new Thread(this);
		this.numeroBase = numeroBase;
		contador = 1;
		hiloServicio1.start();
	}


	public void runHiloServicio2() {
		hiloServicio2 = new Thread(this);
		hiloServicio2.start();
	}
	
	
	@Override
	public void run() {
		Thread hiloActual = Thread.currentThread();
		
		if(hiloActual == hiloServicio1){
			iniciarOperacionHiloServicio1();
		}
		
		if(hiloActual == hiloServicio2){
			iniciarOperacionHiloServicio2();
		}
	}


	private void iniciarOperacionHiloServicio1() {
		int resultado = 0;
		
		while (contador <= 10) {
			resultado = numeroBase * contador;
			System.out.println(numeroBase+"x"+contador+" = "+resultado);
			contador++;
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void iniciarOperacionHiloServicio2() {
		int auxContador = 1;

		while (auxContador <=3) {
			numeroBase = numeroBase + numeroBase;
			System.out.println("Numero base:" + numeroBase);
			auxContador++;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	
}

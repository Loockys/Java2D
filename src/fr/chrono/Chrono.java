package fr.chrono;

public class Chrono implements Runnable {

	private final int PAUSE = 6;
	
	@Override
	public void run() {
		
		int count = 0;
		int time = 0;
		
		while (true) {
			try {
				Thread.sleep(PAUSE);
				
			
				
				
				
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}

package saro_artist;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class client extends Thread {
	private int numCliente;								//Id cliente
	private Random rnd = new Random();
	
	public client(int numCliente)
	{
		this.numCliente = numCliente;
	}
	
	public void run()
	{
		try {
			System.out.println("E' arrivato il cliente " + numCliente);
			if(artist.sedieSemaforo.tryAcquire(artist.tMaxWait, TimeUnit.SECONDS))									// Prova ad acquisire una sedia per un tempo massimo definito da tMaxWait
			{
				System.out.println("Il cliente " + numCliente + " ha trovato una sedia libera e si è seduto");
				while(true)
				{
					if(artist.artistaSemaforo.tryAcquire())
					{
						ritratto(numCliente);							// Chiama il metodo per fare il ritratto al cliente
						artist.artistaSemaforo.release();
						artist.sedieSemaforo.release();
						break;
					}
				}
			} else {
				System.out.println("Il cliente " + numCliente + " ha aspettato troppo e se ne è andato");
			}
		}
		catch(InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	private void ritratto(int numCliente) throws InterruptedException
	{
		System.out.println("L' artista sta facendo il ritratto al cliente " + numCliente);
		int tempoRitratto = rnd.nextInt(4000) + 1000;															// Genera un tempo casuale per la durata del ritratto
		Thread.sleep(tempoRitratto);																					// Mette il thread in pausa per simulare il ritratto
		System.out.println("L' artista ha terminato il ritratto al cliente " + numCliente);
	}
}

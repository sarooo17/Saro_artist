package saro_artist;

import java.util.concurrent.Semaphore;

public class artist {
	private static final int nSedie = 4;				// Numero massimo di sedie disponibili per i clienti
	public static final int tMaxWait = 10; 		// Tempo massimo di attesa per un cliente
	
	public static Semaphore artistaSemaforo = new Semaphore(1);					// Semaforo per il controllo dell'accesso all'artista (1 per risorsa esclusiva)
	public static Semaphore sedieSemaforo = new Semaphore(nSedie);		// Semaforo per il controllo delle sedie disponibili
	
	public void lavoro()
	{
		for(int i = 1; i <= 10; i++)
		{
			client cliente = new client(i);
			cliente.start();
		}
	}
}

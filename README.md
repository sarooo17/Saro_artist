# Saro_artist
Un artista da strada esegue delle caricature e dei ritratti a carboncino.
L'algoritmo implementato nel codice è una simulazione di un'attività di un artista che deve fare dei ritratti per i clienti. Ecco una spiegazione dell'algoritmo:

Nel metodo `main` della classe `app`, viene creato un oggetto `artist` e viene chiamato il metodo `lavoro` per avviare la simulazione.

Il metodo `lavoro` nella classe `artist` avvia un ciclo `for` che itera 10 volte. Ad ogni iterazione, viene creato un nuovo oggetto `client` con un ID specifico e viene avviato come thread.

La classe `client` estende la classe `Thread` e ha un costruttore che imposta l'ID del cliente.

Il metodo `run` della classe `client` contiene la logica eseguita da ogni thread cliente. All'inizio, viene stampato un messaggio che indica l'arrivo del cliente.

Successivamente, il cliente prova ad acquisire una sedia utilizzando il semaforo `sedieSemaforo` con un tempo massimo di attesa definito da `tMaxWait` utilizzando il metodo `tryAcquire` con un timeout. Se riesce ad acquisire una sedia, viene stampato un messaggio che indica che il cliente ha trovato una sedia libera e si è seduto.

Dopodiché, il cliente entra in un ciclo `while(true)` per cercare di acquisire il semaforo `artistaSemaforo` per ottenere accesso all'artista e farsi fare il ritratto.

Se il cliente riesce ad acquisire il semaforo `artistaSemaforo`, chiama il metodo `ritratto` per simulare il processo di fare il ritratto al cliente corrente. Successivamente, rilascia entrambi i semafori (`artistaSemaforo` e `sedieSemaforo`) per consentire ad altri clienti di accedere all'artista o alle sedie e interrompe il ciclo `while` con `break`.

Se il cliente non riesce ad acquisire una sedia entro il tempo massimo di attesa (`tMaxWait`), viene stampato un messaggio che indica che il cliente ha aspettato troppo e se ne è andato.

Il metodo `ritratto` esegue la simulazione del processo di fare il ritratto al cliente. Stampa un messaggio che indica che l'artista sta facendo il ritratto al cliente corrente, genera un tempo casuale per la durata del ritratto e mette il thread in pausa utilizzando il metodo `sleep` per simulare il processo di ritratto. Infine, stampa un messaggio che indica che l'artista ha terminato il ritratto per il cliente corrente.

In termini di sincronizzazione dei processi, il codice utilizza semafori per controllare l'accesso all'artista e alle sedie. Il semaforo `artistaSemaforo` viene utilizzato per garantire che solo un cliente alla volta possa acquisire l'accesso all'artista e farsi fare il ritratto. Il semaforo `sedieSemaforo` viene utilizzato per controllare il numero massimo di clienti che possono essere

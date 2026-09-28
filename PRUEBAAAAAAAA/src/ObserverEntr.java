import java.io.*;
import java.net.*;
import java.util.Random;

public class ObserverEntr implements Runnable {

    private final String host;
    private final int puerto;
    private final Random random = new Random();

    public ObserverEntr(String host, int puerto) {
        this.host = host;
        this.puerto = puerto;
    }

    @Override
    public void run() {
        while (true) {
            esperarEvento();
            String mensaje = "Evento detectado a las " + System.currentTimeMillis()+" Hola bb";
            enviarMensajeAlServer(mensaje);
        }
    }
    private void esperarEvento() {
        try {
            int esperaMs = 2000 + random.nextInt(3000);
            Thread.sleep(esperaMs);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    private void enviarMensajeAlServer(String mensaje) {
        try (
                Socket socket = new Socket(host, puerto);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            out.println(mensaje);
            System.out.println("-> " + mensaje);
        } catch (IOException e) {
            System.out.println("OBSERVER No pude conectar al server: " + e.getMessage());
        }
    }
}

import java.io.*;
import java.net.*;

public class Servidor implements Runnable {

    private final int puerto;
    private volatile boolean activo = true;

    public Servidor(int puerto) {
        this.puerto = puerto;
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            System.out.println("[SERVER] Escuchando en el puerto " + puerto + "...");
            while (activo) {
                Socket clienteSocket = serverSocket.accept();
                System.out.println("[SERVER] Cliente conectado: " + clienteSocket.getInetAddress());
                manejarCliente(clienteSocket);
            }
        } catch (IOException e) {
            System.out.println("[SERVER] Error: " + e.getMessage());
        }
    }

    private void manejarCliente(Socket socket) {
        try (
                Socket s = socket;
                BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()))
        ) {
            String mensaje = in.readLine();
            System.out.println("[SERVER] Mensaje recibido -> " + mensaje);
        } catch (IOException e) {
            System.out.println("[SERVER] Error atendiendo cliente: " + e.getMessage());
        }
    }
}

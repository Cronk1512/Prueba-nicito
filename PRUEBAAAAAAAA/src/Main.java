import java.util.Scanner;
public class Main {
    public static void main() {
        //        Scanner sc = new Scanner(System.in);
        //        int option;
        //        Tipos tipPok1 = new Tipos("Fuego", "Agua");
        //        Pokemon poke1 = new Pokemon("Volcanion", 100, 50, tipPok1);
        //        EntrenadorCynthia Cynthia = null;
        //        option = sc.nextInt();
        //        System.out.println(option);
        int puerto = 5000;
        Servidor server = new Servidor(puerto);
        ObserverEntr observer = new ObserverEntr("localhost", puerto);
        Thread hiloObserver = new Thread(observer, "Hilo-Observer");
        Thread hiloServer = new Thread(server, "Hilo-Server");
        hiloServer.start();

        hiloObserver.start();
    }
}
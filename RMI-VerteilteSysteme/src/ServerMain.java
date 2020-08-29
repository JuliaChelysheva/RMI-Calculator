import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/*Quelle: https://javarush.ru/groups/posts/2283-rmi-praktika-ispoljhzovanija
Dies ist eine beispielhafte RMI-Anwendung, welche die Multiplikationsberechnungen durchfuehren kann.
Die Argumente werden von dem Client an den Server uebergeben,und der Server fuehrt die Multiplikation durch und gibt
anschlißend das Ergebnis aus.*/

public class ServerMain {
    //Diese Zeichenfolge ist der eindeutige Name des entfernten Objekts.
    // Unter diesem Namen kann das Client-Programm den Server finden:
    public static final String UNIQUE_BINDING_NAME = "server.calculator";

    public static void main(String[] args) throws RemoteException, AlreadyBoundException, InterruptedException {
        //Object Calculator erstellen
        final RemoteCalculationServer server = new RemoteCalculationServer();

        final Registry registry = LocateRegistry.createRegistry(2732);
        //Übergabe des Objects server in die Methode UnicastRemoteObject.exportObject()
        //Somit wird RMI möglich
        Remote stub = UnicastRemoteObject.exportObject(server, 0);

        //Stub wird in RMI-Registry mit einem eindeutigen Namen registriert
        registry.bind(UNIQUE_BINDING_NAME, stub);
//Der Server muss länger aktiv bleiben und auf die Anfrage von dem Client warten
        Thread.sleep(Integer.MAX_VALUE);

    }
}
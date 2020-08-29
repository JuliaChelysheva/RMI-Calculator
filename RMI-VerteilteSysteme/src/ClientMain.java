import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/*Quelle: https://javarush.ru/groups/posts/2283-rmi-praktika-ispoljhzovanija
Dies ist eine beispielhafte RMI-Anwendung, welche die Multiplikationsberechnungen durchfuehren kann.
Die Argumente werden von dem Client an den Server uebergeben,und der Server fuehrt die Multiplikation durch und gibt
anschließend das Ergebnis aus.*/

public class ClientMain {
    //Zunächst muss der Client den eindeutigen Namen des Objekts kennen,
    // dessen Methoden er remote aufruft.
    public static final String UNIQUE_BINDING_NAME = "server.calculator";

    public static void main(String[] args) throws RemoteException, NotBoundException {
//Beispielhafte Portnummer, um auf RMI-Registry zugreifen zu können.
        final Registry registry = LocateRegistry.getRegistry(2732);

        //Object aus Registry bekommen, nach Namen sichen
        Calculator calculator = (Calculator) registry.lookup(UNIQUE_BINDING_NAME);

        //Funktion multiply remote aufrufen
        int multiplyResult = calculator.multiply(20, 30);

        System.out.println(multiplyResult);
    }
}
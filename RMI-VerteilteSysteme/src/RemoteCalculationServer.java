import java.rmi.RemoteException;

/*Quelle: https://javarush.ru/groups/posts/2283-rmi-praktika-ispoljhzovanija
Dies ist eine beispielhafte RMI-Anwendung, welche die Multiplikationsberechnungen durchfuehren kann.
Die Argumente werden von dem Client an den Server uebergeben,und der Server fuehrt die Multiplikation durch und gibt
anschließend das Ergebnis aus.*/

public class RemoteCalculationServer implements Calculator {

    @Override
    public int multiply(int x, int y) throws RemoteException {
        return x*y;
    }

}
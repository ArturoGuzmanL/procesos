import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    public static void main(String[] args) throws RemoteException {
        RMI sr = new RMIClass();
        Registry registry = LocateRegistry.createRegistry(7777);
        registry.rebind("RemotoRMI", sr);
        System.out.println("Servidor Iniciado");

    }
}

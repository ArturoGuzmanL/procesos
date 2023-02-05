import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    public static void main(String[] args) throws RemoteException {
        DivisaRMI rmi = new DivisaClass();
        Registry rg = LocateRegistry.createRegistry(1234);
        rg.rebind("RemoteDivisas", rmi);
        System.out.println("Servidor Conectado");
    }
}

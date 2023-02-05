import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Cliente cl = new Cliente();
        cl.connect();
    }

    public void connect() throws RemoteException, NotBoundException {
        Registry reg = LocateRegistry.getRegistry("localhost", 1234);
        DivisaRMI dvrm = (DivisaRMI) reg.lookup("RemoteDivisas");
        float dolares = 27.5F;
        float euros = 25.21F;
        float libras = 15.33F;

        System.out.println(dolares + " $ --> " + dvrm.dolaresEuros(dolares) + " €");
        System.out.println(euros + " € --> " + dvrm.eurosDolares(euros) + " $");
        System.out.println(libras + " £ --> " + dvrm.librasEuros(libras) + " €");
        System.out.println(euros + " € --> " + dvrm.eurosLibras(euros) + " £");

    }
}

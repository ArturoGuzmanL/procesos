import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class DivisaClass extends UnicastRemoteObject implements DivisaRMI {
    protected DivisaClass() throws RemoteException {
        super();
    }

    @Override
    public float librasEuros(float x) throws RemoteException {
        return x * 1.1158F;
    }

    @Override
    public float eurosLibras(float x) throws RemoteException {
        return x * 0.89619F;
    }

    @Override
    public float dolaresEuros(float x) throws RemoteException {
        return x * 0.92631F;
    }

    @Override
    public float eurosDolares(float x) throws RemoteException {
        return x * 1.07925F;
    }
}

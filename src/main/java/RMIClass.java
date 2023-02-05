import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIClass extends UnicastRemoteObject implements RMI {
    protected RMIClass() throws RemoteException {
        super();
    }

    @Override
    public Double suma(Double n1, Double n2) throws RemoteException {
        return (n1 + n2);
    }

    @Override
    public Double resta(Double n1, Double n2) throws RemoteException {
        return (n1 - n2);
    }

    @Override
    public Double multiplica(Double n1, Double n2) throws RemoteException {
        return (n1 * n2);
    }

    @Override
    public Double divide(Double n1, Double n2) throws RemoteException {
        return n1 / n2;
    }

    @Override
    public Double procentaje(Double x, Double y) throws RemoteException {
        return ((x / 100) * y);
    }

    @Override
    public int resto(int x, int y) throws RemoteException {
        return (x % y);
    }

    @Override
    public Double media(Double[] x) throws RemoteException {
        Double suma = 0.0;
        for (Double i : x) {
            suma += i;
        }
        return suma / x.length;
    }
}

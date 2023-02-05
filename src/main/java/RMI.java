
import java.lang.reflect.Array;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMI extends Remote {
    Double suma(Double n1, Double n2) throws RemoteException;

    Double resta(Double n1, Double n2) throws RemoteException;

    Double multiplica(Double n1, Double n2) throws RemoteException;

    Double divide(Double n1, Double n2) throws RemoteException;

    Double procentaje(Double x, Double y) throws RemoteException;

    int resto(int x, int y) throws RemoteException;

    Double media(Double[] x) throws RemoteException;

}

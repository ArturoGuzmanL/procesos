import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DivisaRMI extends Remote {
    float librasEuros(float x) throws RemoteException;

    float eurosLibras(float x) throws RemoteException;

    float dolaresEuros(float x) throws RemoteException;

    float eurosDolares(float x) throws RemoteException;
}

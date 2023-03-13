package Ejercicio2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CifradoCesar  extends Remote {
    public String cesar(int desplazamiento, String mensaje) throws RemoteException;
    public String reves(String mensaje) throws RemoteException;
    public String descifrar(int desplazamiento, String mensaje) throws RemoteException;
}

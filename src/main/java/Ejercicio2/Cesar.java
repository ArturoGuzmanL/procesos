package Ejercicio2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Cesar extends UnicastRemoteObject implements CifradoCesar {

    private static final String LIST = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ ";
    private static final int TAM_LIST = LIST.length();

    protected Cesar() throws RemoteException {
    }

    @Override
    public String cesar(int desplazamiento, String mensaje) throws RemoteException {
        StringBuilder sb = new StringBuilder();
        for (char c : mensaje.toCharArray()) {
            int pos = LIST.indexOf(c);
            if (pos == -1) {
                sb.append(c);
            } else {
                int nuevaPos = (pos + desplazamiento) % TAM_LIST;
                sb.append(LIST.charAt(nuevaPos));
            }
        }
        return sb.toString();
    }

    @Override
    public String reves(String mensaje) throws RemoteException {
        return new StringBuilder(mensaje).reverse().toString();
    }

    @Override
    public String descifrar(int desplazamiento, String mensaje) throws RemoteException {
        return cesar(TAM_LIST - desplazamiento, mensaje);
    }
}
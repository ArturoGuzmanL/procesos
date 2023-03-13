package Ejercicio2;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ServidorRMI {

    public static void main(String[] args) {
        try {
            CifradoCesar cifradoCesar = new Cesar();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("CifradoCesar", cifradoCesar);
            System.out.println("Servidor Iniciado Correctamente");
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
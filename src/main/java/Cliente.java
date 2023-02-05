
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.connectServer();
    }

    private void connectServer() {
        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 7777);
            RMI server = (RMI) registro.lookup("RemotoRMI");

            Double suma = server.suma(10.0, 8.2);
            Double resta = server.resta(10.5, 5.0);
            Double multip = server.multiplica(10.5, 5.4);
            Double divid = server.divide(10.7, 7.0);
            Double porcentaje = server.procentaje(20.2, 50.0);
            int resto = server.resto(10, 3);
            Double[] arr = {1.0, 3.1, 5.5, 7.8, 34.0, 78.23, 20.10};
            Double media = server.media(arr);

            System.out.println("La suma [10,8.2] es: " + suma);
            System.out.println("La resta [10.5, 5] es " + resta);
            System.out.println("La multiplicacion [10.5,5.4] es " + multip);
            System.out.println("La division [10.7,7] es " + divid);

            System.out.println("El porcentaje [20.2,50] es " + porcentaje);
            System.out.println("El resto [10.5,3.4] es: " + resto);

            System.out.println("La media [1.0,3.1,5.5,7.8,34.0,78.23,20.10] es: " + media);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

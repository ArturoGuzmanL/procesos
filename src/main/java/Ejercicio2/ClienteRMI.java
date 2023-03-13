package Ejercicio2;

import java.rmi.Naming;
import java.util.Scanner;

public class ClienteRMI {

    public static void main(String[] args) {
        try {
            CifradoCesar cifradoCesar = (CifradoCesar) Naming.lookup("rmi://localhost/CifradoCesar");
            Scanner scanner = new Scanner(System.in);

            System.out.print("Introduzca el mensaje: ");
            String mensaje = scanner.nextLine();

            System.out.print("Desplazamiento: ");
            int desplazamiento = scanner.nextInt();
            scanner.nextLine();

            String cifrado = cifradoCesar.cesar(desplazamiento, mensaje);
            System.out.println("Mensaje cifrado con Desplazamiento = " + desplazamiento + ": " + cifrado);
            String revertido = cifradoCesar.reves(cifradoCesar.descifrar(desplazamiento, cifrado));
            System.out.println("Mensaje revertido: " + revertido);
            String descifrado = cifradoCesar.descifrar(desplazamiento, cifrado);
            System.out.println("Mensaje descifrado: " + descifrado);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

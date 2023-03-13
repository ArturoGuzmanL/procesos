package Ejercicio1;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClienteTCP {

    public static void main(String[] args) throws IOException {
        String serverName = "0.0.0.0";
        int portNumber = 12345;
        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            //Crear socket y conectar con servidor
            echoSocket = new Socket(serverName, portNumber);

            //Inicializar los flujos de entrada/salida del socket conectado
            in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(echoSocket.getOutputStream()));

        } catch (UnknownHostException e) {
            System.err.println("Unknown: " + serverName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for " + "the connection to: " + serverName);
            System.exit(1);
        }

        System.out.println("STATUS: Conectado al servidor ");
        //Obtener texto por teclado
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput;
        System.out.println("Introduzca un texto a enviar (FIN para acabar)");
        userInput = stdIn.readLine();
        //Enviar texto leido, almacenado en userInput, al servidor 
        while (userInput.compareTo("FIN") != 0) {
            String echo = null; //texto enviado por el servidor
            //Enviar texto en userInput al servidor a travйs del flujo de salida del socket conectado
            out.println(userInput);
            out.flush();
            System.out.println("STATUS: Enviando " + userInput); //muestra por pantalla el texto enviado
            System.out.println("STATUS: Esperando eco"); //muestra por pantalla estado

            // Recibir texto en echo enviado por el servidor a travйs del flujo de entrada del socket conectado
            echo = in.readLine();//leer lнnea de socket conectado en variable echo
            System.out.println("echo: " + echo); //muestra por pantalla el eco recibido 

            // Leer texto de usuario por teclado
            System.out.println("Introduzca un texto a enviar (FIN para acabar)");
            userInput = stdIn.readLine();
        }
        //salimos porque el cliente quiere terminar la interacciуn, ha introducido FIN
        System.out.println("STATUS: El cliente quiere terminar la interaccion");
        //Enviar CLOSE al servidor a travйs del flujo de salida del socket conectado para indicar el fin de la interacciуn
        out.println(userInput);
        out.flush();
        System.out.println("STATUS: Sending " + userInput); //muestra por pantalla el texto enviado
        System.out.println("STATUS: Esperando eco"); //muestra por pantalla estado

        // Recibir OK enviado por el servidor confirmando el a travйs del flujo de entrada del socket conectado
        String ok = in.readLine(); //leer lнnea de socket conectado en variable ok y comparar con "OK"
        if (ok.equals("OK"))
            System.out.println("STATUS: Cerrando conexion " + ok); //muestra por pantalla el eco recibido

//Cerrar flujos y sockets	
        stdIn.close();
        in.close();
        out.close();
        echoSocket.close();
        System.out.println("STATUS: Conexion cerrada");
    }
}

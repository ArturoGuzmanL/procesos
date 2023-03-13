package Ejercicio1;

import java.io.*;
import java.net.*;
import java.util.Scanner;

class ServidorTCP {

    public static void main(String[] args) throws IOException {
        ServerSocket server = null;
        Socket client = null;
        //BufferedReader in = null;
        PrintWriter out = null;
        Scanner in = null;
        String line;
        int port = 12345; //puerto del servidor

        /*
         * Crear e inicializar el socket del servidor
         */

        try {
            //Aqui
            server = new ServerSocket(port);
        } catch (IOException e) {
            System.out.println("Could not listen on port " + port);
            System.exit(-1);
        }

        while (true) //funcion del servidor:
        {
            try {
                //Esperar conexiones entrantes
                client = server.accept();


                //Mostrar infomaciуn del socket conectado
            } catch (IOException e) {
                System.out.println("Accept failed: " + port);
                System.exit(-1);
            }

            try {

                //Una vez aceptada una conexion, inicializar flujos de entrada/salida del socket conectado

                in = new Scanner(client.getInputStream());
                out = new PrintWriter(client.getOutputStream());
            } catch (IOException e) {
                System.out.println("IO exception ");
                System.exit(-1);
            }

            boolean salir = false;

            while (!salir) {
                try {
                    //Leer datos del cliente en String line
                    line = in.nextLine();
                    System.out.println("Received from client " + line);

                    //Comprueba si es fin de conexiуn
                    if (line.compareTo("FIN") != 0) {
                        //Envia eco al cliente
                        out.println(line);
                        out.flush();
                        System.out.println("Sending to client " + line);
                    } //Send data back to client
                    else //El cliente quiere cerrar conexiуn, ha enviado FIN    
                    {
                        //Envia OK al cliente
                        out.println("OK");
                        out.flush();
                        salir = true;
                    }
                } catch (Exception e) {
                    System.out.println("Read failed");
                    System.exit(-1);
                }
            } //fin del servicio

            System.out.println("Closing connection with the client");
            //Cierra flujos y socket de la conexiуn con el cliente
            out.close();
            in.close();
            client.close();
            System.out.println("Waiting for a new client");
        } //fin del bucle
        //server.close(); 
    }
}//fin del metodo y la clase


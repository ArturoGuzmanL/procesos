package main.act4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        ArrayList<Hebra> lista = new ArrayList<>();
        ArrayList<Integer> resultados = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("Indiqueme la ultima posicion que desea mostrar");
        Integer max = 0;
        try {
            max = sc.nextInt();

        } catch (Exception e) {
            System.out.println("Error al captar el numero");
            System.exit(0);
        }


        for (int i = 0; i < max; i++) {
            try {
                Hebra h = new Hebra(i, resultados);
                h.start();
                h.join();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("===========================================================");
        System.out.println("La lista sucesion de fibonacci haste el termino: " + max + ". Es: ");
        System.out.println(resultados);
        System.out.println("============================================================");
    }
}

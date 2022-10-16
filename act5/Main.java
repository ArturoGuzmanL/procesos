package act5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Integer> listado = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Indique el maximo de numeros que desea generar");
        Integer max = sc.nextInt();

        for (Integer i = 0; i < max; i++) {
            // Generar valores aleatorios entre 0 y 99
            Integer val1 = (int) (Math.random() * (100));
            listado.add(val1);
        }
        Nodo nodo = new Nodo(listado);
        System.out.println(nodo);

        try {
            nodo.start();
            nodo.join();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(nodo);
    }
}

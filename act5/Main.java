package act5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> listado = new ArrayList<>();

        for (Integer i = 0; i < 10; i++) {
            // Generar valores aleatorios entre 0 y 99
            Integer val1 = (int) (Math.random() * (100));

            listado.add(val1);
        }

        Nodo nodo = new Nodo(listado);
        System.out.println(nodo);
        nodo.start();
        try {
            nodo.join();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(nodo);
    }
}

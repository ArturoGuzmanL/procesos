package act5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> listado = new ArrayList<>();
        List<Integer> listado_2 = new ArrayList<>();

        for (Integer i = 0; i < 10; i++) {
            // Generar valores aleatorios entre 0 y 99
//            Integer val = (int) (Math.random() * (100));
            Integer val = i;
            listado.add(val*10);
            listado_2.add(val);
        }
        Nodo nodo = new Nodo(listado);
        System.out.println(nodo);
        Nodo.añade(listado_2, 2, 5);
        System.out.println(nodo);
    }
}

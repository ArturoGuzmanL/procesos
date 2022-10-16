package act5;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class Nodo extends Thread {
    private static List<Integer> lista;

    public Nodo(List<Integer> lista) {
        Nodo.lista = lista;
    }


    // Añade a la lista [desde,hasta)
    static void añade(List<Integer> listado, Integer desde, Integer hasta) {
        listado.addAll(lista.subList(desde, hasta));
    }

    static void mezcla(List<Integer> listado_1, List<Integer> listado_2) {
        lista.clear();
        lista.addAll(listado_1);
        lista.addAll(listado_2);

        boolean sorted = false;
        Integer temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < lista.size()-1; i++) {
                if (lista.get(i) > lista.get(i + 1)) {
                    temp = lista.get(i);
                    lista.set(i, lista.get(i + 1));
                    lista.set(i + 1, temp);
                    sorted = false;
                }
            }
        }
    }

    public void run() {
        if (lista.size() <= 1)
            return;

        ArrayList<Integer> temp_1 = new ArrayList<>();
        ArrayList<Integer> temp_2 = new ArrayList<>();

        añade(temp_1, 0, lista.size() / 2);
        añade(temp_2, lista.size() / 2, lista.size());

        Nodo a = new Nodo(temp_1);
        Nodo b = new Nodo(temp_2);

        a.start();
        b.start();
        try {
            a.join();
            b.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        mezcla(temp_1, temp_2);
    }


    public static List<Integer> getLista() {
        return lista;
    }

    @Override
    public String toString() {
        AtomicReference<String> tense = new AtomicReference<>("");
        lista.forEach(k -> {
            tense.set(tense.get() + k + " ");
        });
        return tense.get();
    }

}

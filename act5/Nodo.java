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

        while (!listado_1.isEmpty() && !listado_2.isEmpty()) {
            AtomicReference<Integer> val1 = new AtomicReference<>(Integer.MAX_VALUE);
            if (!listado_1.isEmpty()) {
                listado_1.forEach(k -> {
                    if (k <= val1.get()) {
                        val1.set(k);
                    }
                });
            }

            AtomicReference<Integer> val2 = new AtomicReference<>(Integer.MAX_VALUE);

            if (!listado_2.isEmpty()) {
                listado_2.forEach(k -> {
                    if (k <= val2.get()) {
                        val2.set(k);
                    }
                });
            }

            if (val1.get() < val2.get()) {
                lista.add(val1.get());
                listado_1.remove(val1.get());

            }
            if (val1.get() > val2.get()) {
                lista.add(val2.get());
                listado_2.remove(val2.get());
            }

            if (Objects.equals(val1.get(), val2.get())) {
                lista.add(val1.get());
                lista.add(val2.get());
                listado_1.remove(val1.get());
                listado_2.remove(val2.get());
            }
        }

        if (listado_1.isEmpty() && !listado_2.isEmpty()) {
            AtomicReference<Integer> val = new AtomicReference<>(Integer.MAX_VALUE);
            while (!listado_2.isEmpty()) {
                listado_2.forEach(k -> {
                    if (k < val.get()) {
                        val.set(k);
                    }
                });
                lista.add(val.get());
                listado_2.remove(val.get());
                val.set(Integer.MAX_VALUE);

            }
        }

        if (!listado_1.isEmpty() && listado_2.isEmpty()) {
            AtomicReference<Integer> val = new AtomicReference<>(Integer.MAX_VALUE);

            while (!listado_1.isEmpty()) {
                listado_1.forEach(k -> {
                    if (k < val.get()) {
                        val.set(k);
                    }
                });
                lista.add(val.get());
                listado_1.remove(val.get());
                val.set(Integer.MAX_VALUE);
            }
        }
    }

    public void run() {
        if (lista.size() <= 1) return;

        ArrayList<Integer> temp_1 = new ArrayList<>();
        ArrayList<Integer> temp_2 = new ArrayList<>();

        añade(temp_1, 0, lista.size() / 2);
        añade(temp_2, lista.size() / 2, lista.size());

        Nodo a = new Nodo(temp_1);
        Nodo b = new Nodo(temp_2);

        try {
            a.start();
            a.join();
            b.start();
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

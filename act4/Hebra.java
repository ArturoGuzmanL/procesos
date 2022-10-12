package main.act4;

import java.util.ArrayList;

class Hebra extends Thread {
    private Integer posicion;
    public Integer result;

    ArrayList<Integer> resultados;

    public Hebra(Integer posicion, ArrayList<Integer> resultados) {
        this.posicion = posicion;
        this.resultados = resultados;
        if (posicion < 3) {
            if (posicion == 0) {
                result = 0;
            } else {
                result = 1;
            }
        }
    }

    public void run() {
        if (posicion < 3) {
            resultados.add(result);
        } else {
            Integer n_1 = resultados.get(posicion - 1);
            Integer n_2 = resultados.get(posicion - 2);
            result = n_1 + n_2;
            resultados.add(result);
        }
    }
}
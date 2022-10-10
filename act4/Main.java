package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> lista_fibonacci = new ArrayList<>();
        lista_fibonacci.add(1);
        lista_fibonacci.add(1);

        Hebra n_2 = new Hebra(null, 1, 1);
        Hebra n_1 = new Hebra(n_2.getValor_actual(), 1, 2);
        n_2 = n_1;
        Hebra n = new Hebra(n_1.getValor_actual(), n_2.getValor_previo(), 3);


        System.out.println("Indiqueme la posicion de Fibonnaci que desea calcular");
        Integer max = sc.nextInt();

        if (max == 1 || max == 2) {
            if (max == 1) {
                System.out.println(lista_fibonacci.get(0));
            } else {
                System.out.println(lista_fibonacci);
            }
        } else {

        }
    }


}


}
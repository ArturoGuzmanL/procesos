package act3;

import java.util.concurrent.atomic.AtomicInteger;

public class Act3 {
    public static void main(String[] args) {

        VariableCompartida vc = new VariableCompartida();
        AtomicInteger num = new AtomicInteger();
        num.set(0);

        Hebra1 t1 = new Hebra1(vc, num);
        Hebra2 t2 = new Hebra2(vc, num);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
            System.out.println("Proceso terminado");

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    static class Hebra1 extends Thread {
        public VariableCompartida vc;
        public AtomicInteger num;

        public Hebra1(VariableCompartida vc, AtomicInteger num) {
            this.vc = vc;
            this.num = num;

        }

        public void run() {

            boolean procesando = true;
            int cont = 0;

            while (procesando) {
                if (num.get() == 0) {
                    if (cont > 99) {
                        procesando = false;
                    } else {
                        vc.inc();
                        num.set(1);
                        cont = vc.getV();
                    }

                }

            }
        }

    }

    static class Hebra2 extends Thread {
        public VariableCompartida vc;
        public AtomicInteger num;

        public Hebra2(VariableCompartida vc, AtomicInteger num) {
            this.vc = vc;
            this.num = num;

        }

        public void run() {
            boolean procesando = true;

            while (procesando) {
                if (num.get() == 1) {
                    if (vc.getV() > 99) {
                        procesando = false;
                    } else {
                        System.out.println(vc.getV());
                        num.set(0);
                    }

                }

            }
        }
    }

    static class VariableCompartida {
        public int v = -1;

        public void setV(Integer value) {
            this.v = value;
        }

        public Integer getV() {
            return v;
        }

        public void inc() {
            v++;
        }
    }
}

package act3;

public class Act3 {
    public static void main(String[] args) {

        VariableCompartida vc = new VariableCompartida();
        Integer num = 0;

        Hebra1 t1 = new Hebra1(vc, num);
        Hebra2 t2 = new Hebra2(vc, num);

        execute(t1, t2);

    }

    static void execute(Hebra1 t1, Hebra2 t2) {
        for (int i = 0; i < 100; i++) {

        }
    }

    static class Hebra1 extends Thread {
        public VariableCompartida vc;
        public Integer num;

        public Hebra1(VariableCompartida vc, Integer num) {
            this.vc = vc;
            this.num = num;

        }

        public void run() {

            boolean procesando = true;
            Integer cont = 0;

            while (procesando) {
                if (num == 0) {
                    if (cont == 99) {
                        procesando = false;
                    } else {
                        vc.setV(cont);
                        cont++;
                        num = 1;
                    }

                }

            }
        }

    }

    static class Hebra2 extends Thread {
        public VariableCompartida vc;
        public Integer num;

        public Hebra2(VariableCompartida vc, Integer num) {
            this.vc = vc;
            this.num = num;

        }

        public void run() {
            boolean procesando = true;

            while (procesando) {
                if (num == 1) {
                    if (vc.getV() > 99) {
                        procesando = false;
                    } else {
                        System.out.println(vc.getV());
                        num = 0;
                    }

                }

            }
        }
    }

    static class VariableCompartida {
        public int v = 0;

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

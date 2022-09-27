public class Act3_rota {

    public static void main(String[] args) {

        VariableCompartida vc = new VariableCompartida();

        Hebra1 t1 = new Hebra1(vc);
        Hebra2 t2 = new Hebra2(vc);

        t1.start();
        t2.start();

    }

    static class Hebra1 extends Thread {
        public VariableCompartida vc;

        public Hebra1(VariableCompartida vc) {
            this.vc = vc;

        }

        public void run() {

            for (int i = 0; i < 100; i++) {
                vc.inc();
            }
        }

    }

    static class Hebra2 extends Thread {
        public VariableCompartida vc;

        public Hebra2(VariableCompartida vc) {
            this.vc = vc;

        }

        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println(vc.getV());
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

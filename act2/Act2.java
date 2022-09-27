package act2;

public class Act2 {
    public static void main(String[] args) {
        VariableCompartida vc = new VariableCompartida();
        Hebra t1 = new Hebra(vc);
        Hebra t2 = new Hebra(vc);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();

            System.out.println(vc.getV());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static class Hebra extends Thread {
        public VariableCompartida vc;

        public Hebra(VariableCompartida vc) {
            this.vc = vc;
        }

        public void run() {
            for (int i = 0; i < 10; i++) {

                vc.inc();
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

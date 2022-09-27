package act1;

public class Act1 {

    public static void main(String[] args) {
        Hebra h1 = new Hebra(1, 'a');
        Hebra h2 = new Hebra(2, 'b');
        Hebra h3 = new Hebra(3, 'c');

        // Iniciamos cada una de las hebras. Aunque se llamen en orden,
        // la maquina virtual de Java elige cual se ejecuta cuando
        //
        h1.start();
        h2.start();
        h3.start();

    }

    /**
     * Clase que permite la creacion de una hebra
     */
    static class Hebra extends Thread {
        public Integer numero = null;
        public char caracter = ' ';

        public Hebra(int num, char caracter) {
            this.numero = num;
            this.caracter = caracter;
        }

        public void run() {
            System.out.printf("Numero es %d; Caracter es: %c\n", numero, caracter);
        }
    }
}

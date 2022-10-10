package main;

public class Hebra extends Thread {
    private Integer valor_1;
    private Integer valor_2;
    private Integer posicion;

    private Integer valor;

    public void run(Integer max) {
        Integer cont = 3;
        while(cont<max){
            Hebra n =new Hebra(valor_1, valor_2, cont);
            cont++;
        }
    }

    Hebra(Hebra n_1, Hebra n_2, Integer posicion) {
        this.valor_1 = n_1.getValor();
        this.valor_2 = n_2.getValor_2();
        this.posicion = posicion;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Integer getValor_1() {
        return valor_1;
    }

    public void setValor_1(Integer valor_1) {
        this.valor_1 = valor_1;
    }

    public Integer getValor_2() {
        return valor_2;
    }

    public void setValor_2(Integer valor_2) {
        this.valor_2 = valor_2;
    }

    public Integer getPosicion() {
        return posicion;
    }

    public void setPosicion(Integer posicion) {
        this.posicion = posicion;
    }
}

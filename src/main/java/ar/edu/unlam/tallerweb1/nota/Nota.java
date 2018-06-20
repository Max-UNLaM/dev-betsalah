package ar.edu.unlam.tallerweb1.nota;

public class Nota {
    private Integer valor;

    public Nota(Integer valor) {
        this.valor = valor;
    }

    public boolean aprobo() {
        return this.valor > 3;
    }

    public boolean promociono() {
        return this.valor > 6;
    }
}

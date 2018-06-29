package ar.edu.unlam.tallerweb1.tabladeposiciones;

import java.util.ArrayList;
import java.util.List;

public class TablaDePosiciones {
    private List<TablaDePosicionesFila> filas;

    public TablaDePosiciones() {
        this.filas = new ArrayList<>();
    }

    public void agregarFila(TablaDePosicionesFila fila){
        filas.add(fila);
    }

    public TablaDePosicionesFila obtenerPrimero(){
        return filas.get(0);
    }

    public TablaDePosicionesFila obtenerSegundo(){
        return filas.get(1);
    }
}

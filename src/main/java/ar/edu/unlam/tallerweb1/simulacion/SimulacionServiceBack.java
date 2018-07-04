package ar.edu.unlam.tallerweb1.simulacion;

import ar.edu.unlam.tallerweb1.partido.Partido;

public interface SimulacionServiceBack {
    public void jugarPartido(Partido partido, Integer golesLocal, Integer golesVisitante, Long figuraId);
}

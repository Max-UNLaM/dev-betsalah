package ar.edu.unlam.tallerweb1.partido;

import ar.edu.unlam.tallerweb1.dao.Crud;

import java.util.List;

public interface PartidoCrud extends Crud<Partido, Long> {
    public List<Partido> consultarPartidosPorFase(String fase);
    public Partido read(String fase, String local, String visitante);
}

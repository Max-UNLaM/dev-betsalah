package ar.edu.unlam.tallerweb1.partido;

import java.util.List;

public interface PartidoCrud {
    public List<Partido> consultarPartidosPorFase(String fase);
}

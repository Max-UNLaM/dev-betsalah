package ar.edu.unlam.tallerweb1.simulacion;

import ar.edu.unlam.tallerweb1.gol.GolDao;
import ar.edu.unlam.tallerweb1.partido.Partido;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class ResultadoService {

    @Inject
    GolDao golDao;

    public String resultado(Partido partido) {
        int golesLocal = golDao.list(partido, partido.getEquipo("local")).size();
        int golesVisitante = golDao.list(partido, partido.getEquipo("visitante")).size();
        return this.resultado(golesLocal, golesVisitante);
    }

    public String resultado(int golesLocal, int golesVisitante) {
        if (golesLocal == golesVisitante) {
            return "empate";
        } else if (golesLocal > golesVisitante) {
            return "local";
        } else {
            return "visitante";
        }
    }
}

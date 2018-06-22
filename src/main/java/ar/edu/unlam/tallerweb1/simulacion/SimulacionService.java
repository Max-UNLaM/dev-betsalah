package ar.edu.unlam.tallerweb1.simulacion;

import ar.edu.unlam.tallerweb1.equipo.Equipo;
import ar.edu.unlam.tallerweb1.equipo.EquipoDao;
import ar.edu.unlam.tallerweb1.gol.Gol;
import ar.edu.unlam.tallerweb1.gol.GolDao;
import ar.edu.unlam.tallerweb1.partido.Partido;
import ar.edu.unlam.tallerweb1.partido.PartidoDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@Service("simulacionService")
@Transactional
public class SimulacionService {

    @Inject
    protected PartidoDao partidoDao;

    @Inject
    protected EquipoDao equipoDao;

    @Inject
    protected GolDao golDao;

    @Inject
    protected PuntajeService puntajeService;

    protected Partido partido;

    public void jugarPartido(Partido partido, Integer golesLocal, Integer golesVisitante) {
        Equipo local = equipoDao.read(partido.idLocal());
        Equipo visitante = equipoDao.read(partido.idVisitante());
        for (int i = 0; i < golesLocal; i++) {
            golDao.create(new Gol(partido, local));
        }
        for (int i = 0; i < golesVisitante; i++) {
            golDao.create(new Gol(partido, visitante));
        }
        puntajeService.actualizarPuntajes(partido);
    }
}

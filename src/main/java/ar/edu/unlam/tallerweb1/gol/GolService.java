package ar.edu.unlam.tallerweb1.gol;

import ar.edu.unlam.tallerweb1.equipo.Equipo;
import ar.edu.unlam.tallerweb1.partido.Partido;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class GolService {

    @Inject
    private GolDao golDao;

    @SuppressWarnings("unchecked")
    public List<Gol> obtenerGolesPartidoYEquipo(Partido partido, Equipo equipo) {
        return this.golDao.list(partido, equipo);
    }

    public Integer getCantidadDeGolesDeEquipoEnPartido(Equipo equipo, Partido partido){
        List<Gol> goles = golDao.obtenerGolesPorPartidoYEquipo(equipo, partido);

        return goles.size();
    }
}

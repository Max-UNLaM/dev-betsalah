package ar.edu.unlam.tallerweb1.gol;

import ar.edu.unlam.tallerweb1.equipo.Equipo;
import ar.edu.unlam.tallerweb1.partido.Partido;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class GolService {

    @Inject GolCrud golCrud;

    @SuppressWarnings("unchecked")
    public List<Gol> obtenerGolesPartidoYEquipo(Partido partido, Equipo equipo) {
        return this.golCrud.list(partido, equipo);
    }
}

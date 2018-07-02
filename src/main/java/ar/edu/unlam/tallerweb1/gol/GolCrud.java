package ar.edu.unlam.tallerweb1.gol;

import ar.edu.unlam.tallerweb1.dao.Crud;
import ar.edu.unlam.tallerweb1.equipo.Equipo;
import ar.edu.unlam.tallerweb1.partido.Partido;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GolCrud extends Crud<Gol, Long> {
    public List<Gol> list(Partido partido, Equipo equipo);
}

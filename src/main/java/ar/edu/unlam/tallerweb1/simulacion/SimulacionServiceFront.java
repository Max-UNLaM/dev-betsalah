package ar.edu.unlam.tallerweb1.simulacion;

import ar.edu.unlam.tallerweb1.fase.Fase;
import ar.edu.unlam.tallerweb1.partido.PartidoJuegoDto;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Component
public interface SimulacionServiceFront {
    ModelAndView modelarFases(List<Fase> fases, Long usuarioId);
    SimulacionResultadoDto imprimirSimulacionResultadoDto(PartidoJuegoDto partidoDto);
}

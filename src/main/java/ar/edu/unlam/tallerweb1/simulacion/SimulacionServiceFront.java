package ar.edu.unlam.tallerweb1.simulacion;

import ar.edu.unlam.tallerweb1.fase.Fase;
import ar.edu.unlam.tallerweb1.partido.PartidoJuegoDto;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component
public interface SimulacionServiceFront {
    ModelAndView modelarFase(Fase fase);
    SimulacionResultadoDto imprimirSimulacionResultadoDto(PartidoJuegoDto partidoDto);
}

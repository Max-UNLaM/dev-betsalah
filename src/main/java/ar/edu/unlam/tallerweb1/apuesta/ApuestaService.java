package ar.edu.unlam.tallerweb1.apuesta;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

@Controller
public interface ApuestaService {
    ModelMap obtenerModeloPrimeraFase();
    Integer modificarGolesApostados(Long apuestaId, String equipo, String accion);
}

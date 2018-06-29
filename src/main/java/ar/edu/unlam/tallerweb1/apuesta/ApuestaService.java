package ar.edu.unlam.tallerweb1.apuesta;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

@Controller
public interface ApuestaService {
    ModelMap obtenerModeloPorFase(String nombreFase);
    Integer modificarGolesApostados(Long apuestaId, String equipo, String accion);
}

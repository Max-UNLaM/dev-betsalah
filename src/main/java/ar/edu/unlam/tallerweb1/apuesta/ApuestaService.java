package ar.edu.unlam.tallerweb1.apuesta;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

@Controller
public interface ApuestaService {
    ModelMap obtenerModeloPorFase(String nombreFase, Long usuarioId);
    Integer modificarGolesApostados(Long apuestaId, String equipo, String accion);
    void modificarFiguraApostada(Long apuestaId, Long figuraId);
}

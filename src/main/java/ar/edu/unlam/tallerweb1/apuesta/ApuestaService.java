package ar.edu.unlam.tallerweb1.apuesta;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

@Controller
public interface ApuestaService {
    public ModelMap obtenerModeloPrimeraFase();
}

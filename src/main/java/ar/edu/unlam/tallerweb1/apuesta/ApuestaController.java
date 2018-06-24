package ar.edu.unlam.tallerweb1.apuesta;

import ar.edu.unlam.tallerweb1.usuario.Usuario;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ApuestaController {
    @Inject
    private ApuestaService apuestaService;

    @RequestMapping("/apuesta/primera-fase")
    @ResponseBody
    public ModelAndView cargarApuestasPrimeraFase(){

        ModelMap modelo = apuestaService.obtenerModeloPrimeraFase();

        return new ModelAndView("apuestas-primera-fase", modelo);
    }

    @RequestMapping(value = "/apuesta/cambiar-goles-apostados", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public Integer cambiarGolesApostados(@RequestParam Long apuestaId,
                                      @RequestParam String equipo,
                                      @RequestParam String accion){

        return apuestaService.modificarGolesApostados(apuestaId, equipo, accion);
    }
}

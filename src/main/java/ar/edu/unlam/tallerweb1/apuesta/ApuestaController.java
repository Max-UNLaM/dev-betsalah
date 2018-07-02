package ar.edu.unlam.tallerweb1.apuesta;

import ar.edu.unlam.tallerweb1.util.SalahProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;

@Controller
public class ApuestaController {
    @Inject
    private ApuestaService apuestaService;

    @RequestMapping("/apuesta/{fase}")
    @ResponseBody
    public ModelAndView cargarApuestasPorFase(@PathVariable String fase){
        ModelMap modelo = apuestaService.obtenerModeloPorFase(fase);
        return new ModelAndView("apuestas", modelo);
    }

    @RequestMapping(value = "/apuesta/cambiar-goles-apostados", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public Integer cambiarGolesApostados(@RequestParam Long apuestaId,
                                      @RequestParam String equipo,
                                      @RequestParam String accion){

        return apuestaService.modificarGolesApostados(apuestaId, equipo, accion);
    }

    @RequestMapping(value = "/apuesta/cambiar-figura", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public void cambiarGolesApostados(@RequestParam Long apuestaId,
                                      @RequestParam Long figuraId){

         apuestaService.modificarFiguraApostada(apuestaId, figuraId);
    }
}

package ar.edu.unlam.tallerweb1.apuesta;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ApuestaController {
    @Inject
    private ApuestaService apuestaService;

    @RequestMapping("/apuesta/{fase}")
    @ResponseBody
    public ModelAndView cargarApuestasPorFase(@PathVariable String fase, HttpServletRequest request){
        Long usuarioId = (Long) request.getSession().getAttribute("USER-ID");

        if(usuarioId == null){
            return new ModelAndView("redirect:/cerrar-sesion");
        } else {
            ModelMap modelo = apuestaService.obtenerModeloPorFase(fase, usuarioId);
            return new ModelAndView("apuestas", modelo);
        }
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
    public void cambiarFiguraApostada(@RequestParam Long apuestaId,
                                      @RequestParam Long figuraId){

         apuestaService.modificarFiguraApostada(apuestaId, figuraId);
    }
}

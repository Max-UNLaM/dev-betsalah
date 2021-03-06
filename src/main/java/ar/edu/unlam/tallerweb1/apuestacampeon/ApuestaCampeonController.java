package ar.edu.unlam.tallerweb1.apuestacampeon;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ApuestaCampeonController {
    @Inject
    private ApuestaCampeonService apuestaCampeonService;

    @RequestMapping(value = "/apuesta-campeon/apostar-campeon", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView apostarCampeon(HttpServletRequest request){
        Long usuarioId = (Long) request.getSession().getAttribute("USER-ID");

        if(usuarioId == null){
            return new ModelAndView("redirect:/cerrar-sesion");
        } else {
            ModelMap modelo = apuestaCampeonService.obtenerModelo(usuarioId);

            return new ModelAndView("apostar-campeon", modelo);
        }
    }

    @RequestMapping(value = "/apuesta-campeon/setear-campeon", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public void setearCampeon(@RequestParam Long apostadorId,
                              @RequestParam("equipoId") Long equipoId){

        apuestaCampeonService.apostarCampeon(apostadorId, equipoId);
    }
}

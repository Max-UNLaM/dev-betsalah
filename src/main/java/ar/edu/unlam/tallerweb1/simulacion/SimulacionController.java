package ar.edu.unlam.tallerweb1.simulacion;

import ar.edu.unlam.tallerweb1.fase.Fase;
import ar.edu.unlam.tallerweb1.fase.FaseService;
import ar.edu.unlam.tallerweb1.partido.Partido;
import ar.edu.unlam.tallerweb1.partido.PartidoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.inject.Inject;
import java.util.List;

@Controller
public class SimulacionController {

    @Inject
    FaseService faseService;

    @Inject
    PartidoService partidoService;

    @RequestMapping(path = "/simulacion/{fase}")
    public ModelAndView pantallaSimulacion(@PathVariable(value = "fase") String nombreFase) {
        Fase fase = nombreFase.equals("grupos") ? faseService.readFase("Fase de grupos") : faseService.readFase("Fase de grupos");
        List<Partido> partidosDeFase = partidoService.partidosDeFase(fase);
        ModelMap modelo = new ModelMap();
        modelo.put("partidos", partidosDeFase);
        return new ModelAndView("simulacion", modelo);
    }

}

package ar.edu.unlam.tallerweb1.simulacion;

import ar.edu.unlam.tallerweb1.fase.Fase;
import ar.edu.unlam.tallerweb1.fase.FaseService;
import ar.edu.unlam.tallerweb1.partido.*;
import ar.edu.unlam.tallerweb1.usuario.Usuario;
import ar.edu.unlam.tallerweb1.usuario.UsuarioDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SimulacionController {

    @Inject
    FaseService faseService;
    @Inject
    SimulacionServiceFront simulacionServiceFront;
    @Inject
    SimulacionServiceBack simulacionServiceBack;
    @Inject
    PartidoDao partidoDao;


    @RequestMapping(path = "/partido/{fase}")
    public ModelAndView pantallaSimulacion(@PathVariable(value = "fase") String nombreFase) {
        Fase fase = (nombreFase.equals("grupos")) ? faseService.readFase("Fase de grupos") : faseService.readFase("Fase de grupos");
        return simulacionServiceFront.modelarFase(fase);
    }

    @ResponseBody
    @RequestMapping(path = "/simulacion/jugar", method = RequestMethod.PUT, produces = "application/json")
    public SimulacionResultadoDto simulacionPartido(@RequestBody PartidoJuegoDto partidoDto){
        this.simulacionServiceBack.jugarPartido(partidoDao.read(partidoDto.id), partidoDto.golesLocal, partidoDto.golesVisitante);
        return this.simulacionServiceFront.imprimirSimulacionResultadoDto(partidoDto);
    }

}

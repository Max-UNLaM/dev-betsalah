package ar.edu.unlam.tallerweb1.simulacion;

import ar.edu.unlam.tallerweb1.fase.Fase;
import ar.edu.unlam.tallerweb1.fase.FaseService;
import ar.edu.unlam.tallerweb1.partido.*;
import ar.edu.unlam.tallerweb1.util.SalahProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;

@Controller
public class SimulacionController {

    @Inject
    private FaseService faseService;
    @Inject
    private SimulacionServiceFront simulacionServiceFront;
    @Inject
    private SimulacionServiceBack simulacionServiceBack;
    @Inject
    private PartidoDao partidoDao;


    @RequestMapping(path = "/partido/{fase}")
    public ModelAndView pantallaSimulacion(@PathVariable(value = "fase") String nombreFase) {
        Fase fase = (nombreFase.equals("grupos")) ? faseService.readFase(SalahProperties.FASE_DE_GRUPOS) : faseService.readFase(SalahProperties.FASE_DE_GRUPOS);
        return simulacionServiceFront.modelarFase(fase);
    }

    @ResponseBody
    @RequestMapping(path = "/simulacion/jugar", method = RequestMethod.PUT, produces = "application/json")
    public SimulacionResultadoDto simulacionPartido(@RequestBody PartidoJuegoDto partidoDto){
        this.simulacionServiceBack.jugarPartido(partidoDao.read(partidoDto.id), partidoDto.golesLocal, partidoDto.golesVisitante);
        return this.simulacionServiceFront.imprimirSimulacionResultadoDto(partidoDto);
    }

}

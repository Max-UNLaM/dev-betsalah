package ar.edu.unlam.tallerweb1.simulacion;

import ar.edu.unlam.tallerweb1.fase.Fase;
import ar.edu.unlam.tallerweb1.fase.FaseService;
import ar.edu.unlam.tallerweb1.partido.*;
import ar.edu.unlam.tallerweb1.util.SalahProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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
    public ModelAndView pantallaSimulacion(@PathVariable(value = "fase") String nombreFase, HttpServletRequest request) {
        String rol = (String) request.getSession().getAttribute("ROL");
        Long usuarioId = (Long) request.getSession().getAttribute("USER-ID");

        if(usuarioId == null || rol == null || !rol.equals(SalahProperties.ROL_ADMIN)){
            return new ModelAndView("redirect:/cerrar-sesion");
        } else {
            List<Fase> fases;

            String faseValida = validarFase(nombreFase);

            fases = faseService.readFases(faseValida);

            return simulacionServiceFront.modelarFases(fases, usuarioId);
        }
    }

    @ResponseBody
    @RequestMapping(path = "/simulacion/jugar", method = RequestMethod.PUT, produces = "application/json")
    public SimulacionResultadoDto simulacionPartido(@RequestBody PartidoJuegoDto partidoDto){
        this.simulacionServiceBack.jugarPartido(partidoDao.read(partidoDto.id), partidoDto.golesLocal, partidoDto.golesVisitante, partidoDto.getFiguraId());
        return this.simulacionServiceFront.imprimirSimulacionResultadoDto(partidoDto);
    }

    private String validarFase(String fase){
        String respuesta = SalahProperties.FASE_DE_GRUPOS;

        if(fase.equals("grupos")) respuesta = SalahProperties.FASE_DE_GRUPOS;
        if(fase.equals("octavos")) respuesta = SalahProperties.FASE_OCTAVOS_DE_FINAL;
        if(fase.equals("cuartos")) respuesta = SalahProperties.FASE_CUARTOS_DE_FINAL;
        if(fase.equals("semifinal")) respuesta = SalahProperties.FASE_SEMIFINAL;
        if(fase.equals("tercer-puesto")) respuesta = SalahProperties.FASE_TERCER_PUESTO;
        if(fase.equals("final")) respuesta = SalahProperties.FASE_FINAL;

        return respuesta;
    }
}

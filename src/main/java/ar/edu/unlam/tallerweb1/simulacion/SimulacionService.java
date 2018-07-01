package ar.edu.unlam.tallerweb1.simulacion;

import ar.edu.unlam.tallerweb1.equipo.Equipo;
import ar.edu.unlam.tallerweb1.equipo.EquipoDao;
import ar.edu.unlam.tallerweb1.fase.Fase;
import ar.edu.unlam.tallerweb1.fase.FaseDao;
import ar.edu.unlam.tallerweb1.fase.FaseService;
import ar.edu.unlam.tallerweb1.gol.Gol;
import ar.edu.unlam.tallerweb1.gol.GolDao;
import ar.edu.unlam.tallerweb1.partido.*;
import ar.edu.unlam.tallerweb1.tabladeposiciones.TablaDePosiciones;
import ar.edu.unlam.tallerweb1.usuario.Usuario;
import ar.edu.unlam.tallerweb1.usuario.UsuarioDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service("simulacionService")
@Transactional
public class SimulacionService implements SimulacionServiceFront, SimulacionServiceBack {

    @Inject
    protected PartidoDao partidoDao;
    @Inject
    protected PartidoService partidoService;
    @Inject
    protected EquipoDao equipoDao;
    @Inject
    protected GolDao golDao;
    @Inject
    protected PuntajeService puntajeService;
    @Inject
    protected UsuarioDao usuarioDao;
    @Inject
    protected FaseService faseService;
    @Inject
    protected ResultadoService resultadoService;

    protected Partido partido;

    public ModelAndView modelarFases(List<Fase> fases) {
        Usuario usuario = usuarioDao.read("daniel.marconi");
        if(usuario == null){
            usuario = new Usuario("daniel.marconi@gmail.com", "daniel.marconi", "123456", 0);
            usuarioDao.create(usuario);
        }
        List<Partido> partidosDeFase = partidoService.filterByFase(fases);
        ArrayList<PartidoDto> partidosDto = new ArrayList<>();
        for (Partido partido : partidosDeFase) {
            partidosDto.add(partidoService.getPartidoDto(partido));
        }
        ModelMap modelo = new ModelMap();
        modelo.addAttribute("partidos", partidosDto);
        modelo.addAttribute("usuario", usuario);
        return new ModelAndView("simulacion/juego", modelo);
    }

    public void jugarPartido(Partido partido, Integer golesLocal, Integer golesVisitante) {
        if (partido.getJugado()) {
            return;
        }
        Equipo local = equipoDao.read(partido.idLocal());
        Equipo visitante = equipoDao.read(partido.idVisitante());

        partido.setGolesLocal(golesLocal);
        for (int i = 0; i < golesLocal; i++) {
            golDao.create(new Gol(partido, local));
        }

        partido.setGolesVisitante(golesVisitante);
        for (int i = 0; i < golesVisitante; i++) {
            golDao.create(new Gol(partido, visitante));
        }

        puntajeService.actualizarPuntajes(partido);
        partido.setJugado(true);
        if(faseService.verificarSiLaFaseEstaCompleta(partido.getFase())){
            partido.getFase().setFinalizada(true);

            List<Equipo> equipos = equipoDao.obtenerEquiposPorFase(partido.getFase());
            List<Partido> partidos = partidoDao.consultarPartidosPorFase(partido.getFase());

            partidoService.calcularPartidosSiguienteFase(equipos, partidos, partido.getFase());
        }
        partidoDao.update(partido);
    }

    public SimulacionResultadoDto imprimirSimulacionResultadoDto(PartidoJuegoDto partidoJuegoDto) {
        Partido partidoJugado = partidoDao.read(partidoJuegoDto.id);
        String resultado = resultadoService.ganador(partidoJugado);
        String textoResultado = resultadoService.textoGanador(partidoJugado);
        return new SimulacionResultadoDto(partidoJugado.getLocal().getNombre(), partidoJugado.getVisitante().getNombre(), resultado, textoResultado);
    }
}

package ar.edu.unlam.tallerweb1.simulacion;

import ar.edu.unlam.tallerweb1.apuesta.Apuesta;
import ar.edu.unlam.tallerweb1.apuesta.ApuestaDao;
import ar.edu.unlam.tallerweb1.apuestacampeon.ApuestaCampeon;
import ar.edu.unlam.tallerweb1.apuestacampeon.ApuestaCampeonDao;
import ar.edu.unlam.tallerweb1.fase.Fase;
import ar.edu.unlam.tallerweb1.partido.Partido;
import ar.edu.unlam.tallerweb1.usuario.Usuario;
import ar.edu.unlam.tallerweb1.usuario.UsuarioDao;
import ar.edu.unlam.tallerweb1.util.Fases;
import ar.edu.unlam.tallerweb1.util.Resultados;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class PuntajeService {

    @Inject
    protected ApuestaDao apuestaDao;

    @Inject
    protected ApuestaCampeonDao apuestaCampeonDao;

    @Inject
    protected UsuarioDao usuarioDao;

    @Inject
    protected ResultadoService resultadoService;

    public void actualizarPuntajes(Partido partido) {
        final Fase fase = partido.getFase();
        String resultadoPartido = resultadoService.resultado(partido);
        List<Usuario> usuarios = usuarioDao.list();
        for (Usuario usuario : usuarios) {
            if (apuestaDao.existenApuestasDeUsuarioEnFase(usuario, fase.getNombre())) {
                sumarPuntos(usuario, partido, resultadoPartido);
            }
            if(partido.getFase().getNombre().equals(Fases.FASE_FINAL.toString())){
                sumarPuntosPorApuestaCampeon(usuario, partido);
            }
        }
    }

    protected void sumarPuntos(Usuario usuario, Partido partido, String resultadoPartido) {
        Apuesta apuesta = apuestaDao.read(usuario, partido);
        String resultadoApuesta = resultadoService.resultado(apuesta.getGolesLocal(), apuesta.getGolesVisitante());
        Integer puntajeGanado = 0;
        if (resultadoApuesta.equals(resultadoPartido)) {
            puntajeGanado = puntajeGanado + 1;
        }
        if (apuesta.getFigura() != null && apuesta.getFigura().getId().equals(partido.getFigura().getId())) {
        	puntajeGanado = puntajeGanado + 1; 
        }
        if (apuesta.getGolesLocal().equals(partido.getGolesLocal()) && apuesta.getGolesVisitante().equals(partido.getGolesVisitante())) {
        	puntajeGanado = puntajeGanado +2;
        }


        if (puntajeGanado > 0) {
            apuesta.setPuntaje(puntajeGanado);
            apuestaDao.update(apuesta);
        	usuario.setPuntaje(usuario.getPuntaje() + puntajeGanado);
            usuarioDao.update(usuario);
        }
    }

    public void sumarPuntosPorApuestaCampeon(Usuario usuario, Partido partido){
        ApuestaCampeon apuestaCampeon = apuestaCampeonDao.obtenerApuestaCampeon(usuario.getId());
        Integer puntajeGanado = 0;

        if(apuestaCampeon != null) {
            Long idEquipoCampeon;
            if (partido.getResultado().equals(Resultados.RESULTADO_GANA_LOCAL.toString())) {
                idEquipoCampeon = partido.getLocal().getId();
            } else {
                idEquipoCampeon = partido.getVisitante().getId();
            }

            if (apuestaCampeon.getEquipoApostado().getId().equals(idEquipoCampeon)) {
                puntajeGanado +=15;
            }
        }

        if (puntajeGanado > 0) {
            usuario.setPuntaje(usuario.getPuntaje() + puntajeGanado);
            usuarioDao.update(usuario);
        }
    }

}

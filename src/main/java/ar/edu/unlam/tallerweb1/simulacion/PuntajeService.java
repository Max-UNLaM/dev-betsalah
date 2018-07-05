package ar.edu.unlam.tallerweb1.simulacion;

import ar.edu.unlam.tallerweb1.apuesta.Apuesta;
import ar.edu.unlam.tallerweb1.apuesta.ApuestaDao;
import ar.edu.unlam.tallerweb1.fase.Fase;
import ar.edu.unlam.tallerweb1.partido.Partido;
import ar.edu.unlam.tallerweb1.usuario.Usuario;
import ar.edu.unlam.tallerweb1.usuario.UsuarioDao;
import ar.edu.unlam.tallerweb1.util.SalahProperties;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class PuntajeService {

    @Inject
    protected ApuestaDao apuestaDao;

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
        }
    }

    protected void sumarPuntos(Usuario usuario, Partido partido, String resultadoPartido) {
        Apuesta apuesta = apuestaDao.read(usuario, partido);
        String resultadoApuesta = resultadoService.resultado(apuesta.getGolesLocal(), apuesta.getGolesVisitante());
        Integer puntajeGanado = 0;
        if (resultadoApuesta.equals(resultadoPartido)) {
            puntajeGanado = puntajeGanado + 1;
        	if(partido.getFase().getNombre().equals(SalahProperties.FASE_FINAL)) puntajeGanado = puntajeGanado + 5; //puntaje asignado si acierta al campeon
        }
        if (apuesta.getFiguraId() != null && apuesta.getFiguraId().equals(partido.getFiguraId())) {
        	puntajeGanado = puntajeGanado + 1; 
        }
        if (apuesta.getGolesLocal().equals(partido.getGolesLocal()) && apuesta.getGolesVisitante().equals(partido.getGolesVisitante())) {
        	puntajeGanado = puntajeGanado +2;
        }
        if (puntajeGanado > 0) {
        	usuario.setPuntaje(usuario.getPuntaje() + puntajeGanado);
            usuarioDao.update(usuario);
        }
    }

}

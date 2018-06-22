package ar.edu.unlam.tallerweb1.simulacion;

import ar.edu.unlam.tallerweb1.apuesta.Apuesta;
import ar.edu.unlam.tallerweb1.apuesta.ApuestaDao;
import ar.edu.unlam.tallerweb1.fase.Fase;
import ar.edu.unlam.tallerweb1.partido.Partido;
import ar.edu.unlam.tallerweb1.usuario.Usuario;
import ar.edu.unlam.tallerweb1.usuario.UsuarioDao;
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
            if (apuestaDao.existenApuestasDeUsuarioEnFase(usuario, fase)) {
                sumarPuntos(usuario, partido, resultadoPartido);
            }
        }
    }

    protected void sumarPuntos(Usuario usuario, Partido partido, String resultadoPartido) {
        Apuesta apuesta = apuestaDao.read(usuario, partido);
        String resultadoApuesta = resultadoService.resultado(apuesta.getGolesLocal(), apuesta.getGolesVisitante());
        if (resultadoApuesta.equals(resultadoPartido)) {
            usuario.setPuntaje(usuario.getPuntaje() + 1);
            usuarioDao.update(usuario);
        }
    }

}

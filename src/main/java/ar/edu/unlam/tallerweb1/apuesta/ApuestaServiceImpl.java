package ar.edu.unlam.tallerweb1.apuesta;

import ar.edu.unlam.tallerweb1.fase.Fase;
import ar.edu.unlam.tallerweb1.partido.Partido;
import ar.edu.unlam.tallerweb1.partido.PartidoCrud;
import ar.edu.unlam.tallerweb1.usuario.Usuario;
import ar.edu.unlam.tallerweb1.usuario.UsuarioCrud;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApuestaServiceImpl implements ApuestaService {
    @Inject
    private UsuarioCrud usuarioDao;
    @Inject
    private PartidoCrud partidoDao;
    @Inject
    private ApuestaRepository apuestaDao;

    @Override
    public ModelMap obtenerModeloPrimeraFase() {
        //El usuario que estoy creando aca en realidad seria el usuario que esta logueado
        Usuario usuario = usuarioDao.read("daniel.marconi");
        if(usuario == null){
            usuario = new Usuario("daniel.marconi@gmail.com", "daniel.marconi", "123456", 0);
            usuarioDao.create(usuario);
        }

        Fase faseDeGrupos = new Fase("Fase de grupos", "Fase de grupos");
        List<Partido> partidos = partidoDao.consultarPartidosPorFase("Fase de grupos");
        List<Apuesta> apuestas = this.obtenerApuestasParaUsuario(usuario, faseDeGrupos, partidos);

        ModelMap modelo = new ModelMap();

        modelo.put("usuario", usuario);
        modelo.addAttribute("apuestas", apuestas);

        return modelo;
    }

    private List<Apuesta> obtenerApuestasParaUsuario(Usuario usuario, Fase fase, List<Partido> partidos) {
        List<Apuesta> apuestas;

        if(apuestaDao.existenApuestasDeUsuarioEnFase(usuario, fase)){
            apuestas = apuestaDao.obtenerApuestasPorUsuario(usuario);
        } else {
            apuestas = apuestaDao.crearApuestasParaUsuario(usuario, partidos);
        }

        return apuestas;
    }
}

package ar.edu.unlam.tallerweb1.apuesta;

import ar.edu.unlam.tallerweb1.fase.Fase;
import ar.edu.unlam.tallerweb1.partido.Partido;
import ar.edu.unlam.tallerweb1.partido.PartidoCrud;
import ar.edu.unlam.tallerweb1.usuario.Usuario;
import ar.edu.unlam.tallerweb1.usuario.UsuarioCrud;
import ar.edu.unlam.tallerweb1.util.SalahProperties;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;
import java.util.Properties;

@Service
public class ApuestaServiceImpl implements ApuestaService {
    @Inject
    private UsuarioCrud usuarioDao;
    @Inject
    private PartidoCrud partidoDao;
    @Inject
    private ApuestaRepository apuestaDao;

    @Inject
    private SalahProperties salahProperties;

    private String EQUIPO_LOCAL;
    private String EQUIPO_VISITANTE;
    private String RESTA;
    private String SUMA;

    @PostConstruct
    public void setUp(){
        EQUIPO_LOCAL = salahProperties.getProperty("equipo.local");
        EQUIPO_VISITANTE = salahProperties.getProperty("equipo.visitante");
        RESTA = salahProperties.getProperty("resta");
        SUMA = salahProperties.getProperty("suma");
    }

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

    public Integer modificarGolesApostados(Long apuestaId, String equipo, String accion){
        if(!equipoValido(equipo)) throw new IllegalArgumentException("Equipo invalido");
        if(!accionValida(accion)) throw new IllegalArgumentException("Accion invalida");

        return apuestaDao.modificarGolesApostados(apuestaId, equipo, accion);
    }

    private Boolean equipoValido(String equipo){
        return equipo.equalsIgnoreCase(EQUIPO_LOCAL) || equipo.equalsIgnoreCase(EQUIPO_VISITANTE);
    }

    private Boolean accionValida(String accion){
        return accion.equalsIgnoreCase(SUMA) || accion.equalsIgnoreCase(RESTA);
    }
}

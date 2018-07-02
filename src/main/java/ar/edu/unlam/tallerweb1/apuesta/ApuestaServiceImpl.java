package ar.edu.unlam.tallerweb1.apuesta;

import ar.edu.unlam.tallerweb1.jugador.Jugador;
import ar.edu.unlam.tallerweb1.jugador.JugadorCrud;
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

@Service
public class ApuestaServiceImpl implements ApuestaService {
    @Inject
    private UsuarioCrud usuarioDao;
    @Inject
    private PartidoCrud partidoDao;
    @Inject
    private ApuestaDao apuestaDao;
    @Inject
    private JugadorCrud jugadorDao;
    
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
    public ModelMap obtenerModeloPorFase(String fase) {
        //El usuario que estoy creando aca en realidad seria el usuario que esta logueado
        Usuario usuario = usuarioDao.read("daniel.marconi");
        if(usuario == null){
            usuario = new Usuario("daniel.marconi@gmail.com", "daniel.marconi", "123456", 0);
            usuarioDao.create(usuario);
        }

        String nombreFase = validarFase(fase);
        List<Partido> partidos = partidoDao.consultarPartidosPorFase(nombreFase);
        List<Apuesta> apuestas = this.obtenerApuestasParaUsuario(usuario, nombreFase, partidos);
        List<Jugador> jugador = jugadorDao.list();

        ModelMap modelo = new ModelMap();

        modelo.put("usuario", usuario);
        modelo.put("fase", nombreFase);
        modelo.addAttribute("apuestas", apuestas);
        modelo.addAttribute("jugadores", jugador);

        return modelo;
    }

    private List<Apuesta> obtenerApuestasParaUsuario(Usuario usuario, String nombreFase, List<Partido> partidos) {
        List<Apuesta> apuestas;

        if(apuestaDao.existenApuestasDeUsuarioEnFase(usuario, nombreFase)){
            apuestas = apuestaDao.obtenerApuestasPorUsuarioPorFase(usuario, nombreFase);
        } else {
            apuestas = apuestaDao.crearApuestasParaUsuario(usuario, partidos);
        }
        return apuestas;
    }

    public Integer modificarGolesApostados(Long apuestaId, String equipo, String accion){
        if(partidoJugado(apuestaId)) throw new IllegalArgumentException("No se puede apostar por un partido que ya termino");
        if(!equipoValido(equipo)) throw new IllegalArgumentException("Equipo invalido");
        if(!accionValida(accion)) throw new IllegalArgumentException("Accion invalida");

        return apuestaDao.modificarGolesApostados(apuestaId, equipo, accion);
    }

    public void modificarFiguraApostada(Long apuestaId, Long figuraId){
        apuestaDao.modificarFigura(apuestaId, figuraId);
    }

    private Boolean partidoJugado(Long apuestaId){
        Apuesta apuesta = apuestaDao.read(apuestaId);
        return apuesta.getPartido().getJugado();
    }

    private Boolean equipoValido(String equipo){
        return equipo.equalsIgnoreCase(EQUIPO_LOCAL) || equipo.equalsIgnoreCase(EQUIPO_VISITANTE);
    }

    private Boolean accionValida(String accion){
        return accion.equalsIgnoreCase(SUMA) || accion.equalsIgnoreCase(RESTA);
    }

    private String validarFase(String fase){
        if(fase.equals("grupos")) return SalahProperties.FASE_DE_GRUPOS;
        if(fase.equals("octavos")) return SalahProperties.FASE_OCTAVOS_DE_FINAL;
        if(fase.equals("cuartos")) return SalahProperties.FASE_CUARTOS_DE_FINAL;
        if(fase.equals("semifinal")) return SalahProperties.FASE_SEMIFINAL;
        if(fase.equals("tercer-puesto")) return SalahProperties.FASE_TERCER_PUESTO;
        if(fase.equals("final")) return SalahProperties.FASE_FINAL;
        throw new IllegalArgumentException("Fase invalida");
    }
}

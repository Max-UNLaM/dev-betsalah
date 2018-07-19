package ar.edu.unlam.tallerweb1.apuesta;

import ar.edu.unlam.tallerweb1.jugador.Jugador;
import ar.edu.unlam.tallerweb1.jugador.JugadorCrud;
import ar.edu.unlam.tallerweb1.partido.Partido;
import ar.edu.unlam.tallerweb1.partido.PartidoCrud;
import ar.edu.unlam.tallerweb1.usuario.Usuario;
import ar.edu.unlam.tallerweb1.usuario.UsuarioCrud;
import ar.edu.unlam.tallerweb1.util.Equipos;
import ar.edu.unlam.tallerweb1.util.Operaciones;
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

    public void setUsuarioDao(UsuarioCrud usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    public void setPartidoDao(PartidoCrud partidoDao) {
        this.partidoDao = partidoDao;
    }

    public void setApuestaDao(ApuestaDao apuestaDao) {
        this.apuestaDao = apuestaDao;
    }

    public void setJugadorDao(JugadorCrud jugadorDao) {
        this.jugadorDao = jugadorDao;
    }

    @Override
    public ModelMap obtenerModeloPorFase(String fase, Long usuarioId) {
        Usuario usuario = usuarioDao.read(usuarioId);
        if(usuario == null) throw new IllegalArgumentException("El usuario no existe");

        ApuestaValidador apuestaValidador = new ApuestaValidador();
        String nombreFase = apuestaValidador.validarFase(fase);
        List<Partido> partidos = partidoDao.consultarPartidosPorFase(nombreFase);
        List<Apuesta> apuestas = this.obtenerApuestasParaUsuario(usuario, nombreFase, partidos);
        List<Jugador> jugador = jugadorDao.list();

        ModelMap modelo = new ModelMap();

        modelo.put("sesion", true);
        modelo.put("usuario", usuario);
        modelo.put("fase", nombreFase);
        modelo.addAttribute("apuestas", apuestas);
        modelo.addAttribute("jugadores", jugador);

        return modelo;
    }

    public List<Apuesta> obtenerApuestasParaUsuario(Usuario usuario, String nombreFase, List<Partido> partidos) {
        List<Apuesta> apuestas;

        if(apuestaDao.existenApuestasDeUsuarioEnFase(usuario, nombreFase)){
            apuestas = apuestaDao.obtenerApuestasPorUsuarioPorFase(usuario, nombreFase);
            for(int i = 0; i < apuestas.size(); i++){
                apuestas.get(i).setPartido(partidos.get(i));
            }
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
        Apuesta apuesta = apuestaDao.read(apuestaId);
        Partido partido = apuesta.getPartido();

        if(!partido.getJugado()){
            Jugador figura = jugadorDao.read(figuraId);
            apuestaDao.modificarFigura(apuestaId, figura);
        } else {
            throw new IllegalArgumentException("No se puede cambiar la figura de un partido que ya fue jugado");
        }

    }

    private Boolean partidoJugado(Long apuestaId){
        Apuesta apuesta = apuestaDao.read(apuestaId);
        return apuesta.getPartido().getJugado();
    }

    private Boolean equipoValido(String equipo){
        return equipo.equalsIgnoreCase(Equipos.EQUIPO_LOCAL.toString()) || equipo.equalsIgnoreCase(Equipos.EQUIPO_VISITANTE.toString());
    }

    private Boolean accionValida(String accion){
        return accion.equalsIgnoreCase(Operaciones.SUMA.toString()) || accion.equalsIgnoreCase(Operaciones.RESTA.toString());
    }
}

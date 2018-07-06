package ar.edu.unlam.tallerweb1.apuesta;

import ar.edu.unlam.tallerweb1.partido.Partido;
import ar.edu.unlam.tallerweb1.usuario.Usuario;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApuestaRepository {
    Boolean existenApuestasDeUsuarioEnFase(Usuario usuario, String nombreFase);
    List<Apuesta> obtenerApuestasPorUsuarioPorFase(Usuario usuario, String fase);
    List<Apuesta> crearApuestasParaUsuario(Usuario usuario, List<Partido> partidos);
    Integer modificarGolesApostados(Long apuestaId, String equipo, String accion);
}

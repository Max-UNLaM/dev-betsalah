package ar.edu.unlam.tallerweb1.apuesta;

import ar.edu.unlam.tallerweb1.dao.Crud;
import ar.edu.unlam.tallerweb1.fase.Fase;
import ar.edu.unlam.tallerweb1.partido.Partido;
import ar.edu.unlam.tallerweb1.usuario.Usuario;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApuestaRepository {
    Boolean existenApuestasDeUsuarioEnFase(Usuario usuario, Fase fase);
    List<Apuesta> obtenerApuestasPorUsuario(Usuario usuario);
    List<Apuesta> crearApuestasParaUsuario(Usuario usuario, List<Partido> partidos);
    void modificarGolesApostados(Long apuestaId, String equipo, String accion);
}

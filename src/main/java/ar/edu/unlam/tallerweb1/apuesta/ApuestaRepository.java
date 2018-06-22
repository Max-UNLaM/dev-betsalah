package ar.edu.unlam.tallerweb1.apuesta;

import ar.edu.unlam.tallerweb1.dao.Crud;
import ar.edu.unlam.tallerweb1.fase.Fase;
import ar.edu.unlam.tallerweb1.partido.Partido;
import ar.edu.unlam.tallerweb1.usuario.Usuario;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApuestaRepository {
    public Boolean existenApuestasDeUsuarioEnFase(Usuario usuario, Fase fase);
    public List<Apuesta> obtenerApuestasPorUsuario(Usuario usuario);
    public List<Apuesta> crearApuestasParaUsuario(Usuario usuario, List<Partido> partidos);
}

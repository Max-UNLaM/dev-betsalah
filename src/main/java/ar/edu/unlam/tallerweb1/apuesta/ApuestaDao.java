package ar.edu.unlam.tallerweb1.apuesta;

import ar.edu.unlam.tallerweb1.dao.Dao;
import ar.edu.unlam.tallerweb1.fase.Fase;
import ar.edu.unlam.tallerweb1.partido.Partido;
import ar.edu.unlam.tallerweb1.usuario.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ApuestaDao extends Dao implements ApuestaRepository {
    @Override
    public Boolean existenApuestasDeUsuarioEnFase(Usuario usuario, Fase fase) {
        Boolean existenApuestas = !session
                .createCriteria(Apuesta.class)
                .createAlias("apostador", "tablaUsuarios")
                .createAlias("partido", "tablaPartidos")
                .createAlias("tablaPartidos.fase", "tablaFase")
                .add(Restrictions.eq("tablaUsuarios.nombre", usuario.getNombre()))
                .add(Restrictions.eq("tablaFase.nombre", fase.getNombre()))
                .list()
                .isEmpty();
        return existenApuestas;
    }

    @Override
    public List<Apuesta> obtenerApuestasPorUsuario(Usuario usuario) {
        List<Apuesta> apuestas = session
                .createCriteria(Apuesta.class)
                .createAlias("apostador","tablaUsuarios" )
                .add(Restrictions.eq("tablaUsuarios.id", usuario.getId()))
                .list();
        return apuestas;
    }

    @Override
    public List<Apuesta> crearApuestasParaUsuario(Usuario usuario, List<Partido> partidos) {
        List<Apuesta> apuestas = new ArrayList<>();
        Apuesta apuestaActual;

        for(Partido partido : partidos){
            apuestaActual = new Apuesta(usuario, partido, 0, 0);
            session.save(apuestaActual);
            apuestas.add(apuestaActual);
        }

        return apuestas;
    }
}

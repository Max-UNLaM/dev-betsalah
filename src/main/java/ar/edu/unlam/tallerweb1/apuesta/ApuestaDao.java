package ar.edu.unlam.tallerweb1.apuesta;

import ar.edu.unlam.tallerweb1.dao.Dao;
import ar.edu.unlam.tallerweb1.fase.Fase;
import ar.edu.unlam.tallerweb1.partido.Partido;
import ar.edu.unlam.tallerweb1.usuario.Usuario;
import ar.edu.unlam.tallerweb1.util.SalahProperties;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Repository
public class ApuestaDao extends Dao implements ApuestaRepository {

    private String EQUIPO_LOCAL = SalahProperties.EQUIPO_LOCAL;
    private String EQUIPO_VISITANTE = SalahProperties.EQUIPO_VISITANTE;
    private String RESTA = SalahProperties.RESTA;
    private String SUMA = SalahProperties.SUMA;

    public Apuesta read(Usuario usuario, Partido partido) {
        return (Apuesta)
                session
                .createCriteria(Apuesta.class)
                .add(Restrictions.eq("partido",  partido))
                .add(Restrictions.eq("apostador", usuario))
                .uniqueResult();
    }

    @Override
    public Boolean existenApuestasDeUsuarioEnFase(Usuario usuario, String nombreFase) {
        Boolean existenApuestas = !session
                .createCriteria(Apuesta.class)
                .createAlias("apostador", "tablaUsuarios")
                .createAlias("partido", "tablaPartidos")
                .createAlias("tablaPartidos.fase", "tablaFase")
                .add(Restrictions.eq("tablaUsuarios.nombre", usuario.getNombre()))
                .add(Restrictions.eq("tablaFase.nombre", nombreFase))
                .list()
                .isEmpty();
        return existenApuestas;
    }

    @Override
    public List<Apuesta> obtenerApuestasPorUsuarioPorFase(Usuario usuario, String nombreFase) {
        List<Apuesta> apuestas = session
                .createCriteria(Apuesta.class)
                .createAlias("apostador","tablaUsuarios")
                .createAlias("partido", "tablaPartido")
                .createAlias("tablaPartido.fase", "tablaFase")
                .add(Restrictions.eq("tablaUsuarios.id", usuario.getId()))
                .add(Restrictions.eq("tablaFase.nombre", nombreFase))
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

    public Integer modificarGolesApostados(Long apuestaId, String equipo, String accion){
        Apuesta apuesta = session.get(Apuesta.class, apuestaId);
        if(apuesta == null) throw new IllegalArgumentException("ID de apuesta invalido");

        Integer respuesta = 0;
        Transaction transaction = session.beginTransaction();

        if(equipo.equals(EQUIPO_LOCAL) && accion.equals(RESTA)){
            if(apuesta.getGolesLocal() == 0) throw new IllegalArgumentException("No se puede apostar por una cantidad de goles menor a 0");
            respuesta = apuesta.getGolesLocal() - 1;
        } else if(equipo.equals(EQUIPO_LOCAL) && accion.equals(SUMA)){
            respuesta = apuesta.getGolesLocal() + 1;
        } else if(equipo.equals(EQUIPO_VISITANTE) && accion.equals(RESTA)){
            if(apuesta.getGolesVisitante() == 0) throw new IllegalArgumentException("No se puede apostar por una cantidad de goles menor a 0");
            respuesta = apuesta.getGolesVisitante() - 1;
        } else if(equipo.equals(EQUIPO_VISITANTE) && accion.equals(SUMA)){
            respuesta = apuesta.getGolesVisitante() + 1;
        }

        if(equipo.equals(EQUIPO_LOCAL)) apuesta.setGolesLocal(respuesta);
        if(equipo.equals(EQUIPO_VISITANTE)) apuesta.setGolesVisitante(respuesta);
        
        session.update(apuesta);

        transaction.commit();

        return respuesta;
    }
}

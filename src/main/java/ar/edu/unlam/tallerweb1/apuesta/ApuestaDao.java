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

    public Apuesta read(Usuario usuario, Partido partido) {
        return (Apuesta)
                session
                .createCriteria(Apuesta.class)
                .add(Restrictions.eq("partido",  partido))
                .add(Restrictions.eq("apostador", usuario))
                .uniqueResult();
    }

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

        apuesta.setGolesLocal(respuesta);

        session.update(apuesta);

        transaction.commit();

        return respuesta;
    }
}

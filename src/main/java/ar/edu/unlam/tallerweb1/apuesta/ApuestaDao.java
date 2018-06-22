package ar.edu.unlam.tallerweb1.apuesta;

import ar.edu.unlam.tallerweb1.fase.Fase;
import ar.edu.unlam.tallerweb1.partido.Partido;
import ar.edu.unlam.tallerweb1.usuario.Usuario;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ApuestaDao implements ApuestaRepository {
    @Inject
    private SessionFactory sessionFactory;

    public Apuesta read(Usuario usuario, Partido partido) {
        return (Apuesta)sessionFactory
                .openSession()
                .createCriteria(Apuesta.class)
                .add(Restrictions.eq("partido",  partido))
                .add(Restrictions.eq("apostador", usuario))
                .uniqueResult();
    }

    @Override
    public Boolean existenApuestasDeUsuarioEnFase(Usuario usuario, Fase fase) {
        return !sessionFactory
                .openSession()
                .createCriteria(Apuesta.class)
                .add(Restrictions.eq("apostador", usuario))
                .createAlias("partido", "par")
                .add(Restrictions.eq("par.fase", fase))
                .list()
                .isEmpty();
    }

    @Override
    public List<Apuesta> obtenerApuestasPorUsuario(Usuario usuario) {
        return (List<Apuesta>) sessionFactory
                .openSession()
                .createCriteria(Apuesta.class)
                .createAlias("usuario","tablaUsuarios" )
                .add(Restrictions.eq("tablaUsuarios.id", usuario.getId()))
                .list();
    }

    @Override
    public List<Apuesta> crearApuestasParaUsuario(Usuario usuario, List<Partido> partidos) {
        List<Apuesta> apuestas = new ArrayList<>();
        Apuesta apuestaActual;

        for(Partido partido : partidos){
            apuestaActual = new Apuesta(usuario, partido, 0, 0);
            sessionFactory.openSession().save(apuestaActual);
            apuestas.add(apuestaActual);
        }

        return apuestas;
    }
}

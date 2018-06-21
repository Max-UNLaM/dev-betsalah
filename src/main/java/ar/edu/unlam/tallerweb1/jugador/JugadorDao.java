package ar.edu.unlam.tallerweb1.jugador;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class JugadorDao implements JugadorCrud {
    @Inject
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Jugador> list() {
        final Session sesion = sessionFactory.openSession();
        return sesion.createCriteria(Jugador.class)
                .list();
    }

    public Jugador update(Jugador gol) {
        final Session sesion = sessionFactory.openSession();
        sesion.update(gol);
        return gol;
    }

    public Jugador read(Long id) {
        final Session sesion = sessionFactory.openSession();
        return sesion.get(Jugador.class, id);
    }

    public Jugador read(String nombre) {
        final Session sesion = sessionFactory.openSession();
        return (Jugador)sesion.createCriteria(Jugador.class)
                .add(Restrictions.eq("nombre", nombre))
                .uniqueResult();
    }

    public Jugador create (Jugador jugador) {
        final Session sesion = sessionFactory.openSession();
        sesion.save(jugador);
        return jugador;
    }
}

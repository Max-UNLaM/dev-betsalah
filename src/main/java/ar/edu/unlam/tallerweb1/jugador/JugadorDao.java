package ar.edu.unlam.tallerweb1.jugador;

import ar.edu.unlam.tallerweb1.dao.Dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class JugadorDao extends Dao implements JugadorCrud {
    @SuppressWarnings("unchecked")
    public List<Jugador> list() {
        return session.createCriteria(Jugador.class)
                .list();
    }

    public Jugador update(Jugador gol) {
        session.update(gol);
        return gol;
    }

    public Jugador read(Long id) {
        return session.get(Jugador.class, id);
    }

    public Jugador read(String nombre) {
        return (Jugador)session.createCriteria(Jugador.class)
                .add(Restrictions.eq("nombre", nombre))
                .uniqueResult();
    }

    public Jugador create (Jugador jugador) {
        session.save(jugador);
        return jugador;
    }
}

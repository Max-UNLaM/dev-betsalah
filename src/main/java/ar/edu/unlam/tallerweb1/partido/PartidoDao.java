package ar.edu.unlam.tallerweb1.partido;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class PartidoDao implements PartidoCrud {
    @Inject
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Partido> list() {
        final Session sesion = sessionFactory.getCurrentSession();
        return sesion.createCriteria(Partido.class)
                .list();
    }

    public Partido update(Partido equipo) {
        final Session sesion = sessionFactory.getCurrentSession();
        sesion.update(equipo);
        return equipo;
    }

    public Partido read(Long id) {
        final Session sesion = sessionFactory.getCurrentSession();
        return sesion.get(Partido.class, id);
    }

    public Partido read(String nombre) {
        final Session sesion = sessionFactory.getCurrentSession();
        return (Partido)sesion.createCriteria(Partido.class)
                .add(Restrictions.eq("nombre", nombre))
                .uniqueResult();
    }

    public Partido create (Partido equipo) {
        final Session sesion = sessionFactory.getCurrentSession();
        sesion.save(equipo);
        return equipo;
    }
}

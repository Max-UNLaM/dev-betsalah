package ar.edu.unlam.tallerweb1.equipo;

import ar.edu.unlam.tallerweb1.gol.Gol;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class EquipoDao implements EquipoCrud {
    @Inject
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Equipo> list() {
        final Session sesion = sessionFactory.getCurrentSession();
        return sesion.createCriteria(Gol.class)
                .list();
    }

    public Equipo update(Equipo gol) {
        final Session sesion = sessionFactory.getCurrentSession();
        sesion.update(gol);
        return gol;
    }

    public Equipo read(Long id) {
        final Session sesion = sessionFactory.getCurrentSession();
        return sesion.get(Equipo.class, id);
    }

    public Equipo read(String nombre) {
        final Session sesion = sessionFactory.getCurrentSession();
        return (Equipo)sesion.createCriteria(Equipo.class)
                .add(Restrictions.eq("nombre", nombre))
                .uniqueResult();
    }

    public Equipo create (Equipo equipo) {
        final Session sesion = sessionFactory.getCurrentSession();
        sesion.save(equipo);
        return equipo;
    }
}

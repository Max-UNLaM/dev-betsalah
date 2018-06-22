package ar.edu.unlam.tallerweb1.equipo;

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
        final Session sesion = sessionFactory.openSession();
        return sesion.createCriteria(Equipo.class)
                .list();
    }

    public Equipo update(Equipo equipo) {
        final Session sesion = sessionFactory.openSession();
        sesion.update(equipo);
        return equipo;
    }

    public Equipo read(Long id) {
        final Session sesion = sessionFactory.openSession();
        return sesion.get(Equipo.class, id);
    }

    public Equipo read(String nombre) {
        final Session sesion = sessionFactory.openSession();
        return (Equipo)sesion.createCriteria(Equipo.class)
                .add(Restrictions.eq("nombre", nombre))
                .uniqueResult();
    }

    public Equipo create (Equipo equipo) {
        final Session sesion = sessionFactory.openSession();
        sesion.save(equipo);
        return equipo;
    }
}

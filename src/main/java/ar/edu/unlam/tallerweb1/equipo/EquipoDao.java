package ar.edu.unlam.tallerweb1.equipo;

import ar.edu.unlam.tallerweb1.dao.Dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class EquipoDao extends Dao implements EquipoCrud {
    @SuppressWarnings("unchecked")
    public List<Equipo> list() {
        return session.createCriteria(Equipo.class)
                .list();
    }

    public Equipo update(Equipo equipo) {
        session.update(equipo);
        return equipo;
    }

    public Equipo read(Long id) {
        return session.get(Equipo.class, id);
    }

    public Equipo read(String nombre) {
        return (Equipo)session.createCriteria(Equipo.class)
                .add(Restrictions.eq("nombre", nombre))
                .uniqueResult();
    }

    public Equipo create (Equipo equipo) {
        session.save(equipo);
        return equipo;
    }
}

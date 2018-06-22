package ar.edu.unlam.tallerweb1.gol;

import ar.edu.unlam.tallerweb1.equipo.Equipo;
import ar.edu.unlam.tallerweb1.partido.Partido;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository("golDao")
public class GolDao implements GolCrud {

    @Inject
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Gol> list() {
        final Session sesion = sessionFactory.openSession();
        return sesion.createCriteria(Gol.class)
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<Gol> list(Partido partido, Equipo equipo) {
        final Session sesion = sessionFactory.openSession();
        return  sesion.createCriteria(Gol.class)
                .add(Restrictions.eq("partido", partido))
                .add(Restrictions.eq("equipo", equipo))
                .list();
    }

    public Gol update(Gol gol) {
        final Session sesion = sessionFactory.openSession();
        sesion.update(gol);
        return gol;
    }

    public Gol read(Long id) {
        final Session sesion = sessionFactory.openSession();
        return sesion.get(Gol.class, id);
    }

    public Gol read(String goleador) {
        final Session sesion = sessionFactory.openSession();
        return (Gol)sesion.createCriteria(Gol.class)
                .add(Restrictions.eq("goleador_id", goleador))
                .uniqueResult();
    }

    public Gol create (Gol gol) {
        final Session sesion = sessionFactory.openSession();
        sesion.save(gol);
        return gol;
    }
    
    
}

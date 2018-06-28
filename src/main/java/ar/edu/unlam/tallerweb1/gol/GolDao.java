package ar.edu.unlam.tallerweb1.gol;

import ar.edu.unlam.tallerweb1.dao.Dao;
import ar.edu.unlam.tallerweb1.equipo.Equipo;
import ar.edu.unlam.tallerweb1.partido.Partido;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository("golDao")
public class GolDao extends Dao implements GolCrud {

    @Inject
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Gol> list() {
        return session.createCriteria(Gol.class)
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<Gol> list(Partido partido, Equipo equipo) {
        return  session.createCriteria(Gol.class)
                .add(Restrictions.eq("partido", partido))
                .add(Restrictions.eq("equipo", equipo))
                .list();
    }

    public Gol update(Gol gol) {
        session.update(gol);
        return gol;
    }

    public Gol read(Long id) {
        return session.get(Gol.class, id);
    }

    public Gol read(String goleador) {
        return (Gol)session.createCriteria(Gol.class)
                .add(Restrictions.eq("goleador_id", goleador))
                .uniqueResult();
    }

    public Gol create (Gol gol) {
        session.save(gol);
        return gol;
    }
    
    
}

package ar.edu.unlam.tallerweb1.gol;

import ar.edu.unlam.tallerweb1.dao.Crud;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository("gol")
public class GolDao implements Crud<Gol, Long> {
    @Inject
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Gol> list() {
        final Session sesion = sessionFactory.getCurrentSession();
        return sesion.createCriteria(Gol.class)
                .list();
    }

    public Gol update(Gol gol) {
        final Session sesion = sessionFactory.getCurrentSession();
        sesion.update(gol);
        return gol;
    }

    public Gol read(Long id) {
        final Session sesion = sessionFactory.getCurrentSession();
        return sesion.get(Gol.class, id);
    }
}

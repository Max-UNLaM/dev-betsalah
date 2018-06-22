package ar.edu.unlam.tallerweb1.fase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


import javax.inject.Inject;
import java.util.List;

@Repository
public class FaseDao{
    @Inject
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Fase> list() {
        final Session sesion = sessionFactory.openSession();
        return sesion.createCriteria(Fase.class)
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<Fase> list(String nombre) {
        final Session sesion = sessionFactory.openSession();
        return sesion.createCriteria(Fase.class)
                .add(Restrictions.eq("nombre", nombre))
                .list();
    }

    public Fase update(Fase gol) {
        final Session sesion = sessionFactory.openSession();
        sesion.update(gol);
        return gol;
    }

    public Fase read(Long id) {
        final Session sesion = sessionFactory.openSession();
        return sesion.get(Fase.class, id);
    }

    public Fase read(String nombre) {
        final Session sesion = sessionFactory.openSession();
        return (Fase)sesion.createCriteria(Fase.class)
                .add(Restrictions.eq("nombre", nombre))
                .uniqueResult();
    }

    public Fase create (Fase fase) {
        final Session sesion = sessionFactory.openSession();
        sesion.save(fase);
        return fase;
    }
}

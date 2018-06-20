package ar.edu.unlam.tallerweb1.fase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


import javax.inject.Inject;
import java.util.List;

@Repository("fase")
public class FaseDao implements FaseCrud {
    @Inject
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Fase> list() {
        final Session sesion = sessionFactory.getCurrentSession();
        return sesion.createCriteria(Fase.class)
                .list();
    }

    public Fase update(Fase gol) {
        final Session sesion = sessionFactory.getCurrentSession();
        sesion.update(gol);
        return gol;
    }

    public Fase read(Long id) {
        final Session sesion = sessionFactory.getCurrentSession();
        return sesion.get(Fase.class, id);
    }

    public Fase read(String nombre) {
        final Session sesion = sessionFactory.getCurrentSession();
        return (Fase)sesion.createCriteria(Fase.class)
                .add(Restrictions.eq("nombre", nombre))
                .uniqueResult();
    }

    public Fase create (Fase fase) {
        final Session sesion = sessionFactory.getCurrentSession();
        sesion.save(fase);
        return fase;
    }
}

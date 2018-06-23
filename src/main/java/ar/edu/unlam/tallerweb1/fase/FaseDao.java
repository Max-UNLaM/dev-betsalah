package ar.edu.unlam.tallerweb1.fase;
import ar.edu.unlam.tallerweb1.dao.Dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


import javax.inject.Inject;
import java.util.List;

@Repository
public class FaseDao extends Dao {
    @SuppressWarnings("unchecked")
    public List<Fase> list() {
        return session.createCriteria(Fase.class)
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<Fase> list(String nombre) {
        return session.createCriteria(Fase.class)
                .add(Restrictions.eq("nombre", nombre))
                .list();
    }

    public Fase update(Fase gol) {
        session.update(gol);
        return gol;
    }

    public Fase read(Long id) {
        return session.get(Fase.class, id);
    }

    public Fase read(String nombre) {
        return (Fase)session.createCriteria(Fase.class)
                .add(Restrictions.eq("nombre", nombre))
                .uniqueResult();
    }

    public Fase create (Fase fase) {
        session.save(fase);
        return fase;
    }
}

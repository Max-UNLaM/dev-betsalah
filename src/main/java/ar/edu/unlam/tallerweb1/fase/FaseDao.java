package ar.edu.unlam.tallerweb1.fase;
import ar.edu.unlam.tallerweb1.dao.Dao;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

    public Fase update(Fase fase) {
        Transaction transaction = session.beginTransaction();
        session.update(fase);
        transaction.commit();
        return fase;
    }

    public Fase read(Fase fase) {
        return session.get(Fase.class, fase.getId());
    }

    public Fase read(Long id) {
        return session.get(Fase.class, id);
    }

    public Fase read(String nombre) {
        return (Fase)session.createCriteria(Fase.class)
                .add(Restrictions.eq("nombre", nombre))
                .uniqueResult();
    }

    public Fase read(String tipo, String nombre) {
        return (Fase)session.createCriteria(Fase.class)
                .add(Restrictions.eq("tipo", tipo))
                .add(Restrictions.eq("nombre", nombre))
                .uniqueResult();
    }

    public Fase create (Fase fase) {
        session.save(fase);
        return fase;
    }
}

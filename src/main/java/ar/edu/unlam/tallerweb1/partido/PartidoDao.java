package ar.edu.unlam.tallerweb1.partido;


import ar.edu.unlam.tallerweb1.dao.Crud;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;


@Repository("partido")
public class PartidoDao implements Crud<Partido, Long> {
    @Inject
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Partido> list() {
        final Session sesion = sessionFactory.getCurrentSession();
        return sesion.createCriteria(Partido.class)
                .list();
    }

    public Partido update(Partido partido) {
        final Session sesion = sessionFactory.getCurrentSession();
        sesion.update(partido);
        return partido;
    }

    public Partido read(Long id) {
        return sessionFactory.getCurrentSession().get(Partido.class, id);
    }
}

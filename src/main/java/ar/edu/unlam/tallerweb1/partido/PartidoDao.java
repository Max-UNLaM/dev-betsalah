package ar.edu.unlam.tallerweb1.partido;

import ar.edu.unlam.tallerweb1.fase.Fase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.inject.Inject;
import java.util.List;

@Repository
public class PartidoDao implements PartidoCrud {
    @Inject
    private SessionFactory sessionFactory;

    public PartidoDao(){}

    @SuppressWarnings("unchecked")
    public List<Partido> list(){
        List<Partido> partidos = sessionFactory
                .openSession()
                .createCriteria(Partido.class)
                .list();
        return partidos;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Partido> consultarPartidosPorFase(String nombreFase) {
        List<Partido> partidos = sessionFactory
                .openSession()
                .createCriteria(Partido.class)
                .add(Restrictions.eq("fase", nombreFase))
                .list();

        return partidos;
    }

    public Partido create(Partido partido){
        sessionFactory
        .openSession()
        .save(partido);
        return partido;
    }

    public Partido update(Partido partido) {
        sessionFactory
                .openSession()
                .update(partido);
        return partido;
    }

    public Partido read(Long id) {
        return sessionFactory
                .openSession()
                .get(Partido.class, id);
    }

    public Partido read(String nombre) {
        throw new NotImplementedException();
    }

    @SuppressWarnings("unchecked")
    public List<Partido> list(Fase fase) {
        return sessionFactory
                .openSession()
                .createCriteria(Partido.class)
                .add(Restrictions.eq("fase_id", fase.getId()))
                .list();
    }

    public Partido read(String fase, String local, String visitante) {
        return (Partido)sessionFactory
                .openSession()
                .createCriteria(Partido.class)
                .add(Restrictions.eq("local", local))
                .add(Restrictions.eq("visitante", visitante))
                .uniqueResult();
    }
}


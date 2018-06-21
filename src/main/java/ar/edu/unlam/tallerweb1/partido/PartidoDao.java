package ar.edu.unlam.tallerweb1.partido;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class PartidoDao implements PartidoCrud {
    @Inject
    private SessionFactory sessionFactory;

    public List<Partido> list(){
        List<Partido> partidos = sessionFactory
                .openSession()
                .createCriteria(Partido.class)
                .list();
        return partidos;
    }

    @Override
    public List<Partido> consultarPartidosPorFase(String nombreFase) {
        List<Partido> partidos = sessionFactory
                .openSession()
                .createCriteria(Partido.class)
                .add(Restrictions.eq("fase", nombreFase))
                .list();

        return partidos;
    }

        public void create(Partido partido){
            sessionFactory
            .openSession()
            .save(partido);
        }


    }


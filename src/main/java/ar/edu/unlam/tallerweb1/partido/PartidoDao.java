package ar.edu.unlam.tallerweb1.partido;

import ar.edu.unlam.tallerweb1.dao.Dao;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PartidoDao extends Dao implements PartidoCrud {
    public List<Partido> list(){
        List<Partido> partidos = session
                .createCriteria(Partido.class)
                .list();
        return partidos;
    }

    @Override
    public List<Partido> consultarPartidosPorFase(String nombreFase) {
        List<Partido> partidos = session
                .createCriteria(Partido.class)
                .createAlias("fase", "tablaFase")
                .add(Restrictions.eq("tablaFase.nombre", nombreFase))
                .list();

        return partidos;
    }

        public void create(Partido partido){
            session
            .save(partido);
        }
    }


package ar.edu.unlam.tallerweb1.partido;

import ar.edu.unlam.tallerweb1.dao.Dao;
import ar.edu.unlam.tallerweb1.fase.Fase;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

@Repository
public class PartidoDao extends Dao implements PartidoCrud, PartidoFilter {

    @SuppressWarnings("unchecked")
    public List<Partido> list(){
        List<Partido> partidos = session
                .createCriteria(Partido.class)
                .list();
        return partidos;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Partido> consultarPartidosPorFase(String nombreFase) {
        List<Partido> partidos = session
                .createCriteria(Partido.class)
                .createAlias("fase", "tablaFase")
                .add(Restrictions.eq("tablaFase.nombre", nombreFase))
                .list();
        return partidos;
    }

    public Partido create(Partido partido){
        session.save(partido);
        return partido;
    }

    public Partido update(Partido partido) {
        Transaction transaction = session.beginTransaction();
        session.update(partido);
        transaction.commit();
        return partido;
    }

    public Partido read(Long id) {
        return session.get(Partido.class, id);
    }

    public Partido read(String nombre) {
        throw new NotImplementedException();
    }

    @SuppressWarnings("unchecked")
    public List<Partido> list(Fase fase) {
        return session
                .createCriteria(Partido.class)
                .add(Restrictions.eq("fase_id", fase.getId()))
                .list();
    }

    public Partido read(String fase, String local, String visitante) {
        return (Partido)
                session
                .createCriteria(Partido.class)
                .add(Restrictions.eq("local", local))
                .add(Restrictions.eq("visitante", visitante))
                .uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<Partido> filter(Fase fase) {
        return session
                .createCriteria(Partido.class)
                .add(Restrictions.eq("fase", fase))
                .list();
    }
}


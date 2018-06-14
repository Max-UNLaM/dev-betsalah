package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Fase;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository()
public class FaseDao {
    @Autowired
    private SessionFactory sessionFactory;

    public Fase obtenerFasePorNombre(String nombreDeLaFase){
        return (Fase) sessionFactory.getCurrentSession()
                .createCriteria(Fase.class)
                .add(Restrictions.eq("nombre", nombreDeLaFase))
                .uniqueResult();
    }

    public List<Fase> obtenerTodasLasFases(){
        return (List<Fase>) sessionFactory.getCurrentSession()
                .createCriteria(Fase.class)
                .list();
    }

    public void guardarFaseEnBaseDeDatos(Fase fase){
        sessionFactory.getCurrentSession().save(fase);
    }
}

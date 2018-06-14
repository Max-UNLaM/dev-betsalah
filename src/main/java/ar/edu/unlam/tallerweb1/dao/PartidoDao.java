package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Partido;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PartidoDao {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Partido> obtenerTodosLosPartidos(){
        return (List<Partido>) sessionFactory.getCurrentSession()
                .createCriteria(Partido.class)
                .list();
    }

    public void guardarPartidoEnBaseDeDatos(Partido partido){
        sessionFactory.getCurrentSession().save(partido);
    }
}

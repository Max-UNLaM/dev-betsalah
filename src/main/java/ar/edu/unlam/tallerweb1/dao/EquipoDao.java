package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Equipo;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EquipoDao {
    @Autowired
    private SessionFactory sessionFactory;

    public Equipo obtenerEquipoPorNombre(String nombreEquipo){
        return (Equipo) sessionFactory.getCurrentSession()
                .createCriteria(Equipo.class)
                .add(Restrictions.eq("nombre", nombreEquipo))
                .uniqueResult();
    }

    public List<Equipo> obtenerTodosLosEquipos(){
        return (List<Equipo>) sessionFactory.getCurrentSession()
                .createCriteria(Equipo.class)
                .list();
    }

    public void guardarEquipoEnBaseDeDatos(Equipo equipo){
        sessionFactory.getCurrentSession().save(equipo);
    }
}

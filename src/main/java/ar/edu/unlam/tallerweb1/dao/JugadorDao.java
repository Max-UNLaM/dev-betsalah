package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Jugador;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JugadorDao {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Jugador> obtenerTodosLosJugadores(){
        return (List<Jugador>) sessionFactory.getCurrentSession()
                .createCriteria(Jugador.class)
                .list();
    }

    public void guardarJugadorEnBaseDeDatos(Jugador jugador){
        sessionFactory.getCurrentSession().save(jugador);
    }
}

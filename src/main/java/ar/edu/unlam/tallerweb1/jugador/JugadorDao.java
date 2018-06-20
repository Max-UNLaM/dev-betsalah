package ar.edu.unlam.tallerweb1.jugador;

import ar.edu.unlam.tallerweb1.dao.Crud;
import ar.edu.unlam.tallerweb1.jugador.Jugador;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JugadorDao extends Crud<Jugador, Long> {
}

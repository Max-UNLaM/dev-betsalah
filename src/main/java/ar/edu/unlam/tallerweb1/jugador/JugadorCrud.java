package ar.edu.unlam.tallerweb1.jugador;

import java.util.List;

import ar.edu.unlam.tallerweb1.dao.Crud;

public interface JugadorCrud extends Crud<Jugador, Long> {
	public List<Jugador> list();
}

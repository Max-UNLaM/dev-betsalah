package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

public interface Ordenar<T> {
	List<T>orderBy(String column);
}

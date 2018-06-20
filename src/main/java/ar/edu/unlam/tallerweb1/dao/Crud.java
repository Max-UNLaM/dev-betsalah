package ar.edu.unlam.tallerweb1.dao;

import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface Crud<T, PK extends Serializable> {
    // crud genérico, T = cualquier Objeto => T recibe T y devuelve T
    List<T> list();
    T read(PK id);
    T read(String nombre);
    T update(T t);
    T create(T t);
}

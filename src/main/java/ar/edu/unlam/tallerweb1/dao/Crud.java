package ar.edu.unlam.tallerweb1.dao;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

public interface Crud<T, PK extends Serializable> extends Repository{
    // crud genérico, T = cualquier Objeto => T recibe T y devuelve T
    List<T> list();
    T read(PK id);
    T read(String nombre);
    T update(T t);
    T create(T t);
}

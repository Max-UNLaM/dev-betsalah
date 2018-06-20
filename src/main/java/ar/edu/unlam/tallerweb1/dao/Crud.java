package ar.edu.unlam.tallerweb1.dao;
import java.io.Serializable;
import java.util.List;

public interface Crud<T, PK extends Serializable> {
    // crud genérico, T = cualquier Objeto => T recibe T y devuelve T
    List<T> list();
    T read(PK id);
    T update(T t);
}

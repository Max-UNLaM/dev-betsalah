package ar.edu.unlam.tallerweb1.dao;

import java.io.Serializable;

public interface Crud<T, PK extends Serializable> {
    // crud genérico, T = cualquier Objeto => T recibe T y devuelve T
    T list(T t);
    T read(PK id);
    T update(T t);
}

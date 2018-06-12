package ar.edu.unlam.tallerweb1.dao;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

public interface Crud<T, PK extends Serializable> {
    // crud genérico, T = cualquier Objeto => T recibe T y devuelve T
    List<T> list();
    T read(PK id);
    T update(T t);
}

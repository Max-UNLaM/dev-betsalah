package ar.edu.unlam.tallerweb1.equipo;

import ar.edu.unlam.tallerweb1.dao.Crud;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

@Repository
public interface EquipoDao extends Crud<Equipo, Long> {
}

package ar.edu.unlam.tallerweb1.fase;

import ar.edu.unlam.tallerweb1.dao.Crud;
import ar.edu.unlam.tallerweb1.fase.Fase;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

@Repository("fase")
public interface FaseDao extends Crud<Fase, Long> {
}

package ar.edu.unlam.tallerweb1.equipo;

import ar.edu.unlam.tallerweb1.dao.Crud;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoDao extends Crud<Equipo, Long> {
}

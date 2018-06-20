package ar.edu.unlam.tallerweb1.fase;

import ar.edu.unlam.tallerweb1.dao.Crud;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("fase")
@Qualifier("FaseDao")
public interface FaseDao extends Crud<Fase, Long> {
}

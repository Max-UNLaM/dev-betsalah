package ar.edu.unlam.tallerweb1.gol;

import ar.edu.unlam.tallerweb1.dao.Crud;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository("gol")
public interface GolDao extends Crud<Gol, Long> {
}

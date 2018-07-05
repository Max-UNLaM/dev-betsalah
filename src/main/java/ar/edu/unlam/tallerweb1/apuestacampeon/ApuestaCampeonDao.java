package ar.edu.unlam.tallerweb1.apuestacampeon;

import ar.edu.unlam.tallerweb1.dao.Dao;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class ApuestaCampeonDao extends Dao {
    public ApuestaCampeon obtenerApuestaCampeon(Long apostadorId){
        return (ApuestaCampeon) session
                .createCriteria(ApuestaCampeon.class)
                .createAlias("apostador", "tablaApostador")
                .add(Restrictions.eq("tablaApostador.id", apostadorId))
                .uniqueResult();
    }

    public void save(ApuestaCampeon apuestaCampeon){
        Transaction transaction = session.beginTransaction();
        session.save(apuestaCampeon);
        transaction.commit();
    }
}

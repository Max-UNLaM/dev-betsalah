package ar.edu.unlam.tallerweb1.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Repository
public class Dao {
    @Inject
    private SessionFactory sessionFactory;
    protected Session session;

    @PostConstruct
    private void openSession(){
        this.session = this.sessionFactory.openSession();
    }
}

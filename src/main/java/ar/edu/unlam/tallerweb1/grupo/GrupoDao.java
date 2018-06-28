package ar.edu.unlam.tallerweb1.grupo;

import ar.edu.unlam.tallerweb1.dao.Dao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GrupoDao extends Dao implements GrupoCrud{

    @Override
    public List<Grupo> list() {
        return null;
    }

    @Override
    public Grupo read(Long id) {
        return null;
    }

    @Override
    public Grupo read(String nombre) {
        return null;
    }

    @Override
    public Grupo update(Grupo grupo) {
        return null;
    }

    @Override
    public Grupo create(Grupo grupo) {
        return null;
    }
}

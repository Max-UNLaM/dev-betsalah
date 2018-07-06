package ar.edu.unlam.tallerweb1.equipo;

import ar.edu.unlam.tallerweb1.dao.Dao;
import ar.edu.unlam.tallerweb1.fase.Fase;
import ar.edu.unlam.tallerweb1.partido.Partido;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EquipoDao extends Dao implements EquipoCrud {
    @SuppressWarnings("unchecked")
    public List<Equipo> list() {
        return session.createCriteria(Equipo.class)
                .list();
    }

    public Equipo update(Equipo equipo) {
        session.update(equipo);
        return equipo;
    }

    public Equipo read(Long id) {
        return session.get(Equipo.class, id);
    }

    public Equipo read(String nombre) {
        return (Equipo)session.createCriteria(Equipo.class)
                .add(Restrictions.eq("nombre", nombre))
                .uniqueResult();
    }

    public Equipo create (Equipo equipo) {
        session.save(equipo);
        return equipo;
    }

    public List<Equipo> obtenerEquiposPorFase(Fase fase){
        List<Partido> partidos = session.createCriteria(Partido.class)
                .createAlias("fase", "tablaFase")
                .add(Restrictions.eq("tablaFase.id", fase.getId()))
                .list();

        List<Equipo> equipos = new ArrayList<>();

        for(Partido partido : partidos){
            equipos.add(partido.getLocal());
            equipos.add(partido.getVisitante());
        }

        equipos = equipos.stream().distinct().collect(Collectors.toList());

        return equipos;
    }
}

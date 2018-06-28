package ar.edu.unlam.tallerweb1.grupo;

import ar.edu.unlam.tallerweb1.equipo.Equipo;
import ar.edu.unlam.tallerweb1.equipo.EquipoDao;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class GrupoService {
    @Inject
    private GrupoDao grupoDao;

    @Inject
    private EquipoDao equipoDao;

    public void cargar(){
        if(!gruposExistenEnBaseDeDatos()){
            List<Equipo> equipos = equipoDao.list();
            List<Grupo> grupos = crearGrupos(equipos);
            cargarGruposEnBaseDeDatos(grupos);
        }
    }

    private Boolean gruposExistenEnBaseDeDatos(){
        return !grupoDao.list().isEmpty();
    }

    private List<Grupo> crearGrupos(List<Equipo> equipos){
        List<Grupo> grupos = new ArrayList<>();

        grupos.add(new Grupo("A", equipos.get(0), equipos.get(1), equipos.get(2), equipos.get(3)));
        grupos.add(new Grupo("B", equipos.get(4), equipos.get(5), equipos.get(6), equipos.get(7)));
        grupos.add(new Grupo("C", equipos.get(8), equipos.get(9), equipos.get(10), equipos.get(11)));
        grupos.add(new Grupo("D", equipos.get(12), equipos.get(13), equipos.get(14), equipos.get(15)));
        grupos.add(new Grupo("E", equipos.get(16), equipos.get(17), equipos.get(18), equipos.get(19)));
        grupos.add(new Grupo("F", equipos.get(20), equipos.get(21), equipos.get(22), equipos.get(23)));
        grupos.add(new Grupo("G", equipos.get(24), equipos.get(25), equipos.get(26), equipos.get(27)));
        grupos.add(new Grupo("H", equipos.get(28), equipos.get(29), equipos.get(30), equipos.get(31)));

        return grupos;
    }

    private void cargarGruposEnBaseDeDatos(List<Grupo> grupos){
        for(Grupo grupo : grupos){
            grupoDao.create(grupo);
        }
    }
}

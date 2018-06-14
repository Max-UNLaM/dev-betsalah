package ar.edu.unlam.tallerweb1.servicios.inicializador;

import ar.edu.unlam.tallerweb1.dao.EquipoDao;
import ar.edu.unlam.tallerweb1.dao.FaseDao;
import ar.edu.unlam.tallerweb1.dao.PartidoDao;
import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Fase;
import ar.edu.unlam.tallerweb1.modelo.Partido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioCargaPartidos {
    @Autowired
    private PartidoDao partidoDao;
    @Autowired
    private EquipoDao equipoDao;
    @Autowired
    private FaseDao faseDao;

    public void cargarPartidosSiNoExisten(){
        if(!partidosExistenEnBaseDeDatos()){
            List<Partido> partidos = crearPartidos();
            guardarPartidosEnBaseDeDatos(partidos);
        }
    }

    private Boolean partidosExistenEnBaseDeDatos(){
        return partidoDao.obtenerTodosLosPartidos() != null;
    }

    private List<Partido> crearPartidos(){
        Equipo rusia = equipoDao.obtenerEquipoPorNombre("Rusia");
        Equipo arabiaSaudita = equipoDao.obtenerEquipoPorNombre("Arabia Saudita");
        Equipo egipto = equipoDao.obtenerEquipoPorNombre("Egipto");
        Equipo uruguay = equipoDao.obtenerEquipoPorNombre("Uruguay");
        Equipo portugal = equipoDao.obtenerEquipoPorNombre("Portugal");
        Equipo espana = equipoDao.obtenerEquipoPorNombre("España");
        Equipo marruecos = equipoDao.obtenerEquipoPorNombre("Marruecos");
        Equipo iran = equipoDao.obtenerEquipoPorNombre("Irán");
        Equipo francia = equipoDao.obtenerEquipoPorNombre("Francia");
        Equipo australia = equipoDao.obtenerEquipoPorNombre("Australia");
        Equipo peru = equipoDao.obtenerEquipoPorNombre("Perú");
        Equipo dinamarca = equipoDao.obtenerEquipoPorNombre("Dinamarca");
        Equipo argentina = equipoDao.obtenerEquipoPorNombre("Argentina");
        Equipo islandia = equipoDao.obtenerEquipoPorNombre("Islandia");
        Equipo croacia = equipoDao.obtenerEquipoPorNombre("Croacia");
        Equipo nigeria = equipoDao.obtenerEquipoPorNombre("Nigeria");
        Equipo brasil = equipoDao.obtenerEquipoPorNombre("Brasil");
        Equipo suiza = equipoDao.obtenerEquipoPorNombre("Suiza");
        Equipo costaRica = equipoDao.obtenerEquipoPorNombre("Costa Rica");
        Equipo serbia = equipoDao.obtenerEquipoPorNombre("Serbia");
        Equipo alemania = equipoDao.obtenerEquipoPorNombre("Alemania");
        Equipo mexico = equipoDao.obtenerEquipoPorNombre("México");
        Equipo suecia = equipoDao.obtenerEquipoPorNombre("Suecia");
        Equipo coreaDelSur = equipoDao.obtenerEquipoPorNombre("Corea del Sur");
        Equipo belgica = equipoDao.obtenerEquipoPorNombre("Bélgica");
        Equipo panama = equipoDao.obtenerEquipoPorNombre("Panamá");
        Equipo tunez = equipoDao.obtenerEquipoPorNombre("Túnez");
        Equipo inglaterra = equipoDao.obtenerEquipoPorNombre("Inglaterra");
        Equipo polonia = equipoDao.obtenerEquipoPorNombre("Polonia");
        Equipo senegal = equipoDao.obtenerEquipoPorNombre("Senegal");
        Equipo colombia = equipoDao.obtenerEquipoPorNombre("Colombia");
        Equipo japon = equipoDao.obtenerEquipoPorNombre("Japón");

        Fase faseDeGrupos = faseDao.obtenerFasePorNombre("Fase de grupos");

        List<Partido> partidos = new ArrayList<>();

        partidos.add(new Partido(rusia, arabiaSaudita, faseDeGrupos));
        partidos.add(new Partido(egipto, uruguay, faseDeGrupos));
        partidos.add(new Partido(portugal, espana, faseDeGrupos));
        partidos.add(new Partido(marruecos, iran, faseDeGrupos));
        partidos.add(new Partido(francia, australia, faseDeGrupos));
        partidos.add(new Partido(peru, dinamarca, faseDeGrupos));
        partidos.add(new Partido(argentina, islandia, faseDeGrupos));
        partidos.add(new Partido(croacia, nigeria, faseDeGrupos));
        partidos.add(new Partido(brasil, suiza, faseDeGrupos));
        partidos.add(new Partido(costaRica, serbia, faseDeGrupos));
        partidos.add(new Partido(alemania, mexico, faseDeGrupos));
        partidos.add(new Partido(suecia, coreaDelSur, faseDeGrupos));
        partidos.add(new Partido(belgica, panama, faseDeGrupos));
        partidos.add(new Partido(tunez, inglaterra, faseDeGrupos));
        partidos.add(new Partido(polonia, senegal, faseDeGrupos));
        partidos.add(new Partido(colombia, japon, faseDeGrupos));
        partidos.add(new Partido(rusia, egipto, faseDeGrupos));
        partidos.add(new Partido(arabiaSaudita, uruguay, faseDeGrupos));
        partidos.add(new Partido(portugal, marruecos, faseDeGrupos));
        partidos.add(new Partido(espana, iran, faseDeGrupos));
        partidos.add(new Partido(francia, peru, faseDeGrupos));
        partidos.add(new Partido(australia, dinamarca, faseDeGrupos));
        partidos.add(new Partido(argentina, croacia, faseDeGrupos));
        partidos.add(new Partido(islandia, nigeria, faseDeGrupos));
        partidos.add(new Partido(brasil, costaRica, faseDeGrupos));
        partidos.add(new Partido(suiza, serbia, faseDeGrupos));
        partidos.add(new Partido(alemania, suecia, faseDeGrupos));
        partidos.add(new Partido(mexico, coreaDelSur, faseDeGrupos));
        partidos.add(new Partido(belgica, tunez, faseDeGrupos));
        partidos.add(new Partido(panama, inglaterra, faseDeGrupos));
        partidos.add(new Partido(polonia, colombia, faseDeGrupos));
        partidos.add(new Partido(senegal, japon, faseDeGrupos));
        partidos.add(new Partido(rusia, uruguay, faseDeGrupos));
        partidos.add(new Partido(arabiaSaudita, egipto, faseDeGrupos));
        partidos.add(new Partido(portugal, iran, faseDeGrupos));
        partidos.add(new Partido(espana, marruecos, faseDeGrupos));
        partidos.add(new Partido(francia, dinamarca, faseDeGrupos));
        partidos.add(new Partido(australia, peru, faseDeGrupos));
        partidos.add(new Partido(argentina, nigeria, faseDeGrupos));
        partidos.add(new Partido(islandia, croacia, faseDeGrupos));
        partidos.add(new Partido(brasil, serbia, faseDeGrupos));
        partidos.add(new Partido(suiza, costaRica, faseDeGrupos));
        partidos.add(new Partido(alemania, coreaDelSur, faseDeGrupos));
        partidos.add(new Partido(mexico, suecia, faseDeGrupos));
        partidos.add(new Partido(belgica, inglaterra, faseDeGrupos));
        partidos.add(new Partido(panama, tunez, faseDeGrupos));
        partidos.add(new Partido(polonia, japon, faseDeGrupos));
        partidos.add(new Partido(senegal, colombia, faseDeGrupos));

        return partidos;
    }

    private void guardarPartidosEnBaseDeDatos(List<Partido> partidos){
        for(Partido partido : partidos){
            partidoDao.guardarPartidoEnBaseDeDatos(partido);
        }
    }
}

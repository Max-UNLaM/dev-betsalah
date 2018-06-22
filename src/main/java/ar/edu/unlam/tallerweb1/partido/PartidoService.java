package ar.edu.unlam.tallerweb1.partido;

import ar.edu.unlam.tallerweb1.equipo.Equipo;
import ar.edu.unlam.tallerweb1.equipo.EquipoDao;
import ar.edu.unlam.tallerweb1.fase.Fase;
import ar.edu.unlam.tallerweb1.fase.FaseDao;
import ar.edu.unlam.tallerweb1.gol.GolDao;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class PartidoService {

    @Inject
    private PartidoDao partidoDao;

    @Inject
    private EquipoDao equipoDao;

    @Inject
    private FaseDao faseDao;

    @Inject
    private GolDao golDao;

    public void cargar() {
        if (!partidosExistenEnBaseDeDatos()) {
            List<Partido> partidos = crearPartidos();
            guardarPartidosEnBaseDeDatos(partidos);
        }
    }

    public List<Partido> partidosDeFase(Fase fase) {
        return partidoDao.list(fase);
    }

    private Boolean partidosExistenEnBaseDeDatos() {
        return !partidoDao.list().isEmpty();
    }

    private List<Partido> crearPartidos() {
        Equipo rusia = equipoDao.read("Rusia");
        Equipo arabiaSaudita = equipoDao.read("Arabia Saudita");
        Equipo egipto = equipoDao.read("Egipto");
        Equipo uruguay = equipoDao.read("Uruguay");
        Equipo portugal = equipoDao.read("Portugal");
        Equipo espana = equipoDao.read("España");
        Equipo marruecos = equipoDao.read("Marruecos");
        Equipo iran = equipoDao.read("Irán");
        Equipo francia = equipoDao.read("Francia");
        Equipo australia = equipoDao.read("Australia");
        Equipo peru = equipoDao.read("Perú");
        Equipo dinamarca = equipoDao.read("Dinamarca");
        Equipo argentina = equipoDao.read("Argentina");
        Equipo islandia = equipoDao.read("Islandia");
        Equipo croacia = equipoDao.read("Croacia");
        Equipo nigeria = equipoDao.read("Nigeria");
        Equipo brasil = equipoDao.read("Brasil");
        Equipo suiza = equipoDao.read("Suiza");
        Equipo costaRica = equipoDao.read("Costa Rica");
        Equipo serbia = equipoDao.read("Serbia");
        Equipo alemania = equipoDao.read("Alemania");
        Equipo mexico = equipoDao.read("México");
        Equipo suecia = equipoDao.read("Suecia");
        Equipo coreaDelSur = equipoDao.read("Corea del Sur");
        Equipo belgica = equipoDao.read("Bélgica");
        Equipo panama = equipoDao.read("Panamá");
        Equipo tunez = equipoDao.read("Túnez");
        Equipo inglaterra = equipoDao.read("Inglaterra");
        Equipo polonia = equipoDao.read("Polonia");
        Equipo senegal = equipoDao.read("Senegal");
        Equipo colombia = equipoDao.read("Colombia");
        Equipo japon = equipoDao.read("Japón");

        Fase faseDeGrupos = faseDao.read("Fase de grupos");

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

    private void guardarPartidosEnBaseDeDatos(List<Partido> partidos) {
        for (Partido partido : partidos) {
            partidoDao.create(partido);

        }
    }
}

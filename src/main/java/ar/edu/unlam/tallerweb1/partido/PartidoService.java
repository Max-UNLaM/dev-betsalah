package ar.edu.unlam.tallerweb1.partido;

import ar.edu.unlam.tallerweb1.equipo.Equipo;
import ar.edu.unlam.tallerweb1.equipo.EquipoDao;
import ar.edu.unlam.tallerweb1.equipo.EquipoService;
import ar.edu.unlam.tallerweb1.fase.Fase;
import ar.edu.unlam.tallerweb1.fase.FaseDao;
import ar.edu.unlam.tallerweb1.gol.Gol;
import ar.edu.unlam.tallerweb1.gol.GolService;
import ar.edu.unlam.tallerweb1.simulacion.ResultadoService;
import ar.edu.unlam.tallerweb1.util.SalahProperties;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class PartidoService {
    @Inject
    private PartidoFilter partidoFilter;
    @Inject
    private PartidoCrud partidoCrud;
    @Inject
    protected EquipoService equipoService;
    @Inject
    private EquipoDao equipoDao;
    @Inject
    private FaseDao faseDao;
    @Inject
    private GolService golService;
    @Inject
    private ResultadoService resultadoService;

    private String FASE_DE_GRUPOS = SalahProperties.FASE_DE_GRUPOS;
    private String FASE_OCTAVOS_DE_FINAL = SalahProperties.FASE_OCTAVOS_DE_FINAL;
    private String FASE_CUARTOS_DE_FINAL = SalahProperties.FASE_CUARTOS_DE_FINAL;
    private String FASE_SEMIFINAL = SalahProperties.FASE_SEMIFINAL;
    private String FASE_TERCER_PUESTO = SalahProperties.FASE_TERCER_PUESTO;
    private String FASE_FINAL = SalahProperties.FASE_FINAL;

    private String GRUPO_A = SalahProperties.GRUPO_A;
    private String GRUPO_B = SalahProperties.GRUPO_B;
    private String GRUPO_C = SalahProperties.GRUPO_C;
    private String GRUPO_D = SalahProperties.GRUPO_D;
    private String GRUPO_E = SalahProperties.GRUPO_E;
    private String GRUPO_F = SalahProperties.GRUPO_F;
    private String GRUPO_G = SalahProperties.GRUPO_G;
    private String GRUPO_H = SalahProperties.GRUPO_H;

    private String OCTAVOS_1 = SalahProperties.OCTAVOS_1;
    private String OCTAVOS_2 = SalahProperties.OCTAVOS_2;
    private String OCTAVOS_3 = SalahProperties.OCTAVOS_3;
    private String OCTAVOS_4 = SalahProperties.OCTAVOS_4;
    private String OCTAVOS_5 = SalahProperties.OCTAVOS_5;
    private String OCTAVOS_6 = SalahProperties.OCTAVOS_6;
    private String OCTAVOS_7 = SalahProperties.OCTAVOS_7;
    private String OCTAVOS_8 = SalahProperties.OCTAVOS_8;

    private String CUARTOS_1 = SalahProperties.CUARTOS_1;
    private String CUARTOS_2 = SalahProperties.CUARTOS_2;
    private String CUARTOS_3 = SalahProperties.CUARTOS_3;
    private String CUARTOS_4 = SalahProperties.CUARTOS_4;

    private String SEMIFINAL_1 = SalahProperties.SEMIFINAL_1;
    private String SEMIFINAL_2 = SalahProperties.SEMIFINAL_2;

    private String TERCER_PUESTO = SalahProperties.TERCER_PUESTO;
    private String FINAL = SalahProperties.FINAL;

    public void cargar() {
        if (!partidosExistenEnBaseDeDatos()) {
            List<Partido> partidos = crearPartidos();
            guardarPartidosEnBaseDeDatos(partidos);
        }
    }

    public PartidoDto getPartidoDto(Partido partido) {
        List<Gol> listaGolesLocal = golService.obtenerGolesPartidoYEquipo(partido, partido.local);
        Integer golesLocal = listaGolesLocal.size();
        List<Gol> listaGolesVisitante = golService.obtenerGolesPartidoYEquipo(partido, partido.visitante);
        Integer golesVisitante = listaGolesVisitante.size();
        String resultado = partido.jugado ? resultadoService.textoGanador(partido) : "Sin jugar";
        return new PartidoDto(partido.id, golesLocal, golesVisitante, equipoService.obtenerEquipoDto(partido.local), equipoService.obtenerEquipoDto(partido.visitante), partido.jugado, resultado);
    }

    public List<Partido> filterByFase(Fase fase) {
        return partidoFilter.filter(fase);
    }

    private Boolean partidosExistenEnBaseDeDatos() {
        return !partidoCrud.list().isEmpty();
    }

    private List<Partido> crearPartidos(){
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

        Fase grupoA = faseDao.read(GRUPO_A, FASE_DE_GRUPOS);
        Fase grupoB = faseDao.read(GRUPO_B, FASE_DE_GRUPOS);
        Fase grupoC = faseDao.read(GRUPO_C, FASE_DE_GRUPOS);
        Fase grupoD = faseDao.read(GRUPO_D, FASE_DE_GRUPOS);
        Fase grupoE = faseDao.read(GRUPO_E, FASE_DE_GRUPOS);
        Fase grupoF = faseDao.read(GRUPO_F, FASE_DE_GRUPOS);
        Fase grupoG = faseDao.read(GRUPO_G, FASE_DE_GRUPOS);
        Fase grupoH = faseDao.read(GRUPO_H, FASE_DE_GRUPOS);

        Fase octavos1 = faseDao.read(OCTAVOS_1, FASE_OCTAVOS_DE_FINAL);
        Fase octavos2 = faseDao.read(OCTAVOS_2, FASE_OCTAVOS_DE_FINAL);
        Fase octavos3 = faseDao.read(OCTAVOS_3, FASE_OCTAVOS_DE_FINAL);
        Fase octavos4 = faseDao.read(OCTAVOS_4, FASE_OCTAVOS_DE_FINAL);
        Fase octavos5 = faseDao.read(OCTAVOS_5, FASE_OCTAVOS_DE_FINAL);
        Fase octavos6 = faseDao.read(OCTAVOS_6, FASE_OCTAVOS_DE_FINAL);
        Fase octavos7 = faseDao.read(OCTAVOS_7, FASE_OCTAVOS_DE_FINAL);
        Fase octavos8 = faseDao.read(OCTAVOS_8, FASE_OCTAVOS_DE_FINAL);

        Fase cuartos1 = faseDao.read(CUARTOS_1, FASE_CUARTOS_DE_FINAL);
        Fase cuartos2 = faseDao.read(CUARTOS_2, FASE_CUARTOS_DE_FINAL);
        Fase cuartos3 = faseDao.read(CUARTOS_3, FASE_CUARTOS_DE_FINAL);
        Fase cuartos4 = faseDao.read(CUARTOS_4, FASE_CUARTOS_DE_FINAL);

        Fase semifinal1 = faseDao.read(SEMIFINAL_1, FASE_SEMIFINAL);
        Fase semifinal2 = faseDao.read(SEMIFINAL_2, FASE_SEMIFINAL);

        Fase tercerPuesto = faseDao.read(TERCER_PUESTO, FASE_TERCER_PUESTO);
        Fase partidoFinal = faseDao.read(FINAL, FASE_FINAL);

        List<Partido> partidos = new ArrayList<>();

        partidos.add(new Partido(rusia, arabiaSaudita, grupoA));
        partidos.add(new Partido(egipto, uruguay, grupoA));
        partidos.add(new Partido(portugal, espana, grupoB));
        partidos.add(new Partido(marruecos, iran, grupoB));
        partidos.add(new Partido(francia, australia, grupoC));
        partidos.add(new Partido(peru, dinamarca, grupoC));
        partidos.add(new Partido(argentina, islandia, grupoD));
        partidos.add(new Partido(croacia, nigeria, grupoD));
        partidos.add(new Partido(brasil, suiza, grupoE));
        partidos.add(new Partido(costaRica, serbia, grupoE));
        partidos.add(new Partido(alemania, mexico, grupoF));
        partidos.add(new Partido(suecia, coreaDelSur, grupoF));
        partidos.add(new Partido(belgica, panama, grupoG));
        partidos.add(new Partido(tunez, inglaterra, grupoG));
        partidos.add(new Partido(polonia, senegal, grupoH));
        partidos.add(new Partido(colombia, japon, grupoH));
        partidos.add(new Partido(rusia, egipto, grupoA));
        partidos.add(new Partido(arabiaSaudita, uruguay, grupoA));
        partidos.add(new Partido(portugal, marruecos, grupoB));
        partidos.add(new Partido(espana, iran, grupoB));
        partidos.add(new Partido(francia, peru, grupoC));
        partidos.add(new Partido(australia, dinamarca, grupoC));
        partidos.add(new Partido(argentina, croacia, grupoD));
        partidos.add(new Partido(islandia, nigeria, grupoD));
        partidos.add(new Partido(brasil, costaRica, grupoE));
        partidos.add(new Partido(suiza, serbia, grupoE));
        partidos.add(new Partido(alemania, suecia, grupoF));
        partidos.add(new Partido(mexico, coreaDelSur, grupoF));
        partidos.add(new Partido(belgica, tunez, grupoG));
        partidos.add(new Partido(panama, inglaterra, grupoG));
        partidos.add(new Partido(polonia, colombia, grupoH));
        partidos.add(new Partido(senegal, japon, grupoG));
        partidos.add(new Partido(rusia, uruguay, grupoA));
        partidos.add(new Partido(arabiaSaudita, egipto, grupoA));
        partidos.add(new Partido(portugal, iran, grupoB));
        partidos.add(new Partido(espana, marruecos, grupoB));
        partidos.add(new Partido(francia, dinamarca, grupoC));
        partidos.add(new Partido(australia, peru, grupoC));
        partidos.add(new Partido(argentina, nigeria, grupoD));
        partidos.add(new Partido(islandia, croacia, grupoD));
        partidos.add(new Partido(brasil, serbia, grupoE));
        partidos.add(new Partido(suiza, costaRica, grupoE));
        partidos.add(new Partido(alemania, coreaDelSur, grupoF));
        partidos.add(new Partido(mexico, suecia, grupoF));
        partidos.add(new Partido(belgica, inglaterra, grupoG));
        partidos.add(new Partido(panama, tunez, grupoG));
        partidos.add(new Partido(polonia, japon, grupoH));
        partidos.add(new Partido(senegal, colombia, grupoH));

        partidos.add(new Partido(null, null, octavos1));
        partidos.add(new Partido(null, null, octavos2));
        partidos.add(new Partido(null, null, octavos3));
        partidos.add(new Partido(null, null, octavos4));
        partidos.add(new Partido(null, null, octavos5));
        partidos.add(new Partido(null, null, octavos6));
        partidos.add(new Partido(null, null, octavos7));
        partidos.add(new Partido(null, null, octavos8));

        partidos.add(new Partido(null, null, cuartos1));
        partidos.add(new Partido(null, null, cuartos2));
        partidos.add(new Partido(null, null, cuartos3));
        partidos.add(new Partido(null, null, cuartos4));

        partidos.add(new Partido(null, null, semifinal1));
        partidos.add(new Partido(null, null, semifinal2));

        partidos.add(new Partido(null, null, tercerPuesto));
        partidos.add(new Partido(null, null, partidoFinal));

        return partidos;
    }

    private void guardarPartidosEnBaseDeDatos(List<Partido> partidos) {
        for (Partido partido : partidos) {
            partidoCrud.create(partido);
        }
    }
}

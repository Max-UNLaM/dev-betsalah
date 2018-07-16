package ar.edu.unlam.tallerweb1.partido;

import ar.edu.unlam.tallerweb1.equipo.Equipo;
import ar.edu.unlam.tallerweb1.equipo.EquipoDao;
import ar.edu.unlam.tallerweb1.equipo.EquipoService;
import ar.edu.unlam.tallerweb1.fase.Fase;
import ar.edu.unlam.tallerweb1.fase.FaseDao;
import ar.edu.unlam.tallerweb1.gol.Gol;
import ar.edu.unlam.tallerweb1.gol.GolService;
import ar.edu.unlam.tallerweb1.simulacion.ResultadoService;
import ar.edu.unlam.tallerweb1.tabladeposiciones.TablaDePosiciones;
import ar.edu.unlam.tallerweb1.util.Condiciones;
import ar.edu.unlam.tallerweb1.util.Fases;
import ar.edu.unlam.tallerweb1.util.Instancias;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class PartidoService {
    @Inject
    private PartidoFilter partidoFilter;
    @Inject
    private PartidoDao partidoDao;
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

    private String FASE_DE_GRUPOS = Fases.FASE_DE_GRUPOS.toString();
    private String FASE_OCTAVOS_DE_FINAL = Fases.FASE_OCTAVOS_DE_FINAL.toString();
    private String FASE_CUARTOS_DE_FINAL = Fases.FASE_CUARTOS_DE_FINAL.toString();
    private String FASE_SEMIFINAL = Fases.FASE_SEMIFINAL.toString();
    private String FASE_TERCER_PUESTO = Fases.FASE_TERCER_PUESTO.toString();
    private String FASE_FINAL = Fases.FASE_FINAL.toString();

    private String GRUPO_A = Instancias.GRUPO_A.toString();
    private String GRUPO_B = Instancias.GRUPO_B.toString();
    private String GRUPO_C = Instancias.GRUPO_C.toString();
    private String GRUPO_D = Instancias.GRUPO_D.toString();
    private String GRUPO_E = Instancias.GRUPO_E.toString();
    private String GRUPO_F = Instancias.GRUPO_F.toString();
    private String GRUPO_G = Instancias.GRUPO_G.toString();
    private String GRUPO_H = Instancias.GRUPO_H.toString();

    private String OCTAVOS_1 = Instancias.OCTAVOS_1.toString();
    private String OCTAVOS_2 = Instancias.OCTAVOS_2.toString();
    private String OCTAVOS_3 = Instancias.OCTAVOS_3.toString();
    private String OCTAVOS_4 = Instancias.OCTAVOS_4.toString();
    private String OCTAVOS_5 = Instancias.OCTAVOS_5.toString();
    private String OCTAVOS_6 = Instancias.OCTAVOS_6.toString();
    private String OCTAVOS_7 = Instancias.OCTAVOS_7.toString();
    private String OCTAVOS_8 = Instancias.OCTAVOS_8.toString();

    private String CUARTOS_1 = Instancias.CUARTOS_1.toString();
    private String CUARTOS_2 = Instancias.CUARTOS_2.toString();
    private String CUARTOS_3 = Instancias.CUARTOS_3.toString();
    private String CUARTOS_4 = Instancias.CUARTOS_4.toString();

    private String SEMIFINAL_1 = Instancias.SEMIFINAL_1.toString();
    private String SEMIFINAL_2 = Instancias.SEMIFINAL_2.toString();

    private String TERCER_PUESTO = Instancias.TERCER_PUESTO.toString();
    private String FINAL = Instancias.FINAL.toString();

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

    public List<Partido> filterByFase(List<Fase> fases) {
        List<Partido> respuesta = new ArrayList<>();
        List<Partido> respuestaParcial;

        for(Fase fase : fases){
            respuestaParcial = partidoFilter.filter(fase);
            respuesta.addAll(respuestaParcial);
        }

        return respuesta;

    }

    private Boolean partidosExistenEnBaseDeDatos() {
        return !partidoDao.list().isEmpty();
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
            partidoDao.create(partido);
        }
    }

    public void calcularPartidosSiguienteFase(List<Equipo> equipos, List<Partido> partidos, Fase fase){
        TablaDePosiciones tablaDePosiciones = new TablaDePosiciones(equipos, partidos);

        Equipo primero = tablaDePosiciones.obtenerPrimero();

        Partido siguientePartidoDelPrimero = partidoDao.obtenerPartidoPorFase(fase.getSiguienteFasePrimeroDeLaFase());
        if(fase.getCondicionSiguienteFasePrimeroDeLaFase().equals(Condiciones.CONDICION_LOCAL.toString())){
            siguientePartidoDelPrimero.setLocal(primero);
        } else {
            siguientePartidoDelPrimero.setVisitante(primero);
        }

        partidoDao.update(siguientePartidoDelPrimero);

        if(fase.getNombre().equals(Fases.FASE_DE_GRUPOS.toString())
            || fase.getNombre().equals(Fases.FASE_SEMIFINAL.toString())){
            Equipo segundo = tablaDePosiciones.obtenerSegundo();

            Partido siguientePartidoDelSegundo = partidoDao.obtenerPartidoPorFase(fase.getSiguienteFaseSegundoDeLaFase());
            if(fase.getCondicionSiguienteFaseSegundoDeLaFase().equals(Condiciones.CONDICION_LOCAL.toString())){
                siguientePartidoDelSegundo.setLocal(segundo);
            } else {
                siguientePartidoDelSegundo.setVisitante(segundo);
            }
            partidoDao.update(siguientePartidoDelSegundo);
        }
    }

    public Boolean alMenosUnPartidoFueJugado(){
        Boolean respuesta = false;
        List<Partido> partidos = partidoDao.list();

        for(Partido partido : partidos){
            respuesta |= partido.getJugado();
        }

        return respuesta;
    }
}

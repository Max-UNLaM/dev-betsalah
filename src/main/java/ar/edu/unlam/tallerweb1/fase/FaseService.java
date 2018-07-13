package ar.edu.unlam.tallerweb1.fase;

import ar.edu.unlam.tallerweb1.partido.Partido;
import ar.edu.unlam.tallerweb1.partido.PartidoDao;
import ar.edu.unlam.tallerweb1.util.Fases;
import ar.edu.unlam.tallerweb1.util.SalahProperties;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class FaseService{
    @Inject
    private FaseDao faseDao;
    @Inject
    private PartidoDao partidoDao;

    private String CONDICION_LOCAL = SalahProperties.CONDICION_LOCAL;
    private String CONDICION_VISITANTE = SalahProperties.CONDICION_VISITANTE;

    private String FASE_DE_GRUPOS = Fases.FASE_DE_GRUPOS.toString();
    private String FASE_OCTAVOS_DE_FINAL = Fases.FASE_OCTAVOS_DE_FINAL.toString();
    private String FASE_CUARTOS_DE_FINAL = Fases.FASE_CUARTOS_DE_FINAL.toString();
    private String FASE_SEMIFINAL = Fases.FASE_SEMIFINAL.toString();
    private String FASE_TERCER_PUESTO = Fases.FASE_TERCER_PUESTO.toString();
    private String FASE_FINAL = Fases.FASE_FINAL.toString();

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

    public void cargar(){
        if(!fasesExistenEnBaseDeDatos()){
            //Creo y guardo las fases sin mapear para que Hibernate les asigne un ID
            List<Fase> fases = crearFases();
            guardarFasesEnBaseDeDatos(fases);

            //Leo las fases con ID asignado, mapeo las fases siguientes y las vuelvo a guardar
            fases = mapearFases();
            actualizarFasesEnBaseDeDatos(fases);
        }
    }

    private Boolean fasesExistenEnBaseDeDatos(){
        return !faseDao.list().isEmpty();
    }

    public List<Fase> readFases(String nombre) {
        return faseDao.list(nombre);
    }

    private List<Fase> crearFases(){
        List<Fase> fases = new ArrayList<>();

        fases.add(new Fase(GRUPO_A, FASE_DE_GRUPOS));
        fases.add(new Fase(GRUPO_B, FASE_DE_GRUPOS));
        fases.add(new Fase(GRUPO_C, FASE_DE_GRUPOS));
        fases.add(new Fase(GRUPO_D, FASE_DE_GRUPOS));
        fases.add(new Fase(GRUPO_E, FASE_DE_GRUPOS));
        fases.add(new Fase(GRUPO_F, FASE_DE_GRUPOS));
        fases.add(new Fase(GRUPO_G, FASE_DE_GRUPOS));
        fases.add(new Fase(GRUPO_H, FASE_DE_GRUPOS));

        fases.add(new Fase(OCTAVOS_1, FASE_OCTAVOS_DE_FINAL));
        fases.add(new Fase(OCTAVOS_2, FASE_OCTAVOS_DE_FINAL));
        fases.add(new Fase(OCTAVOS_3, FASE_OCTAVOS_DE_FINAL));
        fases.add(new Fase(OCTAVOS_4, FASE_OCTAVOS_DE_FINAL));
        fases.add(new Fase(OCTAVOS_5, FASE_OCTAVOS_DE_FINAL));
        fases.add(new Fase(OCTAVOS_6, FASE_OCTAVOS_DE_FINAL));
        fases.add(new Fase(OCTAVOS_7, FASE_OCTAVOS_DE_FINAL));
        fases.add(new Fase(OCTAVOS_8, FASE_OCTAVOS_DE_FINAL));

        fases.add(new Fase(CUARTOS_1, FASE_CUARTOS_DE_FINAL));
        fases.add(new Fase(CUARTOS_2, FASE_CUARTOS_DE_FINAL));
        fases.add(new Fase(CUARTOS_3, FASE_CUARTOS_DE_FINAL));
        fases.add(new Fase(CUARTOS_4, FASE_CUARTOS_DE_FINAL));

        fases.add(new Fase(SEMIFINAL_1, FASE_SEMIFINAL));
        fases.add(new Fase(SEMIFINAL_2, FASE_SEMIFINAL));

        fases.add(new Fase(TERCER_PUESTO, FASE_TERCER_PUESTO));
        fases.add(new Fase(FINAL, FASE_FINAL));

        return fases;
    }

    private void guardarFasesEnBaseDeDatos(List<Fase> fases){
        for(Fase fase : fases){
            faseDao.create(fase);
        }
    }

    private List<Fase> mapearFases(){
        //Leo de la base de datos
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

        Fase faseTercerPuesto = faseDao.read(TERCER_PUESTO, FASE_TERCER_PUESTO);
        Fase partidoFinal = faseDao.read(FINAL, FASE_FINAL);

        //Mapeo fase de grupos
        grupoA.mapearSiguienteFaseParaPrimeroDeLaFase(octavos1, CONDICION_LOCAL);
        grupoA.mapearSiguienteFaseParaSegundoDeLaFase(octavos2, CONDICION_VISITANTE);

        grupoB.mapearSiguienteFaseParaPrimeroDeLaFase(octavos2, CONDICION_LOCAL);
        grupoB.mapearSiguienteFaseParaSegundoDeLaFase(octavos1, CONDICION_VISITANTE);

        grupoC.mapearSiguienteFaseParaPrimeroDeLaFase(octavos3, CONDICION_LOCAL);
        grupoC.mapearSiguienteFaseParaSegundoDeLaFase(octavos4, CONDICION_VISITANTE);

        grupoD.mapearSiguienteFaseParaPrimeroDeLaFase(octavos4, CONDICION_LOCAL);
        grupoD.mapearSiguienteFaseParaSegundoDeLaFase(octavos3, CONDICION_VISITANTE);

        grupoE.mapearSiguienteFaseParaPrimeroDeLaFase(octavos5, CONDICION_LOCAL);
        grupoE.mapearSiguienteFaseParaSegundoDeLaFase(octavos6, CONDICION_VISITANTE);

        grupoF.mapearSiguienteFaseParaPrimeroDeLaFase(octavos6, CONDICION_LOCAL);
        grupoF.mapearSiguienteFaseParaSegundoDeLaFase(octavos5, CONDICION_VISITANTE);

        grupoG.mapearSiguienteFaseParaPrimeroDeLaFase(octavos7, CONDICION_LOCAL);
        grupoG.mapearSiguienteFaseParaSegundoDeLaFase(octavos8, CONDICION_VISITANTE);

        grupoH.mapearSiguienteFaseParaPrimeroDeLaFase(octavos8, CONDICION_LOCAL);
        grupoH.mapearSiguienteFaseParaSegundoDeLaFase(octavos7, CONDICION_VISITANTE);

        //Mapeo de octavos
        octavos1.mapearSiguienteFaseParaPrimeroDeLaFase(cuartos1, CONDICION_LOCAL);
        octavos3.mapearSiguienteFaseParaPrimeroDeLaFase(cuartos1, CONDICION_VISITANTE);

        octavos2.mapearSiguienteFaseParaPrimeroDeLaFase(cuartos2, CONDICION_LOCAL);
        octavos4.mapearSiguienteFaseParaPrimeroDeLaFase(cuartos2, CONDICION_VISITANTE);

        octavos5.mapearSiguienteFaseParaPrimeroDeLaFase(cuartos3, CONDICION_LOCAL);
        octavos7.mapearSiguienteFaseParaPrimeroDeLaFase(cuartos3, CONDICION_VISITANTE);

        octavos6.mapearSiguienteFaseParaPrimeroDeLaFase(cuartos4, CONDICION_LOCAL);
        octavos8.mapearSiguienteFaseParaPrimeroDeLaFase(cuartos4, CONDICION_VISITANTE);

        //Mapeo de cuartos
        cuartos1.mapearSiguienteFaseParaPrimeroDeLaFase(semifinal1, CONDICION_LOCAL);
        cuartos3.mapearSiguienteFaseParaPrimeroDeLaFase(semifinal1, CONDICION_VISITANTE);

        cuartos2.mapearSiguienteFaseParaPrimeroDeLaFase(semifinal2, CONDICION_LOCAL);
        cuartos4.mapearSiguienteFaseParaPrimeroDeLaFase(semifinal2, CONDICION_VISITANTE);

        //Mapeo de semifinales
        semifinal1.mapearSiguienteFaseParaPrimeroDeLaFase(partidoFinal, CONDICION_LOCAL);
        semifinal2.mapearSiguienteFaseParaSegundoDeLaFase(partidoFinal, CONDICION_VISITANTE);

        semifinal1.mapearSiguienteFaseParaSegundoDeLaFase(faseTercerPuesto, CONDICION_LOCAL);
        semifinal2.mapearSiguienteFaseParaSegundoDeLaFase(faseTercerPuesto, CONDICION_VISITANTE);

        //Creo la lista que voy a devolver
        List<Fase> fasesMapeadas = new ArrayList<>();
        fasesMapeadas.add(grupoA);
        fasesMapeadas.add(grupoA);
        fasesMapeadas.add(grupoA);
        fasesMapeadas.add(grupoA);
        fasesMapeadas.add(grupoA);
        fasesMapeadas.add(grupoA);
        fasesMapeadas.add(grupoA);
        fasesMapeadas.add(grupoA);

        fasesMapeadas.add(octavos1);
        fasesMapeadas.add(octavos1);
        fasesMapeadas.add(octavos1);
        fasesMapeadas.add(octavos1);
        fasesMapeadas.add(octavos1);
        fasesMapeadas.add(octavos1);
        fasesMapeadas.add(octavos1);
        fasesMapeadas.add(octavos1);

        fasesMapeadas.add(cuartos1);
        fasesMapeadas.add(cuartos1);
        fasesMapeadas.add(cuartos1);
        fasesMapeadas.add(cuartos1);

        fasesMapeadas.add(semifinal1);
        fasesMapeadas.add(semifinal2);

        fasesMapeadas.add(faseTercerPuesto);
        fasesMapeadas.add(partidoFinal);

        //Devuelvo fases mapeadas
        return fasesMapeadas;
    }

    private void actualizarFasesEnBaseDeDatos(List<Fase> fases){
        for(Fase fase : fases){
            faseDao.update(fase);
        }
    }

    public Boolean verificarSiLaFaseEstaCompleta(Fase fase){
        List<Partido> partidosDeLaFase = partidoDao.consultarPartidosPorFase(fase);

        Boolean respuesta = true;

        for(Partido partido : partidosDeLaFase){
            respuesta &= partido.getJugado();
        }

        return respuesta;
    }
}

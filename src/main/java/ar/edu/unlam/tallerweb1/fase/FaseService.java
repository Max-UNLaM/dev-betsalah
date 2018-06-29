package ar.edu.unlam.tallerweb1.fase;

import ar.edu.unlam.tallerweb1.util.SalahProperties;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class FaseService{
    @Inject
    private FaseDao faseDao;

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

    public void cargar(){
        if(!fasesExistenEnBaseDeDatos()){
            List<Fase> fases = crearFases();
            guardarFasesEnBaseDeDatos(fases);
        }
    }

    private Boolean fasesExistenEnBaseDeDatos(){
        return !faseDao.list().isEmpty();
    }

    public Fase readFase(String nombre) {
        return faseDao.read(nombre);
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
}

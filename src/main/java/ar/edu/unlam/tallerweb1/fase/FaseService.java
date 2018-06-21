package ar.edu.unlam.tallerweb1.fase;

import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class FaseService{

    @Inject
    private FaseDao faseDao;

    public void cargar(){
        if(!fasesExistenEnBaseDeDatos()){
            List<Fase> fases = crearFases();
            guardarFasesEnBaseDeDatos(fases);
        }
    }

    private Boolean fasesExistenEnBaseDeDatos(){
        return !faseDao.list().isEmpty();
    }

    private List<Fase> crearFases(){
        List<Fase> fases = new ArrayList<>();

        fases.add(new Fase("Grupos", "Fase de grupos"));
        fases.add(new Fase("Eliminatoria", "Octavos de final"));
        fases.add(new Fase("Eliminatoria", "Cuartos de final"));
        fases.add(new Fase("Eliminatoria", "Semifinal"));
        fases.add(new Fase("Eliminatoria", "Partido por el tercer puesto"));
        fases.add(new Fase("Eliminatoria", "Final"));

        return fases;
    }

    private void guardarFasesEnBaseDeDatos(List<Fase> fases){
        for(Fase fase : fases){
            faseDao.create(fase);
        }
    }
}

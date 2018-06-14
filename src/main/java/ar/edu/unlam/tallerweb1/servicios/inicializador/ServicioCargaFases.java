package ar.edu.unlam.tallerweb1.servicios.inicializador;

import ar.edu.unlam.tallerweb1.dao.FaseDao;
import ar.edu.unlam.tallerweb1.modelo.Fase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioCargaFases {
    @Autowired
    private FaseDao faseDao;

    public void cargarFasesSiNoExisten(){
        if(!fasesExistenEnBaseDeDatos()){
            List<Fase> fases = crearFases();
            guardarFasesEnBaseDeDatos(fases);
        }
    }

    private Boolean fasesExistenEnBaseDeDatos(){
        return faseDao.obtenerTodasLasFases() != null;
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
            faseDao.guardarFaseEnBaseDeDatos(fase);
        }
    }
}

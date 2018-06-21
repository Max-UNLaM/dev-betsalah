package ar.edu.unlam.tallerweb1.preparacion;

import ar.edu.unlam.tallerweb1.equipo.EquipoService;
import ar.edu.unlam.tallerweb1.fase.FaseService;
import ar.edu.unlam.tallerweb1.jugador.JugadorService;
import ar.edu.unlam.tallerweb1.partido.PartidoService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Service
public class PreparacionService{

    @Inject
    private FaseService faseService;

    @Inject
    private EquipoService equipoService;

    @Inject
    private PartidoService partidoService;

    @Inject
    private JugadorService jugadorService;

    public PreparacionService(){

    }

    @PostConstruct
    public void cargar(){
        faseService.cargar();
        equipoService.cargar();
        partidoService.cargar();
        //jugadorService.cargar();
    }
}

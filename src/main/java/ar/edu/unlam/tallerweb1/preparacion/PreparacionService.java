package ar.edu.unlam.tallerweb1.preparacion;

import ar.edu.unlam.tallerweb1.equipo.EquipoService;
import ar.edu.unlam.tallerweb1.fase.FaseService;
import ar.edu.unlam.tallerweb1.jugador.JugadorService;
import ar.edu.unlam.tallerweb1.partido.PartidoService;
import ar.edu.unlam.tallerweb1.service.CargaService;
import ar.edu.unlam.tallerweb1.usuario.UsuarioServicio;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Service
public class PreparacionService implements CargaService {

    @Inject
    private FaseService faseService;

    @Inject
    private EquipoService equipoService;

    @Inject
    private PartidoService partidoService;

    @Inject
    private JugadorService jugadorService;

    @Inject
    private UsuarioServicio usuarioServicio;


    public PreparacionService(){

    }

    @PostConstruct
    public void cargar(){
        faseService.cargar();
        equipoService.cargar();
        partidoService.cargar();
        jugadorService.cargar();
        usuarioServicio.cargar();
    }
}

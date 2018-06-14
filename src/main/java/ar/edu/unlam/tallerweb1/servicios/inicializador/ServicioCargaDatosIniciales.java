package ar.edu.unlam.tallerweb1.servicios.inicializador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioCargaDatosIniciales {
    @Autowired
    private ServicioCargaFases servicioCargaFases;
    @Autowired
    private ServicioCargaEquipos servicioCargaEquipos;
    @Autowired
    private ServicioCargaPartidos servicioCargaPartidos;
    @Autowired
    private ServicioCargaJugadores servicioCargaJugadores;

    public ServicioCargaDatosIniciales(){
        this.cargarDatosSiNoExisten();
    }

    public void cargarDatosSiNoExisten(){
        servicioCargaFases.cargarFasesSiNoExisten();
        servicioCargaEquipos.cargarEquiposSiNoExisten();
        servicioCargaPartidos.cargarPartidosSiNoExisten();
        servicioCargaJugadores.cargarJugadoresSiNoExisten();
    }
}

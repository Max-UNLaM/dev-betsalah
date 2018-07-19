package ar.edu.unlam.tallerweb1.simulacion;

import ar.edu.unlam.tallerweb1.partido.Partido;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

public class SimulacionServiceTest {
    SimulacionService simulacionService;

    Partido partidoJugado;
    Partido partidoNoJugado;

    @Before
    public void setUp(){
        simulacionService = new SimulacionService();

        partidoJugado = new Partido();
        partidoJugado.setJugado(true);

        partidoNoJugado = new Partido();
    }

    @Test(expected = IllegalArgumentException.class)
    @Transactional
    @Rollback
    public void alIntentarJugarUnPartidoQueYaFueJugadoSeEsperaUnaExcepcion(){
        simulacionService.jugarPartido(partidoJugado, 2, 0, 1L);
    }

    @Test(expected = IllegalArgumentException.class)
    @Transactional
    @Rollback
    public void alEnviarFiguraIdNullSeEsperaUnaExcepcion(){
        simulacionService.jugarPartido(partidoNoJugado, 2, 0, null);
    }
}

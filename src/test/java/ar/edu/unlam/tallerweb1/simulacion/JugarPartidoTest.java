package ar.edu.unlam.tallerweb1.simulacion;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.apuesta.Apuesta;
import ar.edu.unlam.tallerweb1.equipo.Equipo;
import ar.edu.unlam.tallerweb1.fase.Fase;
import ar.edu.unlam.tallerweb1.partido.Partido;
import ar.edu.unlam.tallerweb1.usuario.Usuario;
import ar.edu.unlam.tallerweb1.usuario.UsuarioDao;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.*;

import javax.inject.Inject;

public class JugarPartidoTest extends SpringTest {

    Apuesta apuesta;
    Partido partido;
    Usuario usuario;

    @Inject
    SimulacionService simulacionService;

    @Inject
    UsuarioDao usuarioDao;

    @Before
    @Transactional
    @Test
    public void preCarga() {
        usuario = new Usuario("test@test.com", "test", "123", 0);
        Equipo local = new Equipo("Local", "TST", "A", 1);
        Equipo visitante = new Equipo("Visitante", "TST", "A", 1);
        Fase fase = new Fase("grupo", "A");
        partido = new Partido(local, visitante, fase);
        apuesta = new Apuesta(usuario, partido, 1, 2);
        getSession().save(usuario);
        getSession().save(local);
        getSession().save(visitante);
        getSession().save(fase);
        getSession().save(partido);
        getSession().save(apuesta);

    }


    @Test
    @Transactional
    @Rollback
    public void acertarUnResultadoSumaPuntos() {
        this.simulacionService.jugarPartido(partido, 1, 2);
        assertThat(usuarioDao.read(usuario.getId()).getPuntaje()).isEqualTo(1);
    }

}

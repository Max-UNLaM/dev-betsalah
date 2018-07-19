package ar.edu.unlam.tallerweb1.juego;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.apuesta.Apuesta;
import ar.edu.unlam.tallerweb1.equipo.Equipo;
import ar.edu.unlam.tallerweb1.fase.Fase;
import ar.edu.unlam.tallerweb1.partido.Partido;
import ar.edu.unlam.tallerweb1.simulacion.SimulacionService;
import ar.edu.unlam.tallerweb1.usuario.Usuario;
import ar.edu.unlam.tallerweb1.usuario.UsuarioDao;
import ar.edu.unlam.tallerweb1.util.Roles;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.*;

import javax.inject.Inject;

public class JugarPartido extends SpringTest {

    private Apuesta apuesta;
    private Partido partido;
    private Usuario usuario;

    @Inject
    private SimulacionService simulacionService;

    @Inject
    private UsuarioDao usuarioDao;

    @Before
    @Transactional
    public void preCarga() {
        usuario = new Usuario("test", "123", 0, Roles.ROL_USUARIO.toString());
        Equipo local = new Equipo("Local", "TST");
        Equipo visitante = new Equipo("Visitante", "TST");
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
        this.simulacionService.jugarPartido(partido, 1, 2, 7L);
        assertThat(usuarioDao.read(usuario.getId()).getPuntaje()).isEqualTo(1);
    }

}

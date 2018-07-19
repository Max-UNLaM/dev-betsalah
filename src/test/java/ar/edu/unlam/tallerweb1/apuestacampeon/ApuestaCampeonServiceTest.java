package ar.edu.unlam.tallerweb1idEquipoLocal.apuestacampeon;

import ar.edu.unlam.tallerweb1.apuestacampeon.ApuestaCampeonDao;
import ar.edu.unlam.tallerweb1.apuestacampeon.ApuestaCampeonService;
import ar.edu.unlam.tallerweb1.equipo.Equipo;
import ar.edu.unlam.tallerweb1.equipo.EquipoDao;
import ar.edu.unlam.tallerweb1.fase.FaseDao;
import ar.edu.unlam.tallerweb1.partido.PartidoDao;
import ar.edu.unlam.tallerweb1.partido.PartidoService;
import ar.edu.unlam.tallerweb1.usuario.Usuario;
import ar.edu.unlam.tallerweb1.usuario.UsuarioDao;
import ar.edu.unlam.tallerweb1.util.Roles;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.mockito.Matchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ApuestaCampeonServiceTest {
    private ApuestaCampeonService apuestaCampeonService;

    private ApuestaCampeonDao apuestaCampeonDao;
    private EquipoDao equipoDao;
    private UsuarioDao usuarioDao;
    private FaseDao faseDao;
    private PartidoDao partidoDao;
    private PartidoService partidoService;

    Usuario usuario1;
    Equipo equipo1;

    @Before
    public void setUp(){
        usuario1 = new Usuario("Usuario 1", "123456", 0, Roles.ROL_USUARIO.toString());
        usuario1.setId(1L);

        equipo1 = new Equipo("Equipo Test", "EQT");
        equipo1.setId(1L);

        apuestaCampeonService = new ApuestaCampeonService();

        //ApuestaCampeonDao
        apuestaCampeonDao = mock(ApuestaCampeonDao.class);

        apuestaCampeonService.setApuestaCampeonDao(apuestaCampeonDao);

        //EquipoDao
        equipoDao = mock(EquipoDao.class);

        when(equipoDao.read((Long) isNull()))
                .thenReturn(null);
        when(equipoDao.read(1L))
                .thenReturn(equipo1);

        apuestaCampeonService.setEquipoDao(equipoDao);

        //UsuarioDao
        usuarioDao = mock(UsuarioDao.class);

        when(usuarioDao.read((Long) isNull()))
                .thenReturn(null);
        when(usuarioDao.read(1L))
                .thenReturn(usuario1);

        apuestaCampeonService.setUsuarioDao(usuarioDao);

        //FaseDao
        faseDao = mock(FaseDao.class);

        apuestaCampeonService.setFaseDao(faseDao);

        //PartidoDao
        partidoDao = mock(PartidoDao.class);

        apuestaCampeonService.setPartidoDao(partidoDao);

        //PartidoService
        partidoService = mock(PartidoService.class);

        apuestaCampeonService.setPartidoService(partidoService);
    }

    @Test(expected = IllegalArgumentException.class)
    @Transactional
    @Rollback
    public void alApostarConUsuarioIdNullSeEsperaExcepcion(){
        apuestaCampeonService.apostarCampeon(null, 1L);
    }

    @Test(expected = IllegalArgumentException.class)
    @Transactional
    @Rollback
    public void alApostarConEquipoIdNullSeEsperaExcepcion(){
        apuestaCampeonService.apostarCampeon(1L, null);
    }

    @Test(expected = IllegalArgumentException.class)
    @Transactional
    @Rollback
    public void alIntentarApostarConAlMenosUnPartidoJugadoSeEsperaExcepcion(){
        when(partidoService.alMenosUnPartidoFueJugado())
                .thenReturn(true);

        apuestaCampeonService.apostarCampeon(1L, 1L);
    }

    @Test
    @Transactional
    @Rollback
    public void alNoEncontrarApuestaDeCampeonParaUnUsuarioCreaUnaNueva(){
        when(apuestaCampeonDao.obtenerApuestaCampeon(1L))
                .thenReturn(null);

        apuestaCampeonService.apostarCampeon(1L, 1L);
    }



}

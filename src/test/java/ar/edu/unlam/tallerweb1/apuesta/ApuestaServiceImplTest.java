package ar.edu.unlam.tallerweb1.apuesta;

import ar.edu.unlam.tallerweb1.fase.Fase;
import ar.edu.unlam.tallerweb1.jugador.JugadorDao;
import ar.edu.unlam.tallerweb1.partido.Partido;
import ar.edu.unlam.tallerweb1.partido.PartidoDao;
import ar.edu.unlam.tallerweb1.usuario.Usuario;
import ar.edu.unlam.tallerweb1.usuario.UsuarioDao;
import ar.edu.unlam.tallerweb1.util.Fases;
import ar.edu.unlam.tallerweb1.util.Instancias;
import ar.edu.unlam.tallerweb1.util.Roles;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ApuestaServiceImplTest {
    private ApuestaServiceImpl apuestaService;

    private UsuarioDao usuarioDaoMock;
    private PartidoDao partidoDaoMock;
    private ApuestaDao apuestaDaoMock;
    private JugadorDao jugadorDaoMock;

    @Before
    public void setUp(){
        apuestaService = new ApuestaServiceImpl();

        //UsuarioDao
        usuarioDaoMock = mock(UsuarioDao.class);
        when(usuarioDaoMock.read((Long) isNull())).thenReturn(null);
        Usuario usuario1 = new Usuario("User1", "pass", 0, Roles.ROL_USUARIO.toString());
        when(usuarioDaoMock.read(1L)).thenReturn(usuario1);
        apuestaService.setUsuarioDao(usuarioDaoMock);

        //PartidoDao
        partidoDaoMock = mock(PartidoDao.class);
        Fase grupoAFaseDeGrupos = new Fase(Instancias.GRUPO_A.toString(), Fases.FASE_DE_GRUPOS.toString());
        Fase grupoBFaseDeGrupos = new Fase(Instancias.GRUPO_B.toString(), Fases.FASE_DE_GRUPOS.toString());
        Partido partido1 = new Partido(null, null, grupoAFaseDeGrupos);
        Partido partido2 = new Partido(null, null, grupoAFaseDeGrupos);
        Partido partido3 = new Partido(null, null, grupoBFaseDeGrupos);
        Partido partido4 = new Partido(null, null, grupoBFaseDeGrupos);
        List<Partido> partidosFaseDeGrupos = new ArrayList<>();
        partidosFaseDeGrupos.add(partido1);
        partidosFaseDeGrupos.add(partido2);
        partidosFaseDeGrupos.add(partido3);
        partidosFaseDeGrupos.add(partido4);

        when(partidoDaoMock.consultarPartidosPorFase(Fases.FASE_DE_GRUPOS.toString())).thenReturn(partidosFaseDeGrupos);
        when(partidoDaoMock.consultarPartidosPorFase(Fases.FASE_DE_GRUPOS.toString())).thenReturn(partidosFaseDeGrupos);
        apuestaService.setPartidoDao(partidoDaoMock);

        //ApuestaDao
        apuestaDaoMock = mock(ApuestaDao.class);
        List<Apuesta> apuestasFaseDeGrupos = new ArrayList<>();
        apuestasFaseDeGrupos.add(new Apuesta(usuario1, partido1, 0, 0));
        apuestasFaseDeGrupos.add(new Apuesta(usuario1, partido2, 0, 0));
        apuestasFaseDeGrupos.add(new Apuesta(usuario1, partido3, 0, 0));
        apuestasFaseDeGrupos.add(new Apuesta(usuario1, partido4, 0, 0));

        when(apuestaDaoMock.crearApuestasParaUsuario(usuario1, partidosFaseDeGrupos)).thenReturn(apuestasFaseDeGrupos);

        apuestaService.setApuestaDao(apuestaDaoMock);

        //JugadorDao
        jugadorDaoMock = mock(JugadorDao.class);
        apuestaService.setJugadorDao(jugadorDaoMock);
    }

    @Test(expected = IllegalArgumentException.class)
    @Transactional
    @Rollback()
    public void alEnviarUsuarioNullSeEsperaExcepcion(){
        apuestaService.obtenerModeloPorFase(any(String.class), null);
    }

    @Test
    @Transactional
    @Rollback
    public void alEnviarFaseNullSeEsperaQueDevuelvaFaseGruposComoFaseDefault(){
        ModelMap modelo = apuestaService.obtenerModeloPorFase(null, 1L);
        assert(modelo.get("fase").equals(Fases.FASE_DE_GRUPOS.toString()));
    }

    @Test
    @Transactional
    @Rollback
    public void alEnviarUnaFaseInvalidaSeEsperaQueDevuelvaFaseGruposComoFaseDefault(){
        ModelMap modelo = apuestaService.obtenerModeloPorFase("dakjifasuasidaiugadiqdgiuqd", 1L);
        assert(modelo.get("fase").equals(Fases.FASE_DE_GRUPOS.toString()));
    }
    
    @Test
    @Transactional
    @Rollback
    public void alEnviarApuestasNullSeEsperaQueCreeLasApuestas() {
    	List<Apuesta> apuestas = new ArrayList<>();
    	List<Partido> partidosFaseDeGrupos = new ArrayList<>();
    	Usuario usuario1 = usuarioDaoMock.read(1L);
    	partidosFaseDeGrupos = partidoDaoMock.consultarPartidosPorFase(Fases.FASE_DE_GRUPOS.toString());
    	apuestas = apuestaService.obtenerApuestasParaUsuario(usuario1 , Fases.FASE_DE_GRUPOS.toString(), partidosFaseDeGrupos);
    	assertThat(apuestas.size()).isGreaterThanOrEqualTo(1);
    }
    
    
}

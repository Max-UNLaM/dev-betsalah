package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.usuario.Usuario;
import ar.edu.unlam.tallerweb1.usuario.UsuarioDao;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.*;

import javax.inject.Inject;

public class UsuarioDaoTest extends SpringTest {
    @Inject
    UsuarioDao usuarioDao;

    Usuario usuarioOrigen;

    @Before
    public void cargarDatos() {
        this.usuarioOrigen = new Usuario("test", "testnombre", "testpass", 0);
        usuarioDao.create(usuarioOrigen);
    }

    @Test
    @Transactional
    @Rollback
    public void crearUsuario() {
        usuarioDao.create(usuarioOrigen);
        Usuario usuarioDos = usuarioDao.read(usuarioOrigen.getId());
        assertThat(usuarioOrigen.getNombre()).isEqualTo(usuarioDao.read(usuarioOrigen.getId()).getNombre());
        assertThat(usuarioOrigen.getEmail()).isEqualTo(usuarioDos.getEmail());
        assertThat(usuarioOrigen.getPuntaje()).isEqualTo(usuarioDos.getPuntaje());
        // assertThat(usuario.getNombre()).isEqualTo(usuarioDos.getNombre());
    }

    @Test
    @Rollback
    @Transactional
    public void updateUsuario() {
        Usuario usuarioDos = usuarioDao.read(usuarioOrigen.getId());
        usuarioDos.setNombre("jorge");
        System.out.println(usuarioDos.getNombre());
        System.out.println(usuarioDos.getId());
        System.out.println(usuarioOrigen.getId());
        System.out.println(usuarioOrigen.getNombre());
        System.out.println(usuarioDos.getNombre());
        usuarioDao.create(usuarioDos);
        Usuario usuarioTres = usuarioDao.read(usuarioOrigen.getId());
        assertThat(usuarioDao.read(usuarioTres.getId()).getNombre()).isEqualTo("jorge");
    }

}

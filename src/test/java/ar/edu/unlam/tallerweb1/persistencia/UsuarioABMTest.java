package ar.edu.unlam.tallerweb1.persistencia;
import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.dao.Crud;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class UsuarioABMTest extends SpringTest {

    @Inject
    private Crud usuarioDao;

    @Before
    @Transactional
    @Rollback
    public void preCarga(){
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Usuario Un0", "awfwafa"));
        usuarios.add(new Usuario("Usuario Dos", "fwafwaf"));
        usuarios.add(new Usuario("Usuario Tres", "fwafwaf"));
        usuarios.add(new Usuario("Usuario Cuatro", "fwafwaf"));
        for (Usuario usuario: usuarios) {
            getSession().save(usuario);
        }
    }

    @Test
    @Transactional
    @Rollback
    public void listarUsuario(){
        List<Usuario> usuarios = usuarioDao.list();
        assertThat(recorrerLista(usuarios)).isTrue();
    }

    protected boolean recorrerLista(List<Usuario> usuarios) {
        for (Usuario usuario: usuarios) {
            return usuario.getClass() == Usuario.class;
        }
        return false;
    }

}

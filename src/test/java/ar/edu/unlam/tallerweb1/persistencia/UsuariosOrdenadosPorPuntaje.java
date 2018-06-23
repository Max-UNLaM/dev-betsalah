package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Java6Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import ar.edu.unlam.tallerweb1.usuario.UsuarioDao;
import org.hibernate.Session;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.usuario.Usuario;
import ar.edu.unlam.tallerweb1.usuario.UsuarioServicio;

public class UsuariosOrdenadosPorPuntaje extends SpringTest {
	@Inject
	private UsuarioServicio usuarioServicio;

	@Inject
	private UsuarioDao usuarioDao;

	@Test
    @Transactional 
    @Rollback
    public void pruebaDeOrdenamiento(){
		Usuario usuario1 = new Usuario("prueba1@hotmail.com", "Carlos", "password1", 500);
		Usuario usuario2 = new Usuario("prueba2@hotmail.com", "Saul", "password2", 430);
		usuarioDao.create(usuario1);
		usuarioDao.create(usuario2);
		List<Usuario> Lista = new ArrayList<>();
		Lista = usuarioServicio.generarTabla("puntaje");
		assertThat(Lista.size()).isEqualTo(2);
		
	}
}

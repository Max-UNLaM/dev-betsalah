package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Java6Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

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
	
	@Test
    @Transactional 
    @Rollback
    public void pruebaDeOrdenamiento(){
		
		
		
		Session session = this.getSession();
		Usuario usuario1 = new Usuario("prueba1@hotmail.com", "Carlos", "password1", 500);
		Usuario usuario2 = new Usuario("prueba2@hotmail.com", "Saul", "password2", 430);
		
		session.save(usuario1);
		session.save(usuario2);
		
		List<Usuario> Lista = new ArrayList<>();
		
		
		Lista = usuarioServicio.generarTabla("puntaje");
		
		assertThat(Lista.size()).isEqualTo(2);
		
	}
}

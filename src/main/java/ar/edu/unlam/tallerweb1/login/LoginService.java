package ar.edu.unlam.tallerweb1.login;

import javax.inject.Inject;

import ar.edu.unlam.tallerweb1.usuario.Usuario;
import ar.edu.unlam.tallerweb1.usuario.UsuarioDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


// Implelemtacion del Servicio de usuarios, la anotacion @Service indica a Spring que esta clase es un componente que debe
// ser manejado por el framework, debe indicarse en applicationContext que busque en el paquete ar.edu.unlam.tallerweb1.servicios
// para encontrar esta clase.
// La anotacion @Transactional indica que se debe iniciar una transaccion de base de datos ante la invocacion de cada metodo del servicio,
// dicha transaccion esta asociada al transaction manager definido en el archivo spring-servlet.xml y el mismo asociado al session factory definido
// en hibernateCOntext.xml. De esta manera todos los metodos de cualquier dao invocados dentro de un servicio se ejecutan en la misma transaccion
@Service("servicioLogin")
@Transactional
public class LoginService{
	@Inject
	private UsuarioDao usuarioDao;

	public Usuario consultarUsuario (Usuario usuario) {
		return usuarioDao.consultarUsuario(usuario);
	}

	public Usuario consultarUsuario (String nombreUsuario) {
		return usuarioDao.consultarUsuario(nombreUsuario);
	}

	public void crearUsuario(Usuario usuario){
		usuarioDao.create(usuario);
	}

}

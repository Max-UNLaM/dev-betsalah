package ar.edu.unlam.tallerweb1.usuario;

import java.util.List;

import javax.inject.Inject;

import ar.edu.unlam.tallerweb1.util.SalahProperties;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

@Service
public class UsuarioServicio {
	@Inject
	private UsuarioDao usuarioDao;
	
	public List<Usuario>generarTabla(String columna)
	{
		return this.usuarioDao.orderBy(columna);
	}
	
	public List<Usuario>GenerarTabla(){
		return this.usuarioDao.list();
	}

	public Usuario read(Long usuarioId) { return usuarioDao.read(usuarioId); }

	public ModelMap obtenerModeloParaAdministrarUsuario(Usuario usuario){
		ModelMap modelo = new ModelMap();

		List<Usuario> usuarios = usuarioDao.list();

		modelo.put("sesion", true);
		modelo.put("usuario", usuario);
		modelo.put("usuarios", usuarios);

		return modelo;
	}

	public void hacerAdmin(Long usuarioId){
		Usuario usuario = usuarioDao.read(usuarioId);

		usuario.setRol(SalahProperties.ROL_ADMIN);

		usuarioDao.update(usuario);
	}
}

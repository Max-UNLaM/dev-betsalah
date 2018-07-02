package ar.edu.unlam.tallerweb1.usuario;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

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
}

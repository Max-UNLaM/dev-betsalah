package ar.edu.unlam.tallerweb1.usuario;
import org.springframework.stereotype.Repository;

// Interface que define los metodos del DAO de Usuarios.
@Repository("usuarioDao")
public interface UsuarioDao {
	
	Usuario consultarUsuario (Usuario usuario);
}

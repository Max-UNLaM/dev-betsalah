package ar.edu.unlam.tallerweb1.usuario;
import ar.edu.unlam.tallerweb1.dao.Dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

// Interface que define los metodos del DAO de Usuarios.
@Repository
public class UsuarioDao extends Dao implements UsuarioCrud{
	@SuppressWarnings("unchecked")
	public List<Usuario> list() {
		return session.createCriteria(Usuario.class)
				.list();
	}

	public Usuario update(Usuario usuario) {
		session.update(usuario);
		return usuario;
	}

	public Usuario read(Long id) {
		return session.get(Usuario.class, id);
	}

	public Usuario read(String nombre) {
		return (Usuario)session.createCriteria(Usuario.class)
				.add(Restrictions.eq("nombre", nombre))
				.uniqueResult();
	}

	public Usuario create (Usuario usuario) {
		session.save(usuario);
		return usuario;
	}
}

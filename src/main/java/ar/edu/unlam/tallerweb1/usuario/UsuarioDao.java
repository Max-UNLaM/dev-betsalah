package ar.edu.unlam.tallerweb1.usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

// Interface que define los metodos del DAO de Usuarios.
@Repository
public class UsuarioDao implements UsuarioCrud{
	@Inject
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Usuario> list() {
		final Session sesion = sessionFactory.getCurrentSession();
		return sesion.createCriteria(Usuario.class)
				.list();
	}

	public Usuario update(Usuario usuario) {
		final Session sesion = sessionFactory.getCurrentSession();
		sesion.update(usuario);
		return usuario;
	}

	public Usuario read(Long id) {
		final Session sesion = sessionFactory.getCurrentSession();
		return sesion.get(Usuario.class, id);
	}

	public Usuario read(String nombre) {
		final Session sesion = sessionFactory.getCurrentSession();
		return (Usuario)sesion.createCriteria(Usuario.class)
				.add(Restrictions.eq("nombre", nombre))
				.uniqueResult();
	}

	public Usuario create (Usuario usuario) {
		final Session sesion = sessionFactory.getCurrentSession();
		sesion.save(usuario);
		return usuario;
	}
}

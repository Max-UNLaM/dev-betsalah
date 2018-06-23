package ar.edu.unlam.tallerweb1.usuario;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


import javax.inject.Inject;
import java.util.List;

// Interface que define los metodos del DAO de Usuarios.
@Repository
public class UsuarioDao implements UsuarioCrud, UsuarioOrder{
	@Inject
	private SessionFactory sessionFactory;
	
	
	@SuppressWarnings("unchecked")
	public List<Usuario> list() {
		final Session sesion = sessionFactory.openSession();
		return sesion.createCriteria(Usuario.class)
				.list();
	}
	@SuppressWarnings("unchecked")
	public List<Usuario> orderBy(String columna){
		final Session sesion = sessionFactory.openSession();
		return sesion.createCriteria(Usuario.class)
				.addOrder(Order.desc(columna))
				.list();
	}
	
	public Usuario update(Usuario usuario) {
		final Session sesion = sessionFactory.openSession();
		sesion.save(usuario);
		return usuario;
	}

	public Usuario read(Long id) {
		final Session sesion = sessionFactory.openSession();
		return sesion.get(Usuario.class, id);
	}

	public Usuario read(String nombre) {
		final Session sesion = sessionFactory.openSession();
		return (Usuario)sesion.createCriteria(Usuario.class)
				.add(Restrictions.eq("nombre", nombre))
				.uniqueResult();
	}

	public Usuario create (Usuario usuario) {
		final Session sesion = sessionFactory.openSession();
		sesion.save(usuario);
		return usuario;
	}
}

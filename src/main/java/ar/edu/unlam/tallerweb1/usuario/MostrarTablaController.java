package ar.edu.unlam.tallerweb1.usuario;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MostrarTablaController {
	
	@Inject
	private UsuarioServicio usuarioServicio;
	@Inject
	private UsuarioDao usuarioDao;
	
	@RequestMapping("/tabla-posiciones")
	public ModelAndView MostrarTabla(HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		List<Usuario> usuarios = usuarioServicio.generarTabla("puntaje");

		Long usuarioId = (Long) request.getSession().getAttribute("USER-ID");

		if(usuarioId == null){
			return new ModelAndView("redirect:/cerrar-sesion");
		} else {
			Usuario usuario = usuarioDao.read(usuarioId);

			modelo.put("sesion", true);
			modelo.put("usuario", usuario);
			modelo.put("usuarios", usuarios);
			return new ModelAndView("tablaPosiciones", modelo);
		}

	}
}


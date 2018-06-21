package ar.edu.unlam.tallerweb1.usuario;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MostrarTablaController {
	
	@Inject
	private UsuarioServicio usuarioServicio;
	
	@RequestMapping("/TablaPosiciones")
	public ModelAndView MostrarTabla() {
		ModelMap modelo = new ModelMap();
		List<Usuario> usuarios = usuarioServicio.generarTabla("puntaje");
				
		
		modelo.put("usuarios", usuarios);
		return new ModelAndView("tablaPosiciones", modelo);
	}
}


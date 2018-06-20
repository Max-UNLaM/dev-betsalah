package ar.edu.unlam.tallerweb1.usuario;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MostrarTablaController {

	@RequestMapping("/TablaPosiciones")
	public ModelAndView MostrarTabla() {
		ModelMap modelo = new ModelMap();
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario usuario1 = new Usuario("prueba1@hotmail.com", "Carlos", "password1", 500);
		Usuario usuario2 = new Usuario("prueba2@hotmail.com", "Saul", "password2", 430);
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		modelo.put("usuarios", usuarios);
		return new ModelAndView("tablaPosiciones", modelo);
	}
}

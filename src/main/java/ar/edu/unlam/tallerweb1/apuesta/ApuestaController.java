package ar.edu.unlam.tallerweb1.apuesta;

import ar.edu.unlam.tallerweb1.usuario.Usuario;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ApuestaController {
    @Inject
    private ApuestaService apuestaService;

    @RequestMapping("/apuesta/primera-fase")
    @ResponseBody
    public ModelAndView cargarApuestasPrimeraFase(){

        ModelMap modelo = apuestaService.obtenerModeloPrimeraFase();

        return new ModelAndView("apuestas-primera-fase", modelo);
    }

    @RequestMapping(value = "/apuesta/actualizar-apuestas-primera-fase", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView actualizarApuestasPrimeraFase(@ModelAttribute("usuario") Usuario usuario, @ModelAttribute("list") ArrayList<Apuesta> apuestas, HttpServletRequest request){
        ModelMap modelo = new ModelMap();
        modelo.put("usuario", usuario);
        modelo.put("apuestas", apuestas);
        return new ModelAndView("apuestas-primera-fase", modelo);
    }
}

package ar.edu.unlam.tallerweb1.apuesta;

import ar.edu.unlam.tallerweb1.preparacion.PreparacionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;

@Controller
public class ApuestaController {
    @Inject
    private ApuestaService apuestaService;

    @RequestMapping("/asd")
    @ResponseBody
    public void asd(){
        PreparacionService preparacionService = new PreparacionService();
        preparacionService.cargar();
    }

    @RequestMapping("/apuesta/primera-fase")
    @ResponseBody
    public ModelAndView cargarApuestasPrimeraFase(){

        ModelMap modelo = apuestaService.obtenerModeloPrimeraFase();

        return new ModelAndView("apuestas-primera-fase", modelo);
    }
}

package ar.edu.unlam.tallerweb1.usuario;

import ar.edu.unlam.tallerweb1.util.Roles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@Controller
public class UsuarioController {
    @Inject
    private UsuarioServicio usuarioServicio;

    @RequestMapping(value = "/usuario/administrar-usuarios", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ModelAndView administrarUsuarios(HttpServletRequest request){

        Long idAdminActual = (Long) request.getSession().getAttribute("USER-ID");
        String rol = (String) request.getSession().getAttribute("ROL");
        Usuario usuario = usuarioServicio.read(idAdminActual);

        if(idAdminActual == null
                || rol == null
                || usuario == null
                || !usuario.getRol().equals(Roles.ROL_ADMIN.toString())){
            return new ModelAndView("redirect:/cerrar-sesion");
        } else {
            ModelMap modelo = usuarioServicio.obtenerModeloParaAdministrarUsuario(usuario);

            return new ModelAndView("administrar-usuarios", modelo);
        }
    }

    @RequestMapping(value = "/usuario/hacer-admin", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ModelAndView hacerAdmin(@RequestParam Long idNuevoAdmin,
                            HttpServletRequest request){

        Long idAdminActual = (Long) request.getSession().getAttribute("USER-ID");
        String rol = (String) request.getSession().getAttribute("ROL");
        Usuario usuario = usuarioServicio.read(idAdminActual);

        if(idAdminActual == null
            || rol == null
            || usuario == null
            || !usuario.getRol().equals(Roles.ROL_ADMIN.toString())){
                return new ModelAndView("redirect:/cerrar-sesion");
        } else {
            usuarioServicio.hacerAdmin(idNuevoAdmin);
            return this.administrarUsuarios(request);
        }
    }
}

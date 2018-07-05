package ar.edu.unlam.tallerweb1.apuestacampeon;

import ar.edu.unlam.tallerweb1.equipo.Equipo;
import ar.edu.unlam.tallerweb1.equipo.EquipoDao;
import ar.edu.unlam.tallerweb1.usuario.Usuario;
import ar.edu.unlam.tallerweb1.usuario.UsuarioDao;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import javax.inject.Inject;
import java.util.List;

@Service
public class ApuestaCampeonService {
    @Inject
    private ApuestaCampeonDao apuestaCampeonDao;
    @Inject
    private EquipoDao equipoDao;
    @Inject
    private UsuarioDao usuarioDao;

    public ModelMap obtenerModelo(){
        ModelMap modelo = new ModelMap();

        //El usuario que estoy creando aca en realidad seria el usuario que esta logueado
        Usuario usuario = usuarioDao.read("daniel.marconi");
        if(usuario == null){
            usuario = new Usuario("daniel.marconi@gmail.com", "daniel.marconi", "123456", 0);
            usuarioDao.create(usuario);
        }

        ApuestaCampeon apuestaCampeon = apuestaCampeonDao.obtenerApuestaCampeon(usuario.getId());
        if(apuestaCampeon == null) apuestaCampeon = new ApuestaCampeon(usuario);

        List<Equipo> equipos = equipoDao.list();

        modelo.put("usuario", usuario);
        modelo.put("equipos", equipos);
        modelo.put("apuestaCampeon", apuestaCampeon);

        return modelo;
    }

    public void apostarCampeon(Long apostadorId, Long equipoId){
        //El usuario que estoy creando aca en realidad seria el usuario del cual estamos recibiendo el ID
        Usuario usuario = usuarioDao.read("daniel.marconi"); //aca deberia leer por id
        if(usuario == null){//si el usuario no existe debo tirar una excepcion
            usuario = new Usuario("daniel.marconi@gmail.com", "daniel.marconi", "123456", 0);
            usuarioDao.create(usuario);
        }

        Equipo equipoApostado = equipoDao.read(equipoId);
        if(equipoApostado == null) throw new IllegalArgumentException("Equipo inválido");

        ApuestaCampeon apuestaCampeon = apuestaCampeonDao.obtenerApuestaCampeon(apostadorId);
        if(apuestaCampeon == null) apuestaCampeon = new ApuestaCampeon(usuario);
        if(apuestaCampeon.getEquipoApostado() == null){
            apuestaCampeon.setEquipoApostado(equipoApostado);
            apuestaCampeonDao.save(apuestaCampeon);
        } else {
            throw new IllegalArgumentException("No se puede cambiar la apuesta de equipo campeón");
        }
    }
}
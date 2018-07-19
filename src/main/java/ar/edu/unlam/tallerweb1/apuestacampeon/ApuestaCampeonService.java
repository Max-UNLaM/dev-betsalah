package ar.edu.unlam.tallerweb1.apuestacampeon;

import ar.edu.unlam.tallerweb1.equipo.Equipo;
import ar.edu.unlam.tallerweb1.equipo.EquipoDao;
import ar.edu.unlam.tallerweb1.fase.Fase;
import ar.edu.unlam.tallerweb1.fase.FaseDao;
import ar.edu.unlam.tallerweb1.partido.Partido;
import ar.edu.unlam.tallerweb1.partido.PartidoDao;
import ar.edu.unlam.tallerweb1.partido.PartidoService;
import ar.edu.unlam.tallerweb1.usuario.Usuario;
import ar.edu.unlam.tallerweb1.usuario.UsuarioDao;
import ar.edu.unlam.tallerweb1.util.Fases;
import ar.edu.unlam.tallerweb1.util.Instancias;
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
    @Inject
    private FaseDao faseDao;
    @Inject
    private PartidoDao partidoDao;
    @Inject
    private PartidoService partidoService;

    public ModelMap obtenerModelo(Long usuarioId){
        ModelMap modelo = new ModelMap();

        Usuario usuario = usuarioDao.read(usuarioId);
        if(usuario == null) throw new IllegalArgumentException("Usuario invalido");

        ApuestaCampeon apuestaCampeon = apuestaCampeonDao.obtenerApuestaCampeon(usuario.getId());
        if(apuestaCampeon == null) apuestaCampeon = new ApuestaCampeon(usuario);

        List<Equipo> equipos = equipoDao.list();

        Fase faseFinal = faseDao.read(Instancias.FINAL.toString(), Fases.FASE_FINAL.toString());

        Partido partidoFinal = partidoDao.obtenerPartidoPorFase(faseFinal);

        modelo.put("sesion", true);
        modelo.put("usuario", usuario);
        modelo.put("equipos", equipos);
        modelo.put("partidoFinal", partidoFinal);
        modelo.put("apuestaCampeon", apuestaCampeon);

        return modelo;
    }

    // TODO testear por completo
    public void apostarCampeon(Long apostadorId, Long equipoId){
        Usuario usuario = usuarioDao.read(apostadorId);
        if(usuario == null) throw new IllegalArgumentException("Usuario invalido");

        Equipo equipoApostado = equipoDao.read(equipoId);
        if(equipoApostado == null) throw new IllegalArgumentException("Equipo inválido");

        if(partidoService.alMenosUnPartidoFueJugado()) throw new IllegalArgumentException("No se puede apostar por el equipo campeón una vez que el torneo fue comenzado");

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

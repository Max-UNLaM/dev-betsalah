package ar.edu.unlam.tallerweb1.equipo;
import ar.edu.unlam.tallerweb1.fase.Fase;
import org.springframework.stereotype.Service;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class EquipoService {

    @Inject
    private EquipoDao equipoDao;

    public void cargar() {
        if (!equiposExistenEnBaseDeDatos()) {
            List<Equipo> equipos = crearEquipos();
            cargarEquiposEnBaseDeDatos(equipos);
        }
    }

    public EquipoDto obtenerEquipoDto(Equipo equipo) {
        EquipoDto equipoDto;
        if(equipo != null){
            equipoDto = new EquipoDto(equipo.id, equipo.getNombre(), equipo.getNombre3caracteres(), true);
        } else {
            equipoDto = new EquipoDto(0L, "Por definirse", "S/D", false);
        }
        return equipoDto;
    }

    private Boolean equiposExistenEnBaseDeDatos(){
        return !equipoDao.list().isEmpty();
    }

    private List<Equipo> crearEquipos(){
        List<Equipo> equipos = new ArrayList<>();

        equipos.add(new Equipo("Rusia", "RUS"));
        equipos.add(new Equipo("Arabia Saudita", "ARA"));
        equipos.add(new Equipo("Egipto", "EGI"));
        equipos.add(new Equipo("Uruguay", "URU"));
        equipos.add(new Equipo("Portugal", "POR"));
        equipos.add(new Equipo("España", "ESP"));
        equipos.add(new Equipo("Marruecos", "MAR"));
        equipos.add(new Equipo("Irán", "IRA"));
        equipos.add(new Equipo("Francia", "FRA"));
        equipos.add(new Equipo("Australia", "AUS"));
        equipos.add(new Equipo("Perú", "PER"));
        equipos.add(new Equipo("Dinamarca", "DIN"));
        equipos.add(new Equipo("Argentina", "ARG"));
        equipos.add(new Equipo("Islandia", "ISL"));
        equipos.add(new Equipo("Croacia", "CRO"));
        equipos.add(new Equipo("Nigeria", "NIG"));
        equipos.add(new Equipo("Brasil", "BRA"));
        equipos.add(new Equipo("Suiza", "SUI"));
        equipos.add(new Equipo("Costa Rica", "CRC"));
        equipos.add(new Equipo("Serbia", "SER"));
        equipos.add(new Equipo("Alemania", "ALE"));
        equipos.add(new Equipo("México", "MEX"));
        equipos.add(new Equipo("Suecia", "SUE"));
        equipos.add(new Equipo("Corea del Sur", "COR"));
        equipos.add(new Equipo("Bélgica", "BEL"));
        equipos.add(new Equipo("Panamá", "PAN"));
        equipos.add(new Equipo("Túnez", "TUN"));
        equipos.add(new Equipo("Inglaterra", "ING"));
        equipos.add(new Equipo("Polonia", "POL"));
        equipos.add(new Equipo("Senegal", "SEN"));
        equipos.add(new Equipo("Colombia", "COL"));
        equipos.add(new Equipo("Japón", "JAP"));
        return equipos;
    }

    private void cargarEquiposEnBaseDeDatos(List<Equipo> equipos){
        for(Equipo equipo : equipos){
            equipoDao.create(equipo);
        }
    }

    public List<Equipo> obtenerEquiposPorFase(Fase fase){
        return equipoDao.obtenerEquiposPorFase(fase);
    }
}

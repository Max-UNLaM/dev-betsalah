package ar.edu.unlam.tallerweb1.equipo;
import ar.edu.unlam.tallerweb1.service.CargaService;
import org.springframework.stereotype.Service;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class EquipoService implements CargaService {

    @Inject
    private EquipoCrud equipoDao;

    public void cargar(){
        if(!equiposExistenEnBaseDeDatos()){
            List<Equipo> equipos = crearEquipos();
            cargarEquiposEnBaseDeDatos(equipos);
        }
    }

    private Boolean equiposExistenEnBaseDeDatos(){
        return equipoDao.list() != null;
    }

    private List<Equipo> crearEquipos(){
        List<Equipo> equipos = new ArrayList<>();

        equipos.add(new Equipo("Rusia", "RUS", "A", 1));
        equipos.add(new Equipo("Arabia Saudita", "ARA", "A", 2));
        equipos.add(new Equipo("Egipto", "EGI", "A", 3));
        equipos.add(new Equipo("Uruguay", "URU", "A", 4));
        equipos.add(new Equipo("Portugal", "POR", "B", 1));
        equipos.add(new Equipo("España", "ESP", "B", 2));
        equipos.add(new Equipo("Marruecos", "MAR", "B", 3));
        equipos.add(new Equipo("Irán", "IRA", "B", 4));
        equipos.add(new Equipo("Francia", "FRA", "C", 1));
        equipos.add(new Equipo("Australia", "AUS", "C", 2));
        equipos.add(new Equipo("Perú", "PER", "C", 3));
        equipos.add(new Equipo("Dinamarca", "DIN", "C", 4));
        equipos.add(new Equipo("Argentina", "ARG", "D", 1));
        equipos.add(new Equipo("Islandia", "ISL", "D", 2));
        equipos.add(new Equipo("Croacia", "CRO", "D", 3));
        equipos.add(new Equipo("Nigeria", "NIG", "D", 4));
        equipos.add(new Equipo("Brasil", "BRA", "E", 1));
        equipos.add(new Equipo("Suiza", "SUI", "E", 2));
        equipos.add(new Equipo("Costa Rica", "CRC", "E", 3));
        equipos.add(new Equipo("Serbia", "SER", "E", 4));
        equipos.add(new Equipo("Alemania", "ALE", "F", 1));
        equipos.add(new Equipo("México", "MEX", "F", 2));
        equipos.add(new Equipo("Suecia", "SUE", "F", 3));
        equipos.add(new Equipo("Corea del Sur", "COR", "F", 4));
        equipos.add(new Equipo("Bélgica", "BEL", "G", 1));
        equipos.add(new Equipo("Panamá", "PAN", "G", 2));
        equipos.add(new Equipo("Túnez", "TUN", "G", 3));
        equipos.add(new Equipo("Inglaterra", "ING", "G", 4));
        equipos.add(new Equipo("Polonia", "POL", "H", 1));
        equipos.add(new Equipo("Senegal", "SEN", "H", 2));
        equipos.add(new Equipo("Colombia", "COL", "H", 3));
        equipos.add(new Equipo("Japón", "JAP", "H", 4));
        return equipos;
    }

    private void cargarEquiposEnBaseDeDatos(List<Equipo> equipos){
        for(Equipo equipo : equipos){
            equipoDao.create(equipo);
        }
    }
}

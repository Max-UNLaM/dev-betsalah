package ar.edu.unlam.tallerweb1.simulacion;

import ar.edu.unlam.tallerweb1.partido.Partido;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("simulacionService")
@Transactional
public class SimulacionService {
    protected Partido partido;
    public void iniciarPartido(Partido partido) {

    }
}

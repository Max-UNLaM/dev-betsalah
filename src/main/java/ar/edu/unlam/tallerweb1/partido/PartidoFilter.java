package ar.edu.unlam.tallerweb1.partido;

import ar.edu.unlam.tallerweb1.fase.Fase;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PartidoFilter {
    public List<Partido> filter(Fase fase);
}

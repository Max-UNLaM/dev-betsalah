package ar.edu.unlam.tallerweb1.partido;

import ar.edu.unlam.tallerweb1.gol.Gol;
import ar.edu.unlam.tallerweb1.equipo.Equipo;
import ar.edu.unlam.tallerweb1.fase.Fase;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Partido {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    protected Long id;
    @ManyToOne
    protected Equipo local;
    @ManyToOne
    protected Equipo visitante;
    protected String estado;
    @ManyToOne
    private Fase fase;
    protected List<Gol> golesLocales = new ArrayList<Gol>();
    protected List<Gol> golesVisitantes = new ArrayList<Gol>();

    public Partido(Equipo equipo1, Equipo equipo2, Fase fase) {
        this.local = equipo1;
        this.visitante = equipo2;
        this.fase = fase;
    }


}

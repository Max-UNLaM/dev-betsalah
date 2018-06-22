package ar.edu.unlam.tallerweb1.partido;

import ar.edu.unlam.tallerweb1.equipo.Equipo;
import ar.edu.unlam.tallerweb1.fase.Fase;

import javax.persistence.*;

@Entity
public class Partido {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public Long id;
    @ManyToOne
    protected Equipo local;
    @ManyToOne
    protected Equipo visitante;
    protected String estado;
    @ManyToOne
    private Fase fase;

    public Partido(){}

    public Partido(Equipo local, Equipo visitante, Fase fase) {
        this.local = local;
        this.visitante = visitante;
        this.fase = fase;
    }

    public Long getId() {
        return this.id;
    }

    public Long idLocal() {
        return  this.local.getId();
    }

    public Long idVisitante() {
        return this.visitante.getId();
    }

    public Fase getFase() {
        return this.fase;
    }

    public Equipo getEquipo(String tipo) {
        if (tipo == "visitante") {
            return this.visitante;
        } else {
            return this.local;
        }
    }

}

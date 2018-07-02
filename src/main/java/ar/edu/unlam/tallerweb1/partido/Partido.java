package ar.edu.unlam.tallerweb1.partido;

import ar.edu.unlam.tallerweb1.equipo.Equipo;
import ar.edu.unlam.tallerweb1.fase.Fase;
import ar.edu.unlam.tallerweb1.gol.Gol;
import ar.edu.unlam.tallerweb1.gol.GolService;

import javax.inject.Inject;
import javax.persistence.*;
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
    @ManyToOne
    private Fase fase;
    protected boolean jugado;

    public Partido(){}

    public Partido(Equipo local, Equipo visitante, Fase fase) {
        this.local = local;
        this.visitante = visitante;
        this.fase = fase;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Equipo getLocal() {
        return local;
    }

    public void setLocal(Equipo local) {
        this.local = local;
    }

    public Equipo getVisitante() {
        return visitante;
    }

    public void setVisitante(Equipo visitante) {
        this.visitante = visitante;
    }

    public boolean getJugado() {
        return jugado;
    }

    public void setJugado(boolean jugado) {
        this.jugado = jugado;
    }


    public void setFase(Fase fase) {
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

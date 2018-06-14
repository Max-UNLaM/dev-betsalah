package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Equipo equipo1;
    @ManyToOne
    private Equipo equipo2;
    @ManyToOne
    private Fase fase;
    @ManyToOne
    private Jugador figura;

    public Partido(){

    }

    public Partido(Equipo equipo1, Equipo equipo2, Fase fase) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.fase = fase;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    public Fase getFase() {
        return fase;
    }

    public void setFase(Fase fase) {
        this.fase = fase;
    }

    public Jugador getFigura() {
        return figura;
    }

    public void setFigura(Jugador figura) {
        this.figura = figura;
    }
}

package ar.edu.unlam.tallerweb1.jugador;

import ar.edu.unlam.tallerweb1.equipo.Equipo;

import javax.persistence.*;

@Entity
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreCompleto;
    @ManyToOne
    private Equipo equipo;

    public Jugador(){

    }

    public Jugador(String nombreCompleto, Equipo equipo) {
        this.nombreCompleto = nombreCompleto;
        this.equipo = equipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
}

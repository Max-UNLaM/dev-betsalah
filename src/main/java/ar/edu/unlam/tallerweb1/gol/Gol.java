package ar.edu.unlam.tallerweb1.gol;

import ar.edu.unlam.tallerweb1.equipo.Equipo;
import ar.edu.unlam.tallerweb1.jugador.Jugador;
import ar.edu.unlam.tallerweb1.jugador.JugadorDao;
import ar.edu.unlam.tallerweb1.partido.Partido;

import javax.inject.Inject;
import javax.persistence.*;

@Entity
public class Gol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer minuto;
    @ManyToOne
    private Jugador goleador;
    @ManyToOne
    private Jugador arquero;
    @ManyToOne
    private Partido partido;
    @OneToOne
    private Equipo equipo;

    public Gol(){}

    public Gol(Partido partido, Equipo equipo) {
        this.partido = partido;
        this.equipo = equipo;
        this.goleador = new Jugador("Semenov", equipo);
        this.arquero = new Jugador("Semenov", equipo);
        this.minuto = 90;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

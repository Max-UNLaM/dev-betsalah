package ar.edu.unlam.tallerweb1.gol;

import ar.edu.unlam.tallerweb1.jugador.Jugador;
import ar.edu.unlam.tallerweb1.partido.Partido;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

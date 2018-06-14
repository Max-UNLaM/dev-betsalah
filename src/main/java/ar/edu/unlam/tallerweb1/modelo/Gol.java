package ar.edu.unlam.tallerweb1.modelo;

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

    public Integer getMinuto() {
        return minuto;
    }

    public void setMinuto(Integer minuto) {
        this.minuto = minuto;
    }

    public Jugador getGoleador() {
        return goleador;
    }

    public void setGoleador(Jugador goleador) {
        this.goleador = goleador;
    }

    public Jugador getArquero() {
        return arquero;
    }

    public void setArquero(Jugador arquero) {
        this.arquero = arquero;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }
}

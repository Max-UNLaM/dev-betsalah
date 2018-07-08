package ar.edu.unlam.tallerweb1.apuesta;

import ar.edu.unlam.tallerweb1.jugador.Jugador;
import ar.edu.unlam.tallerweb1.partido.Partido;
import ar.edu.unlam.tallerweb1.usuario.Usuario;

import javax.persistence.*;

@Entity
public class Apuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Jugador figura;
    @ManyToOne
    private Usuario apostador;
    @ManyToOne
    private Partido partido;
    private Integer golesLocal;
    private Integer golesVisitante;
    private Integer puntaje;

    public Apuesta(){

    }

    public Apuesta(Usuario apostador, Partido partido, Integer golesLocal, Integer golesVisitante){
        this.apostador =  apostador;
        this.partido = partido;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Jugador getFigura() {
        return figura;
    }

    public void setFigura(Jugador figura) {
        this.figura = figura;
    }

    public Usuario getApostador() {
        return apostador;
    }

    public void setApostador(Usuario apostador) {
        this.apostador = apostador;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Integer getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(Integer golesLocal) {
        this.golesLocal = golesLocal;
    }

    public Integer getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(Integer golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }
}

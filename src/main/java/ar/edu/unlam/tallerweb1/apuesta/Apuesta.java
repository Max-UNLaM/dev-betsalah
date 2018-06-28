package ar.edu.unlam.tallerweb1.apuesta;

import ar.edu.unlam.tallerweb1.partido.Partido;
import ar.edu.unlam.tallerweb1.usuario.Usuario;

import javax.persistence.*;

@Entity
public class Apuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long figuraId;
    @ManyToOne
    private Usuario apostador;
    @ManyToOne
    private Partido partido;
    private Integer golesLocal;
    private Integer golesVisitante;

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
    
    public Long getFigura() {
    	return figuraId;
    }
    
    public void setFigura(Long figuraId) {
    	this.figuraId = figuraId;
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
}

package ar.edu.unlam.tallerweb1.partido;

import ar.edu.unlam.tallerweb1.equipo.Equipo;
import ar.edu.unlam.tallerweb1.fase.Fase;
import ar.edu.unlam.tallerweb1.jugador.Jugador;
import ar.edu.unlam.tallerweb1.util.Resultados;

import javax.persistence.*;

@Entity
public class Partido {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    protected Long id;
    @ManyToOne
    protected Jugador figura;
    @ManyToOne
    protected Equipo local;
    @ManyToOne
    protected Equipo visitante;
	@ManyToOne
    private Fase fase;
    protected boolean jugado;
    private Integer golesLocal;
    private Integer golesVisitante;
    private String resultado;

    public Partido(){}

    public Partido(Equipo local, Equipo visitante, Fase fase) {
        this.local = local;
        this.visitante = visitante;
        this.fase = fase;
        this.jugado =  false;
        this.golesLocal = 0;
        this.golesVisitante = 0;
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

    public boolean isJugado() {
        return jugado;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(){
        String RESULTADO_GANA_LOCAL = Resultados.RESULTADO_GANA_LOCAL.toString();
        String RESULTADO_EMPATE = Resultados.RESULTADO_EMPATE.toString();
        String RESULTADO_GANA_VISITANTE = Resultados.RESULTADO_GANA_VISITANTE.toString();

        if(this.getGolesLocal()>this.getGolesVisitante()) this.resultado = RESULTADO_GANA_LOCAL;
        if(this.getGolesLocal().equals(this.getGolesVisitante())) this.resultado = RESULTADO_EMPATE;
        if(this.getGolesLocal()<this.getGolesVisitante()) this.resultado = RESULTADO_GANA_VISITANTE;
    }
}

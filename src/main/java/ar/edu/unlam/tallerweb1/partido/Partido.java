package ar.edu.unlam.tallerweb1.partido;

import ar.edu.unlam.tallerweb1.equipo.Equipo;
import ar.edu.unlam.tallerweb1.fase.Fase;
import ar.edu.unlam.tallerweb1.gol.Gol;
import ar.edu.unlam.tallerweb1.gol.GolService;
import ar.edu.unlam.tallerweb1.util.SalahProperties;

import javax.inject.Inject;
import javax.persistence.*;
import java.util.List;

@Entity
public class Partido {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    protected Long id;
    protected Long figuraId;
    @ManyToOne
    protected Equipo local;
    @ManyToOne
    protected Equipo visitante;


	@ManyToOne
    private Fase fase;
    protected boolean jugado;
    private Integer golesLocal;
    private Integer golesVisitante;

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
    
    public Long getFiguraId() {
		return figuraId;
	}

	public void setFiguraId(Long figuraId) {
		this.figuraId = figuraId;
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

    public String getResultado(){
        String RESULTADO_GANA_LOCAL = SalahProperties.RESULTADO_GANA_LOCAL;
        String RESULTADO_EMPATE = SalahProperties.RESULTADO_EMPATE;
        String RESULTADO_GANA_VISITANTE = SalahProperties.RESULTADO_GANA_VISITANTE;

        String respuesta = null;

        if(this.getGolesLocal()>this.getGolesVisitante()) respuesta = RESULTADO_GANA_LOCAL;
        if(this.getGolesLocal().equals(this.getGolesVisitante())) respuesta = RESULTADO_EMPATE;
        if(this.getGolesLocal()<this.getGolesVisitante()) respuesta = RESULTADO_GANA_VISITANTE;

        return respuesta;
    }
}

package ar.edu.unlam.tallerweb1.partido;

public class PartidoJuegoDto {
    public Long id;
    public Integer golesLocal;
    public Integer golesVisitante;
    public Long figuraId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getFiguraId() {
        return figuraId;
    }

    public void setFiguraId(Long figuraId) {
        this.figuraId = figuraId;
    }
}

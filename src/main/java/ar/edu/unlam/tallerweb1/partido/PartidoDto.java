package ar.edu.unlam.tallerweb1.partido;

import ar.edu.unlam.tallerweb1.equipo.EquipoDto;

public class PartidoDto {
    public Long id;
    public Integer golesVisitante;
    public Integer golesLocal;
    public EquipoDto local;
    public EquipoDto visitante;
    public Boolean jugado;

    public PartidoDto(){}

    public PartidoDto(Long id, Integer golesLocal, Integer golesVisitante, EquipoDto local, EquipoDto visitante, Boolean jugado) {
        this.id = id;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
        this.local = local;
        this.visitante = visitante;
        this.jugado = jugado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(Integer golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    public Integer getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(Integer golesLocal) {
        this.golesLocal = golesLocal;
    }

    public EquipoDto getLocal() {
        return local;
    }

    public void setLocal(EquipoDto local) {
        this.local = local;
    }

    public EquipoDto getVisitante() {
        return visitante;
    }

    public void setVisitante(EquipoDto visitante) {
        this.visitante = visitante;
    }

    public boolean getJugado() {
        return jugado;
    }

    public void setJugado(Boolean jugado) {
        this.jugado = jugado;
    }
}

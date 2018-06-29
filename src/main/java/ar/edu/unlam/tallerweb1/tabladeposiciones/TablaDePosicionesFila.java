package ar.edu.unlam.tallerweb1.tabladeposiciones;

import ar.edu.unlam.tallerweb1.equipo.Equipo;

public class TablaDePosicionesFila {
    private Equipo equipo;
    private Integer puntos;
    private Integer golesAFavor;
    private Integer golesEnContra;
    private Integer diferenciaDeGol;

    public TablaDePosicionesFila(Equipo equipo) {
        this.equipo = equipo;
        this.puntos = 0;
        this.golesAFavor = 0;
        this.golesEnContra = 0;
        this.diferenciaDeGol = 0;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public Integer getGolesAFavor() {
        return golesAFavor;
    }

    public void setGolesAFavor(Integer golesAFavor) {
        this.golesAFavor = golesAFavor;
    }

    public Integer getGolesEnContra() {
        return golesEnContra;
    }

    public void setGolesEnContra(Integer golesEnContra) {
        this.golesEnContra = golesEnContra;
    }

    public Integer getDiferenciaDeGol() {
        return diferenciaDeGol;
    }

    public void setDiferenciaDeGol(Integer diferenciaDeGol) {
        this.diferenciaDeGol = diferenciaDeGol;
    }
}

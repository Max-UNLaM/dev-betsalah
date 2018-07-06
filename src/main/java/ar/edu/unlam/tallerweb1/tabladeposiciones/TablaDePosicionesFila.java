package ar.edu.unlam.tallerweb1.tabladeposiciones;

import ar.edu.unlam.tallerweb1.equipo.Equipo;

public class TablaDePosicionesFila implements Comparable{
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

    public void sumarPuntos(Integer puntos){
        this.puntos += puntos;
    }

    public void sumarGolesAFavor(Integer golesAFavor){
        this.golesAFavor += golesAFavor;
    }

    public void sumarGolesEnContra(Integer golesEnContra){
        this.golesEnContra += golesEnContra;
    }

    public void actualizarDiferenciaDeGol(){
        this.diferenciaDeGol = golesAFavor - golesEnContra;
    }

    @Override
    public int compareTo(Object object) {
        TablaDePosicionesFila fila2 = (TablaDePosicionesFila) object;
        int respuesta = 0;

        if(this.puntos < fila2.puntos){
            respuesta = 1;
        } else if (this.puntos > fila2.puntos){
            respuesta = -1;
        } else if(this.puntos.equals(fila2.puntos)){
            if(this.diferenciaDeGol < fila2.diferenciaDeGol){
                respuesta = 1;
            } else if (this.diferenciaDeGol > fila2.diferenciaDeGol){
                respuesta = -1;
            } else if(this.diferenciaDeGol.equals(fila2.diferenciaDeGol)){
                if(this.golesAFavor < fila2.golesAFavor){
                    respuesta = 1;
                } else {
                    respuesta = -1;
                }
            }
        }
        return respuesta;
    }

}

package ar.edu.unlam.tallerweb1.apuesta;

import ar.edu.unlam.tallerweb1.util.Fases;

public class ApuestaValidador {
    public String validarFase(String fase){
        if(fase == null) fase="";
        if(fase.equals("grupos")) return Fases.FASE_DE_GRUPOS.toString();
        if(fase.equals("octavos")) return Fases.FASE_OCTAVOS_DE_FINAL.toString();
        if(fase.equals("cuartos")) return Fases.FASE_CUARTOS_DE_FINAL.toString();
        if(fase.equals("semifinal")) return Fases.FASE_SEMIFINAL.toString();
        if(fase.equals("tercer-puesto")) return Fases.FASE_TERCER_PUESTO.toString();
        if(fase.equals("final")) return Fases.FASE_FINAL.toString();
        return Fases.FASE_DE_GRUPOS.toString();
    }
}

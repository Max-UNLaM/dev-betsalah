package ar.edu.unlam.tallerweb1.apuesta;

import ar.edu.unlam.tallerweb1.util.SalahProperties;

public class ApuestaValidador {
    public String validarFase(String fase){
        if(fase == null) fase="";
        if(fase.equals("grupos")) return SalahProperties.FASE_DE_GRUPOS;
        if(fase.equals("octavos")) return SalahProperties.FASE_OCTAVOS_DE_FINAL;
        if(fase.equals("cuartos")) return SalahProperties.FASE_CUARTOS_DE_FINAL;
        if(fase.equals("semifinal")) return SalahProperties.FASE_SEMIFINAL;
        if(fase.equals("tercer-puesto")) return SalahProperties.FASE_TERCER_PUESTO;
        if(fase.equals("final")) return SalahProperties.FASE_FINAL;
        return SalahProperties.FASE_DE_GRUPOS;
    }
}

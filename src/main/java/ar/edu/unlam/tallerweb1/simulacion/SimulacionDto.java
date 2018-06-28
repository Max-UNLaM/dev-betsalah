package ar.edu.unlam.tallerweb1.simulacion;

public class SimulacionDto {
    public Long id;
    public Integer golesVisitante;
    public Integer golesLocal;
    public SimulacionDto(){    }
    public SimulacionDto(Long id, Integer golesLocal, Integer golesVisitante) {
        this.id = id;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
    }
}

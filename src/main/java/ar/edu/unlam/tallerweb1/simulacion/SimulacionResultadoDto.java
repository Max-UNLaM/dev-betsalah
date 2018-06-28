package ar.edu.unlam.tallerweb1.simulacion;

public class SimulacionResultadoDto {
    protected String resultado;
    protected String local;
    protected String visitante;
    protected String textoResultado;

    public SimulacionResultadoDto(){}

    public SimulacionResultadoDto(String local, String visitante, String resultado, String textoResultado) {
        this.local = local;
        this.visitante = visitante;
        this.resultado = resultado;
        this.textoResultado = textoResultado;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getVisitante() {
        return visitante;
    }

    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }

    public String getTextoResultado() {
        return textoResultado;
    }

    public void setTextoResultado(String textoResultado) {
        this.textoResultado = textoResultado;
    }
}

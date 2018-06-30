package ar.edu.unlam.tallerweb1.fase;

import javax.persistence.*;

@Entity
public class Fase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private String nombre;
    private Boolean finalizada;
    @OneToOne
    private Fase siguienteFasePrimeroDeLaFase;
    private String condicionSiguienteFasePrimeroDeLaFase;
    @OneToOne
    private Fase siguienteFaseSegundoDeLaFase;
    private String condicionSiguienteFaseSegundoDeLaFase;

    public Fase(){

    }

    public Fase(String tipo, String nombre) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.finalizada = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getFinalizada() {
        return finalizada;
    }

    public void setFinalizada(Boolean finalizada) {
        this.finalizada = finalizada;
    }

    public Fase getSiguienteFasePrimeroDeLaFase() {
        return siguienteFasePrimeroDeLaFase;
    }

    public void setSiguienteFasePrimeroDeLaFase(Fase siguienteFasePrimeroDeLaFase) {
        this.siguienteFasePrimeroDeLaFase = siguienteFasePrimeroDeLaFase;
    }

    public String getCondicionSiguienteFasePrimeroDeLaFase() {
        return condicionSiguienteFasePrimeroDeLaFase;
    }

    public void setCondicionSiguienteFasePrimeroDeLaFase(String condicionSiguienteFasePrimeroDeLaFase) {
        this.condicionSiguienteFasePrimeroDeLaFase = condicionSiguienteFasePrimeroDeLaFase;
    }

    public Fase getSiguienteFaseSegundoDeLaFase() {
        return siguienteFaseSegundoDeLaFase;
    }

    public void setSiguienteFaseSegundoDeLaFase(Fase siguienteFaseSegundoDeLaFase) {
        this.siguienteFaseSegundoDeLaFase = siguienteFaseSegundoDeLaFase;
    }

    public String getCondicionSiguienteFaseSegundoDeLaFase() {
        return condicionSiguienteFaseSegundoDeLaFase;
    }

    public void setCondicionSiguienteFaseSegundoDeLaFase(String condicionSiguienteFaseSegundoDeLaFase) {
        this.condicionSiguienteFaseSegundoDeLaFase = condicionSiguienteFaseSegundoDeLaFase;
    }

    public void mapearSiguienteFaseParaPrimeroDeLaFase(Fase siguienteFase, String condicion){
        this.siguienteFasePrimeroDeLaFase = siguienteFase;
        this.condicionSiguienteFasePrimeroDeLaFase = condicion;
    }

    public void mapearSiguienteFaseParaSegundoDeLaFase(Fase siguienteFase, String condicion){
        this.siguienteFaseSegundoDeLaFase = siguienteFase;
        this.condicionSiguienteFaseSegundoDeLaFase = condicion;
    }


}

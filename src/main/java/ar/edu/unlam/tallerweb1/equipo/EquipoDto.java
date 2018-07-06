package ar.edu.unlam.tallerweb1.equipo;

import org.springframework.stereotype.Component;

@Component
public class EquipoDto {
    public Long id;
    public String nombre;
    private String nombre3caracteres;
    private Boolean definido;

    public EquipoDto(){}

    public EquipoDto(Long id, String nombre, String nombre3caracteres, Boolean definido) {
        this.id = id;
        this.nombre = nombre;
        this.nombre3caracteres = nombre3caracteres;
        this.definido = definido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre3caracteres() {
        return nombre3caracteres;
    }

    public void setNombre3caracteres(String nombre3caracteres) {
        this.nombre3caracteres = nombre3caracteres;
    }

    public Boolean getDefinido() {
        return definido;
    }

    public void setDefinido(Boolean definido) {
        this.definido = definido;
    }
}

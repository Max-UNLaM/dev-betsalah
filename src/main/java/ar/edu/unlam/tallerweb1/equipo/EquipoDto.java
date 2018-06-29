package ar.edu.unlam.tallerweb1.equipo;

import org.springframework.stereotype.Component;

@Component
public class EquipoDto {
    public Long id;
    public String nombre;
    public String nombre3caracteres;
    public String grupo;
    public Integer ordenEnGrupo;

    public EquipoDto(){}

    public EquipoDto(Long id, String nombre, String nombre3caracteres, String grupo, Integer ordenEnGrupo) {
        this.id = id;
        this.nombre = nombre;
        this.nombre3caracteres = nombre3caracteres;
        this.grupo = grupo;
        this.ordenEnGrupo = ordenEnGrupo;
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

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public Integer getOrdenEnGrupo() {
        return ordenEnGrupo;
    }

    public void setOrdenEnGrupo(Integer ordenEnGrupo) {
        this.ordenEnGrupo = ordenEnGrupo;
    }
}
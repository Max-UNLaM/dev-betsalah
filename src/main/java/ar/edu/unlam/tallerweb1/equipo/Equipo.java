package ar.edu.unlam.tallerweb1.equipo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    private String nombre;
    private String nombre3caracteres;

    public Equipo(){

    }

    public Equipo(String nombre, String nombre3caracteres) {
        this.nombre = nombre;
        this.nombre3caracteres = nombre3caracteres;
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
}

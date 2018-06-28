package ar.edu.unlam.tallerweb1.grupo;

import ar.edu.unlam.tallerweb1.equipo.Equipo;

import javax.persistence.*;

@Entity
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @OneToOne
    private Equipo cabezaDeSerie;
    @OneToOne
    private Equipo equipo2;
    @OneToOne
    private Equipo equipo3;
    @OneToOne
    private Equipo equipo4;
    private Boolean todosLosPartidosFueronJugados;

    private Grupo(){

    }

    public Grupo(String nombre, Equipo cabezaDeSerie, Equipo equipo2, Equipo equipo3, Equipo equipo4) {
        this.nombre = nombre;
        this.cabezaDeSerie = cabezaDeSerie;
        this.equipo2 = equipo2;
        this.equipo3 = equipo3;
        this.equipo4 = equipo4;
        this.todosLosPartidosFueronJugados = false;
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

    public Equipo getCabezaDeSerie() {
        return cabezaDeSerie;
    }

    public void setCabezaDeSerie(Equipo cabezaDeSerie) {
        this.cabezaDeSerie = cabezaDeSerie;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    public Equipo getEquipo3() {
        return equipo3;
    }

    public void setEquipo3(Equipo equipo3) {
        this.equipo3 = equipo3;
    }

    public Equipo getEquipo4() {
        return equipo4;
    }

    public void setEquipo4(Equipo equipo4) {
        this.equipo4 = equipo4;
    }

    public Boolean getTodosLosPartidosFueronJugados() {
        return todosLosPartidosFueronJugados;
    }

    public void setTodosLosPartidosFueronJugados(Boolean todosLosPartidosFueronJugados) {
        this.todosLosPartidosFueronJugados = todosLosPartidosFueronJugados;
    }
}

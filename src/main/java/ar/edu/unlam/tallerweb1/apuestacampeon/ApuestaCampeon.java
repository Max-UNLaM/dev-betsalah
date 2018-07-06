package ar.edu.unlam.tallerweb1.apuestacampeon;

import ar.edu.unlam.tallerweb1.equipo.Equipo;
import ar.edu.unlam.tallerweb1.usuario.Usuario;

import javax.persistence.*;

@Entity
public class ApuestaCampeon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Usuario apostador;
    @ManyToOne
    private Equipo equipoApostado;

    public ApuestaCampeon(){

    }

    public ApuestaCampeon(Usuario apostador) {
        this.apostador = apostador;
    }

    public ApuestaCampeon(Usuario apostador, Equipo apuestaCampeon) {
        this.apostador = apostador;
        this.equipoApostado = apuestaCampeon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getApostador() {
        return apostador;
    }

    public void setApostador(Usuario apostador) {
        this.apostador = apostador;
    }

    public Equipo getEquipoApostado() {
        return equipoApostado;
    }

    public void setEquipoApostado(Equipo equipoApostado) {
        this.equipoApostado = equipoApostado;
    }
}

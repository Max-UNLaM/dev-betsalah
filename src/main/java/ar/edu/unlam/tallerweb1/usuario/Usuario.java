package ar.edu.unlam.tallerweb1.usuario;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String nombre;
	private String password;
	private Integer puntaje;

	public Usuario(){}

	public Usuario(String email, String nombre, String password, Integer puntaje) {
	    this.email = email;
	    this.nombre = nombre;
	    this.password = password;
	    this.puntaje = puntaje;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(Integer puntaje) {
		this.puntaje = puntaje;
	}
}

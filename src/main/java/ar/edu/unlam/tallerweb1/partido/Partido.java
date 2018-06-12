package ar.edu.unlam.tallerweb1.partido;

import ar.edu.unlam.tallerweb1.gol.Gol;
import ar.edu.unlam.tallerweb1.modelo.Equipo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Partido {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    protected Long id;
    protected Equipo local;
    protected Equipo visitante;
    protected String estado;
    protected List<Gol> golesLocales = new ArrayList<Gol>();
    protected List<Gol> golesVisitantes = new ArrayList<Gol>();

}

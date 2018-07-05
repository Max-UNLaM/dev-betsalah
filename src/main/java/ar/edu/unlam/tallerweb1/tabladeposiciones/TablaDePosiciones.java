package ar.edu.unlam.tallerweb1.tabladeposiciones;

import ar.edu.unlam.tallerweb1.equipo.Equipo;
import ar.edu.unlam.tallerweb1.partido.Partido;
import ar.edu.unlam.tallerweb1.util.SalahProperties;

import java.util.*;
import java.util.stream.Collectors;

public class TablaDePosiciones {
    private String RESULTADO_GANA_LOCAL = SalahProperties.RESULTADO_GANA_LOCAL;
    private String RESULTADO_EMPATE = SalahProperties.RESULTADO_EMPATE;
    private String RESULTADO_GANA_VISITANTE = SalahProperties.RESULTADO_GANA_VISITANTE;

    private Integer CANTIDAD_PUNTOS_GANADOR = SalahProperties.CANTIDAD_PUNTOS_GANADOR;
    private Integer CANTIDAD_PUNTOS_EMPATE = SalahProperties.CANTIDAD_PUNTOS_EMPATE;
    private Integer CANTIDAD_PUNTOS_PERDEDOR = SalahProperties.CANTIDAD_PUNTOS_PERDEDOR;

    private List<TablaDePosicionesFila> filaTablaDePosiciones;

    public TablaDePosiciones(List<Equipo> equipos, List<Partido> partidos) {
        this.filaTablaDePosiciones = new ArrayList<>();
        this.cargarEquipos(equipos);
        this.calcularPosiciones(partidos);
    }

    private void cargarEquipos(List<Equipo> equiposDeLaFase){
        for(Equipo equipo : equiposDeLaFase){
            filaTablaDePosiciones.add(new TablaDePosicionesFila(equipo));
        }
    }

    private void calcularPosiciones(List<Partido> partidosDeLaFase){
        Integer puntosLocal = 0;
        Integer puntosVisitante = 0;

        for(Partido partido : partidosDeLaFase){

            if(partido.getResultado().equals(RESULTADO_GANA_LOCAL)){
                puntosLocal = CANTIDAD_PUNTOS_GANADOR;
                puntosVisitante = CANTIDAD_PUNTOS_PERDEDOR;
            } else if(partido.getResultado().equals(RESULTADO_EMPATE)){
                puntosLocal = CANTIDAD_PUNTOS_EMPATE;
                puntosVisitante = CANTIDAD_PUNTOS_EMPATE;
            } else if (partido.getResultado().equals(RESULTADO_GANA_VISITANTE)){
                puntosLocal = CANTIDAD_PUNTOS_PERDEDOR;
                puntosVisitante = CANTIDAD_PUNTOS_GANADOR;
            }

            this.actualizarFila(partido.getLocal(),
                                puntosLocal,
                                partido.getGolesLocal(),
                                partido.getGolesVisitante());

            this.actualizarFila(partido.getVisitante(),
                                puntosVisitante,
                                partido.getGolesVisitante(),
                                partido.getGolesLocal());
        }

        this.filaTablaDePosiciones =
                this.filaTablaDePosiciones
                .stream()
                .sorted((f1, f2)->f1.compareTo(f2))
                .collect(Collectors.toList());
    }

    private void actualizarFila(Equipo equipo,
                               Integer puntos,
                               Integer golesAFavor,
                               Integer golesEnContra){

        Integer ubicacionEnLista = this.getIndexOf(equipo);
        TablaDePosicionesFila fila = this.filaTablaDePosiciones.get(ubicacionEnLista);

        fila.sumarPuntos(puntos);
        fila.sumarGolesAFavor(golesAFavor);
        fila.sumarGolesEnContra(golesEnContra);
        fila.actualizarDiferenciaDeGol();

        this.replace(fila, ubicacionEnLista);
    }

    public Equipo obtenerPrimero(){
        return this.filaTablaDePosiciones.get(0).getEquipo();
    }

    public Equipo obtenerSegundo(){
        return this.filaTablaDePosiciones.get(1).getEquipo();
    }

    private Integer getIndexOf(Equipo equipo){
        Integer respuesta = -1;
        Integer contador = 0;
        Boolean encontrado = false;

        for(TablaDePosicionesFila fila : this.filaTablaDePosiciones){
            if(!encontrado){
                if(equipo.getId().equals(fila.getEquipo().getId())){
                    encontrado = true;
                    respuesta = contador;
                }
            }
            contador++;
        }
        return respuesta;
    }

    private void replace(TablaDePosicionesFila fila, int ubicacionEnLista){
        this.filaTablaDePosiciones.remove(ubicacionEnLista);
        this.filaTablaDePosiciones.add(ubicacionEnLista, fila);
    }
}

'use strict';
let conexion = {
    cambiarPuntos(objeto) {
        const golesValor = document.getElementById(`apuesta-goles-${objeto.equipo}-${objeto.apuestaid}`);
        this.sdk = new PartidoConnector(objeto, golesValor);
        this.sdk.putGoles();
    },
    simularPartidos(id) {
        const golesDelLocal = document.getElementById(`goles-local-${id}`).innerText;
        const golesDelVisitante = document.getElementById(`goles-visitante-${id}`).innerText;
        const envio = {
            id: Number(id),
            golesLocal: Number(golesDelLocal),
            golesVisitante: Number(golesDelVisitante)
        };
        this.sdk = new SimulacionConnector(envio);
        this.sdk.jugar();
    },
    editarGoles(objeto) {
        const golesSpan = document.getElementById(`goles-${objeto.equipo}-${objeto.id}`);
        let golesNuevos = Number(golesSpan.innerText);
        if (objeto.accion === "suma") {
            golesSpan.innerText = (golesNuevos + 1).toString();
        } else {
            if (golesNuevos !== 0) {
                golesSpan.innerText = (golesNuevos - 1).toString();
            }
        }
    }
};

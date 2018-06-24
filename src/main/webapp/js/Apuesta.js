'use strict';
let conexion = {
    cambiarPuntos(objeto) {
        const golesValor = document.getElementById(`apuesta-goles-${objeto.equipo}-${objeto.apuestaid}`);
        this.sdk = new PartidoConnector(objeto, golesValor);
        this.sdk.putGoles();
    }
};

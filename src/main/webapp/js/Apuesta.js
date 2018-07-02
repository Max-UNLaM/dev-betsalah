'use strict';
let conexion = {
    cambiarPuntos(objeto) {
        console.log(objeto);
        const golesValor = document.getElementById(`apuesta-goles-${objeto.equipo}-${objeto.apuestaid}`);
        this.sdk = new PartidoConnector(objeto, golesValor);
        this.sdk.putGoles(golesValor);
    },
    cambiarFigura(objeto){
        console.log(objeto);
        const figuraId = document.getElementById(`apuesta-figura-${objeto.apuestaid}`).value;
        this.sdk = new PartidoConnector(objeto, figuraId);
        this.sdk.putFigura(figuraId);
    }
};

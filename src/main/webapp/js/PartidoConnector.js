'use strict';
const apuestaCambiarGoles = '/apuesta/cambiar-goles-apostados';
class PartidoConnector {
    constructor(elemento) {
        this.url = apuestaCambiarGoles;
        this.conector = new XMLHttpRequest();
        const recepcion = Object.assign({},elemento);
        this.envio = {
            apuestaId: Number(recepcion.apuestaid),
            equipo: recepcion.equipo,
            accion: recepcion.accion
        };
    }

    putGoles(golesValor) {
        let xhr = this.conector;
        const envio = `${this.url}?apuestaId=${this.envio.apuestaId}&equipo=${this.envio.equipo}&accion=${this.envio.accion}`;
        xhr.open("put", envio, true);
        xhr.setRequestHeader('Content-type','application/json');
        xhr.onload = function() {
            if (xhr.readyState === xhr.DONE) {
                if (xhr.status === 200) {
                    golesValor.innerText = xhr.responseText;
                } else {
                    console.error(xhr.response);
                }
            }
        };
        xhr.send();
    }
}

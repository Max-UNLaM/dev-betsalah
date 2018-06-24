'use strict';
const apuestaCambiarGoles = '/apuesta/cambiar-goles-apostados';
class PartidoConnector {
    constructor(elemento, golesValor) {
        this.url = apuestaCambiarGoles;
        this.conector = new XMLHttpRequest();
        this.golesValor = golesValor;
        const recepcion = Object.assign({},elemento);
        this.envio = {
            apuestaId: Number(recepcion.apuestaid),
            equipo: recepcion.equipo,
            accion: recepcion.accion
        };
    }

    putGoles() {
        const envio = `${this.url}?apuestaId=${this.envio.apuestaId}&equipo=${this.envio.equipo}&accion=${this.envio.accion}`;
        this.conector.open("put", envio, true);
        this.conector.setRequestHeader('Content-type','application/json');
        this.conector.onreadystatechange = (val) => {
            if (val.target.status === 200) {
                this.golesValor.innerText = val.target.responseText;
            } else {
                console.error(val.target.responseText);
            }
        };
        this.conector.send();
    }
}

'use strict';
const apuestaCambiarGoles = '/simulacion/jugar';
class SimulacionConnector {
    constructor(simulacionDto) {
        this.conector = new XMLHttpRequest();
        this.simulacionDto = simulacionDto;
    }

    jugar() {
        let xhr = this.conector;
        xhr.open("put", apuestaCambiarGoles, true);
        xhr.setRequestHeader('Content-type','application/json');
        xhr.onload = function() {
            if (xhr.readyState === xhr.DONE) {
                if (xhr.status === 200) {
                    console.log(xhr);
                    console.log(xhr.response);
                    console.log(xhr.responseText)
                } else {
                    console.error(xhr.response);
                }
            }
        };
        xhr.send(JSON.stringify(this.simulacionDto));
    }
}
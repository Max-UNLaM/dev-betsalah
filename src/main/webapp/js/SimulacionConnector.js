'use strict';
const apuestaCambiarGoles = '/simulacion/jugar';
class SimulacionConnector {
    constructor(simulacionDto) {
        this.conector = new XMLHttpRequest();
        this.simulacionDto = simulacionDto;
    }
    jugar() {
        return new Promise((resolve, reject) => {
            let xhr = this.conector;
            xhr.open("put", apuestaCambiarGoles, true);
            xhr.setRequestHeader('Content-type','application/json');
            xhr.onload = function() {
                if (xhr.readyState === xhr.DONE) {
                    if (xhr.status === 200) {
                        resolve(xhr.response);
                    } else {
                        reject(xhr.response);
                    }
                }
            };
            xhr.send(JSON.stringify(this.simulacionDto));
        });
    }
}

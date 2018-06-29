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
        const juego = this.sdk.jugar();
        juego.then((val) => {
            deshabilitarBotones(id, JSON.parse(val).textoResultado);
        })
        .catch((err) => {
            console.error(err);
        });

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
function deshabilitarBotones (id, resultado) {
    const resultadoTxt = document.getElementById(`partido-resultado-${id}`);
    const botones = [
            document.getElementById(`${id}-local-resta`),
            document.getElementById(`${id}-local-suma`),
            document.getElementById(`${id}-visitante-resta`),
            document.getElementById(`${id}-visitante-suma`),
            document.getElementById(`jugar-partido-${id}`),
        ];
    botones.map((val) => {
       val.disabled = true;
    });
    resultadoTxt.innerText = resultado;
    resultadoTxt.classList.add("success");
}
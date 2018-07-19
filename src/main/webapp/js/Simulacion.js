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
        const figuraId = document.getElementById(`figura-${id}`).value;
        const envio = {
            id: Number(id),
            golesLocal: Number(golesDelLocal),
            golesVisitante: Number(golesDelVisitante),
            figuraId: Number(figuraId)
        };
        this.sdk = new SimulacionConnector(envio);
        const juego = this.sdk.jugar();
        juego.then((val) => {
            deshabilitarBotones(id, JSON.parse(val).textoResultado);
            var idDeSelectFigura = '#figura-{partidoId}'.replace('{partidoId}', id);
            $(idDeSelectFigura).attr('disabled', 'disabled');
        })
        .catch((err) => {
            console.error(err);
            var idResultadoPartido = '#partido-resultado-{partidoId}'.replace('{partidoId}', id);
            $(idResultadoPartido).text(err.split('"')[5]);
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
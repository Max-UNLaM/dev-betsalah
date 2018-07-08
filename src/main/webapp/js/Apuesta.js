const apuestaModificarGoles = 'http://localhost:8080/apuesta/cambiar-goles-apostados';
const apuestaModificarGolesParams = "?apuestaId={apuestaId}&equipo={equipo}&accion={accion}";
const idCantidadGolesApostados = '#apuesta-goles-{equipo}-{apuestaId}';

function modificarGolesApostados(dataset){

    var parametros = apuestaModificarGolesParams
        .replace("{apuestaId}", dataset.apuestaid)
        .replace("{equipo}", dataset.equipo)
        .replace("{accion}", dataset.accion);

    $.ajax({
        url: apuestaModificarGoles + parametros,
        type: 'PUT',
        headers: {
            "Content-type":"application/json"
        },
        success: function(data) {
            var idActual = idCantidadGolesApostados
                .replace("{equipo}", dataset.equipo)
                .replace("{apuestaId}", dataset.apuestaid);

            $(idActual).text(data);

            console.log('Goles cambiados correctamente.');
        }
    });
}
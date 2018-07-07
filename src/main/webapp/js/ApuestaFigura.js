const cambiarFiguraUrl = 'http://localhost:8080/apuesta/cambiar-figura';
const cambiarFiguraParams = '?apuestaId={apuestaId}&figuraId={figuraId}';
const idSelect = '#apuesta-figura-{apuestaId} option:selected';

function apostarFigura(apuestaId){
    var idSelectActual = idSelect.replace("{apuestaId}", apuestaId);

    var figuraId = $(idSelectActual).val();
    var figuraNombre = $(idSelectActual).text();

    var parametros = cambiarFiguraParams
        .replace("{apuestaId}", apuestaId)
        .replace("{figuraId}", figuraId);

    $.ajax({
        url: cambiarFiguraUrl + parametros,
        type: 'PUT',
        headers: {
            "Content-type":"application/json"
        },
        success: function(data) {
            console.log('Figura apostada correctamente. Apuesta ID: ' + apuestaId + '. Figura ID: ' + figuraId + '. Nombre: ' + figuraNombre +'.');
        }
    });
}
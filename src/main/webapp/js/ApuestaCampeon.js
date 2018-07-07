const setearCampeonUrl = 'http://localhost:8080/apuesta-campeon/setear-campeon';
const apuestaCampeonParams = '?apostadorId={apostadorId}&equipoId={equipoId}';

function setearApuestaCampeon(apostadorId){
    var equipoId = $('#campeon').val();

    var parametros = apuestaCampeonParams
                    .replace("{apostadorId}", apostadorId)
                    .replace("{equipoId}", equipoId);

    $.ajax({
        url: setearCampeonUrl + parametros,
        type: 'PUT',
        headers: {
            "Content-type":"application/json"
        },
        success: function(data) {
            console.log('Campeón cargado correctamente.');
        }
    });
}

function actualizarBoton() {
    var submit = $('#submit');

    submit.text('Apostar campeón');
    submit.removeAttr('disabled');
}


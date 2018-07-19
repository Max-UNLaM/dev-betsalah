const hacerNuevoAdminUrl = 'http://localhost:8080/usuario/hacer-admin';
const hacerNuevoAdminParams = "?idNuevoAdmin={idNuevoAdmin}";
const idUsuarioBoton = '#usuario-{usuarioId}-button';
const idUsuarioRol = '#usuario-{usuarioId}-rol';

function hacerAdmin(dataset){

    var parametros = hacerNuevoAdminParams
        .replace("{idNuevoAdmin}", dataset.usuarioid);

    $.ajax({
        url: hacerNuevoAdminUrl + parametros,
        type: 'POST',
        headers: {
            "Content-type":"application/json"
        },
        success: function(data) {
            var idActualBoton = idUsuarioBoton
                .replace("{usuarioId}", dataset.usuarioid);

            var idActualRol = idUsuarioRol
                .replace("{usuarioId}", dataset.usuarioid);

            $(idActualBoton).attr("disabled", "disabled");
            $(idActualRol).text("Admin")

            console.log('El usuario elegido ahora es adminsitrador.');
        }
    });
}
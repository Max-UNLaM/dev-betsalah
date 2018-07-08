<%@include file="header.jsp" %>

<h2>Administrar usuarios</h2>

<table class="table table-striped">
    <thead>
    <tr>
        <th class="col-xs-9">Usuario</th>
        <th class="col-xs-2">Rol</th>
        <th class="col-xs-1">Hacer admin</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${usuarios}" var="usuarioActual">
        <tr ${(usuario.id == usuarioActual.id) ? 'class="bg-blue font-weight-bold"' : ''}>
            <td>${usuarioActual.nombre}</td>
            <td id="usuario-${usuarioActual.id}-rol">${usuarioActual.rol}</td>
            <td><button ${usuarioActual.rol eq 'Admin' ? 'disabled="disabled"' : ''} onclick="hacerAdmin(this.dataset)" id="usuario-${usuarioActual.id}-button" data-usuarioid="${usuarioActual.id}" class="btn btn-primary">Hacer admin</button></td>
        </tr>
    </c:forEach>
    </tbody>

<%@include file="footer.jsp" %>
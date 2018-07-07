<%@include file="header.jsp" %>

  <table class="table table-striped">
    <thead>
      <tr>
        <th>Usuario</th>
        <th>Puntaje</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${usuarios}" var="usuarioActual">
      <tr ${(usuario.id == usuarioActual.id) ? 'class="bg-blue font-weight-bold"' : ''}>
        <td>${usuarioActual.nombre}</td>
        <td>${usuarioActual.puntaje}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>

<%@include file="footer.jsp" %>
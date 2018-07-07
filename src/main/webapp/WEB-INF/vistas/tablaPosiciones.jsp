<%@include file="header.jsp" %>

  <table class="table table-striped">
    <thead>
      <tr>
        <th>Usuario</th>
        <th>Puntaje</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${usuarios}" var="usuario">
      <tr>
        <td>${usuario.nombre}</td>
        <td>${usuario.puntaje}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>

<%@include file="footer.jsp" %>
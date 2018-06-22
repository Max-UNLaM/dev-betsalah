<%--
  Created by IntelliJ IDEA.
  User: maximiliano
  Date: 21/06/18
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Simulación</title>
</head>
<body>
<table class="table table-striped">
    <thead>
    <tr>
        <th>Local</th>
        <th>Visitante</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${partidos}" var="partido">
        <tr>
            <td>${partido.local_id}</td>
            <td>${partido.visitante_id}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

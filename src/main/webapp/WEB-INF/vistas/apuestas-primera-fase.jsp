<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css" />">
    <link rel="stylesheet" href="<c:url value="/css/bootstrap-theme.min.css" />">
    <link rel="stylesheet" href="<c:url value="/css/styles.css" />">
</head>
<body>
<div class = "container">
    <c:if test="${not empty apuestas}">
        <h4>Bienvenido ${usuario.nombre}, por favor completa tus pronosticos para la primera fase</h4>

        <table class="table">
            <thead>
            <tr>
                <th class="text-center" style="width: 20%">Local</th>
                <th class="text-center" style="width: 20%">Goles local</th>
                <th class="text-center" style="width: 20%">Goles visitante</th>
                <th class="text-center" style="width: 20%">Visitante</th>
                <th class="text-center" style="width: 20%">Figura</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${apuestas}" var="apuesta" varStatus="status">
                <tr>
                    <td class="text-center">${apuesta.partido.local.nombre}</td>
                    <td class="text-center"><button id="${usuario.id}-${apuesta.partido.id}-local-resta" data-user="${usuario.id}" data-apuesta="${apuesta.id}" data-equipo="local" data-accion="resta" class="btn btn-danger">-</button> ${apuesta.golesLocal} <button id="${usuario.id}-${apuesta.partido.id}-local-suma" data-user="${usuario.id}" data-apuesta="${apuesta.id}" data-equipo="local" data-accion="suma" class="btn btn-primary">+</button></td>
                    <td class="text-center"><button id="${usuario.id}-${apuesta.partido.id}-visitante-resta" data-user="${usuario.id}" data-apuesta="${apuesta.id}" data-equipo="visitante" data-accion="resta" class="btn btn-danger">-</button> ${apuesta.golesVisitante} <button id="${usuario.id}-${apuesta.partido.id}-visitante-suma" data-user="${usuario.id}" data-apuesta="${apuesta.id}" data-equipo="visitante" data-accion="suma" class="btn btn-primary">+</button></td>
                    <td class="text-center">${apuesta.partido.visitante.nombre}</td>
                    <td class="text-center"><input type="text" placeholder="Figura"></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>
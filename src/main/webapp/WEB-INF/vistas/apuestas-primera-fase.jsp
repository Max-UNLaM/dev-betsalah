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
                    <td class="text-center"><button id="${apuesta.partido.id}-local-resta" data-apuesta="${apuesta.id}" data-equipo="local" data-accion="resta" class="btn btn-danger">-</button> ${apuesta.golesLocal} <button id="${apuesta.partido.id}-local-suma" data-apuesta="${apuesta.id}" data-equipo="local" data-accion="suma" class="btn btn-primary">+</button></td>
                    <td class="text-center"><button id="${apuesta.partido.id}-visitante-resta" data-apuesta="${apuesta.id}" data-equipo="visitante" data-accion="resta" class="btn btn-danger">-</button> ${apuesta.golesVisitante} <button id="${apuesta.partido.id}-visitante-suma" data-apuesta="${apuesta.id}" data-equipo="visitante" data-accion="suma" class="btn btn-primary">+</button></td>
                    <td class="text-center">${apuesta.partido.visitante.nombre}</td>
                    <!--<td class="text-center"><input type="text" placeholder="Figura"></td>-->
                    <td class="text-center"><select name="jugador">
    					<c:forEach items="${jugadores}" var="jugadores">
        				<c:choose>
        				<c:when test="${jugadores.equipo.id == apuesta.partido.local.id}">
        				<option value="${jugadores.id}"><c:out value="${apuesta.partido.local.nombre3caracteres} - ${jugadores.nombreCompleto}" /></option></c:when>
        				<c:when test="${jugadores.equipo.id == apuesta.partido.visitante.id}">
        				<option value="${jugadores.id}"><c:out value="${apuesta.partido.visitante.nombre3caracteres} - ${jugadores.nombreCompleto}" /></option></c:when>
        				</c:choose>
   				 		</c:forEach>
					</select></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
<!-- Placed at the end of the document so the pages load faster -->
<script src="<c:url value="/js/jquery-1.11.3.min.js" />" ></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="<c:url value="/js/bootstrap.min.js" />" type="text/javascript"></script>
</body>
</html>
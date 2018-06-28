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
<div class="container col-md-12">
    <c:if test="${not empty partidos}">
        <h4>Bienvenido ${usuario.nombre}, por favor completa simula los partidos</h4>
        <table class="table">
            <thead>
            <tr>
                <th class="col-md-2 text-center" style="width: 20%">Local</th>
                <th class="col-md-2 text-center" style="width: 20%">Goles local</th>
                <th class="col-md-2 text-center" style="width: 20%">Goles visitante</th>
                <th class="col-md-2 text-center" style="width: 20%">Visitante</th>
                <th class="col-md-2 text-center" style="width: 20%">Figura</th>
                <th class="col-md-2 text-center">Simular</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="#{partidos}" var="partido" varStatus="status">
                <tr>
                    <td class="text-center">${partido.local.nombre}</td>
                    <td class="text-center">
                        <button onclick="conexion.editarGoles(this.dataset)" id="${partido.id}-local-resta" data-id="${partido.id}" data-equipo="local" data-accion="resta" class="btn btn-danger">-</button>
                        <span id="goles-local-${partido.id}">${partido.golesLocal}</span>
                        <button onclick="conexion.editarGoles(this.dataset)" id="${partido.id}-local-suma" data-id="${partido.id}" data-equipo="local" data-accion="suma" class="btn btn-primary">+</button></td>
                    <td class="text-center">
                        <button onclick="conexion.editarGoles(this.dataset)" id="${partido.id}-visitante-resta" data-id="${partido.id}" data-equipo="visitante" data-accion="resta" class="btn btn-danger">-</button>
                        <span id="goles-visitante-${partido.id}">${partido.golesVisitante}</span>
                        <button onclick="conexion.editarGoles(this.dataset)" id="${partido.id}-visitante-suma" data-id="${partido.id}" data-equipo="visitante" data-accion="suma" class="btn btn-primary">+</button></td>
                    <td class="text-center">${partido.visitante.nombre}</td>
                    <td class="text-center"><input type="text" placeholder="Figura"></td>
                    <td class="text-center"><button ${partido.jugado ? 'disabled="disabled"' : ''} onclick="conexion.simularPartidos('${partido.id}')" id="jugar-partido-${partido.id}" data-partidoid="${partido.id}">JUGAR</button></td>
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
<script src="<c:url value="/js/SimulacionConnector.js" />" type="text/javascript"></script>
<script src="<c:url value="/js/Simulacion.js" />" type="text/javascript"></script>
</body>
</html>
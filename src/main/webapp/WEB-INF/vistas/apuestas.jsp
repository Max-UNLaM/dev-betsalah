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
<div class = "container-fluid">
    <c:if test="${not empty apuestas}">
        <h3 class="text-center">${fase} - Pronostico de ${usuario.nombre}</h3>

        <table class="table">
            <thead>
            <tr>
                <th class="text-center col-xs-1">Local</th>
                <th class="text-center col-xs-1">Goles local</th>
                <th class="text-center col-xs-1">Goles visitante</th>
                <th class="text-center col-xs-1">Visitante</th>
                <th class="text-center col-xs-1">Resultado</th>
                <th class="text-center col-xs-2">Figura apostada</th>
                <th class="text-center col-xs-2">Figura</th>
                <th class="text-center col-xs-1">Puntos</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${apuestas}" var="apuesta" varStatus="status">
                <tr>
                    <td class="text-center col-xs-1">
                        <c:if test="${not empty apuesta.partido.local.nombre}">
                            ${apuesta.partido.local.nombre}
                        </c:if>
                        <c:if test="${empty apuesta.partido.local.nombre}">
                            Por definirse
                        </c:if>
                    </td>

                    <td class="text-center col-xs-1">
                        <button ${apuesta.partido.jugado || empty apuesta.partido.local || empty apuesta.partido.visitante ? 'disabled="disabled"' : ''} onclick="conexion.cambiarPuntos(this.dataset)" id="${apuesta.partido.id}-local-resta" data-apuestaid="${apuesta.id}" data-equipo="local" data-accion="resta" class="btn btn-danger">-</button>
                        <span id="apuesta-goles-local-${apuesta.id}">${apuesta.golesLocal}</span>
                        <button ${apuesta.partido.jugado || empty apuesta.partido.local || empty apuesta.partido.visitante ? 'disabled="disabled"' : ''} onclick="conexion.cambiarPuntos(this.dataset)" id="${apuesta.partido.id}-local-suma" data-apuestaid="${apuesta.id}" data-equipo="local" data-accion="suma" class="btn btn-primary">+</button>
                    </td>

                    <td class="text-center col-xs-1">
                        <button ${apuesta.partido.jugado || empty apuesta.partido.local || empty apuesta.partido.visitante ? 'disabled="disabled"' : ''} onclick="conexion.cambiarPuntos(this.dataset)" id="${apuesta.partido.id}-visitante-resta" data-apuestaid="${apuesta.id}" data-equipo="visitante" data-accion="resta" class="btn btn-danger">-</button>
                        <span id="apuesta-goles-visitante-${apuesta.id}">${apuesta.golesVisitante}</span>
                        <button ${apuesta.partido.jugado || empty apuesta.partido.local || empty apuesta.partido.visitante ? 'disabled="disabled"' : ''} onclick="conexion.cambiarPuntos(this.dataset)" id="${apuesta.partido.id}-visitante-suma" data-apuestaid="${apuesta.id}" data-equipo="visitante" data-accion="suma" class="btn btn-primary">+</button>
                    </td>

                    <td class="text-center col-xs-1">
                        <c:if test="${not empty apuesta.partido.visitante.nombre}">
                            ${apuesta.partido.visitante.nombre}
                        </c:if>
                        <c:if test="${empty apuesta.partido.visitante.nombre}">
                            Por definirse
                        </c:if>
                    </td>

                    <td class="text-center col-xs-1">
                        <c:if test="${apuesta.partido.jugado eq true}">
                            ${apuesta.partido.golesLocal} - ${apuesta.partido.golesVisitante}
                        </c:if>
                        <c:if test="${apuesta.partido.jugado ne true}">
                            No jugado
                        </c:if>
                    </td>

                    <td class="form-group text-center col-xs-2">
                        <select class="form-control" name="jugador" onchange="apostarFigura(${apuesta.id})" id="apuesta-figura-${apuesta.id}" data-apuestaId="${apuesta.id}" ${apuesta.partido.jugado || empty apuesta.partido.local || empty apuesta.partido.visitante ? 'disabled="disabled"' : ''}>
                            <option disabled selected hidden>
                                <c:if test="${empty apuesta.figura.id}">
                                    Seleccione jugador figura
                                </c:if>
                                <c:if test="${not empty apuesta.figura.id}">
                                    ${apuesta.figura.equipo.nombre3caracteres} - ${apuesta.figura.nombreCompleto}
                                </c:if>
                            </option>
                        <c:forEach items="${jugadores}" var="jugadores">
                        <c:choose>
                        <c:when test="${jugadores.equipo.id == apuesta.partido.local.id}">
                        <option value="${jugadores.id}"><c:out value="${apuesta.partido.local.nombre3caracteres} - ${jugadores.nombreCompleto}" /></option></c:when>
                        <c:when test="${jugadores.equipo.id == apuesta.partido.visitante.id}">
                        <option value="${jugadores.id}"><c:out value="${apuesta.partido.visitante.nombre3caracteres} - ${jugadores.nombreCompleto}" /></option></c:when>
                        </c:choose>
                        </c:forEach>
                        </select>
                    </td>

                    <td class="text-center col-xs-2">
                        <c:if test="${apuesta.partido.jugado eq true}">
                            ${apuesta.partido.figura.equipo.nombre3caracteres} - ${apuesta.partido.figura.nombreCompleto}
                        </c:if>
                        <c:if test="${apuesta.partido.jugado ne true}">
                            No jugado
                        </c:if>
                    </td>

                    <td class="text-center col-xs-1">
                        <c:if test="${apuesta.partido.jugado eq true}">
                            Puntos
                        </c:if>
                        <c:if test="${apuesta.partido.jugado ne true}">
                            0
                        </c:if>
                    </td>
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
<script src="<c:url value="/js/PartidoConnector.js" />" type="text/javascript"></script>
<script src="<c:url value="/js/Apuesta.js" />" type="text/javascript"></script>
<script src="<c:url value="/js/ApuestaFigura.js" />" type="text/javascript"></script>
</body>
</html>
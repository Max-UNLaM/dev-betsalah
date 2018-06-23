<!DOCTYPE html>
<html>
<head>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<div class = "container">

    <c:if test="${not empty apuestas}">
        <h4>Bienvenido ${usuario.nombre}, por favor completa tus pronosticos para la primera fase</h4>

        <form:form modelAttribute="apuestas" action="/apuesta/actualizar-apuestas-primera-fase" method="POST">
        <table class="table">
            <thead>
            <tr>
                <th class="text-right" style="width: 45%">Local</th>
                <th class="text-center" style="width: 5%">Goles local</th>
                <th class="text-center" style="width: 5%">Goles visitante</th>
                <th class="text-left" style="width: 45%">Visitante</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${apuestas}" var="apuesta" varStatus="loopStatus">
                    <tr>
                        <td class="text-right">${apuesta.partido.local.nombre}</td>
                        <td><input name="list[${loopStatus.index}].golesLocal" type="number" value="${apuesta.golesLocal }"/></td>
                        <td><input name="list[${loopStatus.index}].golesVisitante" type="number" value="${apuesta.golesVisitante }"/></td>
                        <td class="text-left">${apuesta.partido.visitante.nombre}</td>
                    </tr>

                </c:forEach>
            </tbody>
        </table>
            <input class="btn btn-primary" type="submit" value="Guardar pronostico" />
        </form:form>
    </c:if>


</div>
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div>

</div>
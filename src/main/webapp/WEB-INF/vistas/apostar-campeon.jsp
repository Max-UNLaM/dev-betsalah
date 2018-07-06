<%@include file="util/header.jsp" %>

        <h2 class="text-center">Apostar campeon</h2>

        <c:if test="${empty apuestaCampeon.equipoApostado}">
            <h4 class="text-center">Bienvenido ${usuario.nombre}, es el momento de apostar por el campeón del torneo. Te recordamos que sólo podés apostar por el campeón antes de que comience el torneo y una vez elegido el equipo no vas a poder cambiarlo, así que pensá bien tu decisión</h4>
            <h4 class="text-left">Equipo campeón: </h4>
            <select class="form-control" name="apuestaCampeon" id="campeon" onchange="actualizarBoton()">
                <option disabled selected hidden>Apostar campeón</option>
                <c:forEach items="${equipos}" var="equipo">
                    <option value="${equipo.id}"><c:out value="${equipo.nombre}" /></option>
                </c:forEach>
            </select>

            <button disabled class="btn btn-primary" id="submit" onclick="setearApuestaCampeon('${usuario.id}')">Elegí un equipo</button>
        </c:if>

        <c:if test="${not empty apuestaCampeon.equipoApostado}">
            <h4 class="text-left">Ya apostaste por: ${apuestaCampeon.equipoApostado.nombre}</h4>
            <h4 class="text-left">Si acertás al campeón del torneo vas a sumar 15 puntos extra</h4>
            <h4 class="text-left">Recordá que una vez hecha la apuesta de campeón del torneo no puede ser modificada</h4>
        </c:if>

<%@include file="util/header.jsp" %>
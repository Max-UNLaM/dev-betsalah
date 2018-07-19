<%@include file="header.jsp" %>


    <c:if test="${not empty apuestas}">
        <h3 class="text-center">Tu pronostico - ${fase}</h3>

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
                        <button ${apuesta.partido.jugado || empty apuesta.partido.local || empty apuesta.partido.visitante ? 'disabled="disabled"' : ''} onclick="modificarGolesApostados(this.dataset)" id="${apuesta.partido.id}-local-resta" data-apuestaid="${apuesta.id}" data-equipo="EQUIPO_LOCAL" data-accion="RESTA" class="btn btn-danger">-</button>
                        <span id="apuesta-goles-EQUIPO_LOCAL-${apuesta.id}">${apuesta.golesLocal}</span>
                        <button ${apuesta.partido.jugado || empty apuesta.partido.local || empty apuesta.partido.visitante ? 'disabled="disabled"' : ''} onclick="modificarGolesApostados(this.dataset)" id="${apuesta.partido.id}-local-suma" data-apuestaid="${apuesta.id}" data-equipo="EQUIPO_LOCAL" data-accion="SUMA" class="btn btn-primary">+</button>
                    </td>

                    <td class="text-center col-xs-1">
                        <button ${apuesta.partido.jugado || empty apuesta.partido.local || empty apuesta.partido.visitante ? 'disabled="disabled"' : ''} onclick="modificarGolesApostados(this.dataset)" id="${apuesta.partido.id}-visitante-resta" data-apuestaid="${apuesta.id}" data-equipo="EQUIPO_VISITANTE" data-accion="RESTA" class="btn btn-danger">-</button>
                        <span id="apuesta-goles-EQUIPO_VISITANTE-${apuesta.id}">${apuesta.golesVisitante}</span>
                        <button ${apuesta.partido.jugado || empty apuesta.partido.local || empty apuesta.partido.visitante ? 'disabled="disabled"' : ''} onclick="modificarGolesApostados(this.dataset)" id="${apuesta.partido.id}-visitante-suma" data-apuestaid="${apuesta.id}" data-equipo="EQUIPO_VISITANTE" data-accion="SUMA" class="btn btn-primary">+</button>
                    </td>

                    <td class="text-center col-xs-1">
                        <c:if test="${not empty apuesta.partido.visitante.nombre}">
                            ${apuesta.partido.visitante.nombre}
                        </c:if>
                        <c:if test="${empty apuesta.partido.visitante.nombre}">
                            Por definirse
                        </c:if>
                    </td>

                    <c:if test="${apuesta.partido.jugado eq true}">
                        <td ${(apuesta.golesLocal eq apuesta.partido.golesLocal) && (apuesta.golesVisitante eq apuesta.partido.golesVisitante) ? 'class="text-center col-xs-2 bg-green"' : 'class="text-center col-xs-2 bg-red"'}>
                                ${apuesta.partido.golesLocal} - ${apuesta.partido.golesVisitante}
                        </td>
                    </c:if>
                    <c:if test="${apuesta.partido.jugado ne true}">
                        <td class="text-center col-xs-1">
                            No jugado
                        </td>
                    </c:if>

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


                    <c:if test="${apuesta.partido.jugado eq true}">
                        <td ${apuesta.figura.id eq apuesta.partido.figura.id ? 'class="text-center col-xs-2 bg-green"' : 'class="text-center col-xs-2 bg-red"'}>
                        ${apuesta.partido.figura.equipo.nombre3caracteres} - ${apuesta.partido.figura.nombreCompleto}
                        </td>
                    </c:if>
                    <c:if test="${apuesta.partido.jugado ne true}">
                        <td class="text-center col-xs-2">
                        No jugado
                        </td>
                    </c:if>


                    <td class="text-center col-xs-1">
                        <c:if test="${apuesta.partido.jugado eq true}">
                            <c:if test="${not empty apuesta.puntaje}">
                                ${apuesta.puntaje}
                            </c:if>
                            <c:if test="${empty apuesta.puntaje}">
                                0
                            </c:if>
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

<%@include file="footer.jsp" %>

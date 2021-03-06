<%@include file="../header.jsp" %>

<c:if test="${not empty partidos}">
        <h4>Bienvenido ${usuario.nombre}, por favor completa simula los partidos</h4>
        <table class="table">
            <thead>
            <tr>
                <th class="col-md-2 text-center">Local</th>
                <th class="col-md-1 text-center">Goles local</th>
                <th class="col-md-1 text-center">Goles visitante</th>
                <th class="col-md-2 text-center">Visitante</th>
                <th class="col-md-2 text-center">Figura</th>
                <th class="col-md-3 text-center">Resultado</th>
                <th class="col-md-1 text-center">Simular</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="#{partidos}" var="partido" varStatus="status">
                <tr>
                    <td class="text-center">${partido.local.nombre}</td>
                    <td class="text-center">
                        <button ${(partido.jugado || !partido.local.definido || !partido.visitante.definido) ? 'disabled="disabled"' : ''} onclick="conexion.editarGoles(this.dataset)" id="${partido.id}-local-resta" data-id="${partido.id}" data-equipo="local" data-accion="resta" class="btn btn-danger">-</button>
                        <span id="goles-local-${partido.id}">${partido.golesLocal}</span>
                        <button ${(partido.jugado || !partido.local.definido || !partido.visitante.definido) ? 'disabled="disabled"' : ''} onclick="conexion.editarGoles(this.dataset)" id="${partido.id}-local-suma" data-id="${partido.id}" data-equipo="local" data-accion="suma" class="btn btn-primary">+</button></td>
                    <td class="text-center">
                        <button ${(partido.jugado || !partido.local.definido || !partido.visitante.definido) ? 'disabled="disabled"' : ''} onclick="conexion.editarGoles(this.dataset)" id="${partido.id}-visitante-resta" data-id="${partido.id}" data-equipo="visitante" data-accion="resta" class="btn btn-danger">-</button>
                        <span id="goles-visitante-${partido.id}">${partido.golesVisitante}</span>
                        <button ${(partido.jugado || !partido.local.definido || !partido.visitante.definido) ? 'disabled="disabled"' : ''} onclick="conexion.editarGoles(this.dataset)" id="${partido.id}-visitante-suma" data-id="${partido.id}" data-equipo="visitante" data-accion="suma" class="btn btn-primary">+</button></td>
                    <td class="text-center">${partido.visitante.nombre}</td>
                    <td class="form-group">
                        <select class="form-control" name="jugador" id="figura-${partido.id}" ${(partido.jugado || !partido.local.definido || !partido.visitante.definido) ? 'disabled="disabled"' : ''}>
                    	<option disabled selected hidden>Seleccione jugador figura</option>
    					<c:forEach items="${jugadores}" var="jugadores">
        				<c:choose>
        				<c:when test="${jugadores.equipo.id == partido.local.id}">
        				<option value="${jugadores.id}"><c:out value="${partido.local.nombre3caracteres} - ${jugadores.nombreCompleto}" /></option></c:when>
        				<c:when test="${jugadores.equipo.id == partido.visitante.id}">
        				<option value="${jugadores.id}"><c:out value="${partido.visitante.nombre3caracteres} - ${jugadores.nombreCompleto}" /></option></c:when>
        				</c:choose>
   				 		</c:forEach>
					</select>
					</td>
                    <td class="text-center ${partido.jugado ? 'success' : 'primary'}" id="partido-resultado-${partido.id}">${partido.resultado}</td>
                    <td class="text-center"><button class="btn btn-primary" ${(partido.jugado || !partido.local.definido || !partido.visitante.definido) ? 'disabled="disabled"' : ''} onclick="conexion.simularPartidos('${partido.id}')" id="jugar-partido-${partido.id}" data-partidoid="${partido.id}">JUGAR</button></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>

<%@include file="../footer.jsp" %>
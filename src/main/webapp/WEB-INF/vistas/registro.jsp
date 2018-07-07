<%@include file="header.jsp" %>

    <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <%--Definicion de un form asociado a la accion /validar-login por POST. Se indica ademas que el model attribute se--%>
        <%--debe referenciar con el nombre usuario, spring mapea los elementos de la vista con los atributos de dicho objeto--%>
        <%--para eso debe coincidir el valor del elemento path de cada input con el nombre de un atributo del objeto --%>
        <form:form action="validar-registro" method="POST" modelAttribute="usuario">
            <h3 class="form-signin-heading">BetSalah - Registro</h3>
            <hr class="colorgraph"><br>

            <%--Elementos de entrada de datos, el elemento path debe indicar en que atributo del objeto usuario se guardan los datos ingresados--%>
            <form:input path="nombre" id="nombre" placeholder="Crea username" type="text" class="form-control" />
            <form:input path="password" type="password" id="password" placeholder="Crea password" class="form-control"/>

            <button class="btn btn-lg btn-primary btn-block" Type="Submit"/>Registro</button>
        </form:form>

        <a href="/login"><h4>Ir a login</h4></a>

        <%--Bloque que es visible si el elemento error no estÃ¡ vacÃ­o	--%>
        <c:if test="${not empty error}">
            <h4><span>${error}</span></h4>
            <br>
        </c:if>
    </div>

<%@include file="footer.jsp" %>
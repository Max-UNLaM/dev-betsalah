<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css" />">
    <link rel="stylesheet" href="<c:url value="/css/bootstrap-theme.min.css" />">
    <link rel="stylesheet" href="<c:url value="/css/styles.css" />">
    <link rel="stylesheet" href="<c:url value="/css/menu-usuario.css" />">
    <link rel="stylesheet" href="<c:url value="/css/menu-admin.css" />">

    <script src="<c:url value="/js/jquery-1.11.3.min.js" />" ></script>
    <script src="<c:url value="/js/bootstrap.min.js" />" type="text/javascript"></script>

    <script src="<c:url value="/js/Apuesta.js" />" type="text/javascript"></script>
    <script src="<c:url value="/js/ApuestaFigura.js" />" type="text/javascript"></script>
    <script src="<c:url value="/js/ApuestaCampeon.js" />" type="text/javascript"></script>
    <script src="<c:url value="/js/Simulacion.js" />" type="text/javascript"></script>
    <script src="<c:url value="/js/SimulacionConnector.js" />" type="text/javascript"></script>
    <script src="<c:url value="/js/AdministrarUsuarios.js" />" type="text/javascript"></script>


    <script src="<c:url value="/js/PartidoConnector.js" />" type="text/javascript"></script>

</head>
<body>
    <div class = "container-fluid">
        <c:if test="${not empty sesion}">
            <div class="text-right">${usuario.nombre} <a href="/cerrar-sesion">Cerrar sesion</a></div>
            <c:if test="${usuario.rol eq 'ROL_ADMIN'}">
            <!-- Navegacion admin -->
                <%@include file="navegacion-admin.jsp" %>
            </c:if>
            <!-- Navegacion usuario -->
                <%@include file="navegacion-usuario.jsp" %>
        </c:if>


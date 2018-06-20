<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
	<body>	
	<div class="container">          
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Usuario</th>
        <th>Puntaje</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${usuarios}" var="usuario">
      <tr>
        <td>${usuario.nombre}</td>
        <td>${usuario.puntaje}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
		</div>
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>
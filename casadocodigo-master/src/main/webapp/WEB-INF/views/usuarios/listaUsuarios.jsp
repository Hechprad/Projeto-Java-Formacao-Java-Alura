<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate titulo="Lista de Usuários">

	<div class="container">
		<h1>Lista de Usuarios</h1>
		<p> ${sucesso} </p>
		<p> ${falha} </p>
	
		<table class="table table-bordered table-striped table-hover">
			<tr>
				<th>Nome</th>
				<th>Email</th> 
			</tr>
			<c:forEach items="${usuarios}" var="usuario">
				<tr>
					<td>${usuario.nome}</td>
					<td>${usuario.email}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</tags:pageTemplate>
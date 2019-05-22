<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate titulo="Editando roles de ${usuario.nome}">

<c:url value="/resources/css" var="cssPath" />
<c:url value="/resources/js" var="jp"/>
<link rel="stylesheet" href="${cssPath}/bootstrap.min.css" />
<link rel="stylesheet" href="${cssPath}/bootstrap-theme.min.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="${jp}/bootstrap.min.js"></script>

	<div class="container">
		<h1>Cadastro de permissões para ${usuario.nome }</h1>
		<form:form action="${s:mvcUrl('UC#atualizaPermissoesDoUsuario').build() }" method="post" commandName="usuario" enctype="application/x-www-form-urlencoded">
			<div class="form-group">
				
				<form:input path="nome" type="hidden" name="${usuario.nome}" />
				<form:input path="email" type="hidden" name="${usuario.email}" />
				<form:input path="senha" type="hidden" name="${usuario.senha}" />
				<form:input path="senhaRepetida" type="hidden" name="${usuario.senhaRepetida}" />
				Permissões: 
				<c:forEach items="${roles}" var="role" varStatus="contador_um">
					<c:if test="${fn:length(roles) ge contador_um.count}">
						<form:checkbox path="roles" value="${role.nome}" />
						<label>${role.nome}</label>
					</c:if>
				</c:forEach>
			</div>
			
			<button type="submit" class="btn btn-primary">Atualizar</button>
		</form:form>
	
	</div>
	<br/>
	
</tags:pageTemplate>
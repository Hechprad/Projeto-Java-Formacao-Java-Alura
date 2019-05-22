<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate titulo="Lista de Usuários">
	    
	<security:authorize access="hasRole('ROLE_ADMIN')">
	<div class="container">
			<h1><a href="${s:mvcUrl('UC#formUsuario').build() }" rel="nofollow"><fmt:message key="lista.usuarios.novo_usuario"/></a></h1>
		<h1><fmt:message key="lista.usuarios.titulo"/></h1>
		
		<c:if test="${sucesso != null}"> 
		<br/>
			<div class="alert alert-success text-center alert-dismissible" role="alert" style="font-size: 20px;">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				${sucesso}
			</div>
		</c:if>
		<c:if test="${falha != null}"> 
			<div class="alert alert-danger text-center alert-dismissible" role="alert" style="font-size: 20px;">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				${falha}
			</div>
		</c:if>
		<c:if test="${permissoesAlteradasComSucesso != null}"> 
			<div class="alert alert-success text-center alert-dismissible" role="alert" style="font-size: 20px;">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				${permissoesAlteradasComSucesso}
			</div>
		</c:if>
		<table class="table table-bordered table-striped table-hover">
			<tr>
				<th><fmt:message key="lista.usuarios.nome"/></th>
				<th><fmt:message key="lista.usuarios.email"/></th>
				<th><fmt:message key="lista.usuarios.role"/></th>
				<th><img src='<c:url value="/resources/imagens/editar.png" />' alt="Editar"/></th>
			</tr>
			<c:forEach items="${usuarios}" var="usuario">
				<tr>
					<td>${usuario.nome}</td>
					<td>${usuario.email}</td>
					<td>${usuario.roles}</td>
					<td>
						<a href="${s:mvcUrl('UC#editaRole').arg(0, usuario.email).build() }">
							<img src='<c:url value="/resources/imagens/adicionar.png" />' alt="adicionar">
						</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	</security:authorize>

</tags:pageTemplate>
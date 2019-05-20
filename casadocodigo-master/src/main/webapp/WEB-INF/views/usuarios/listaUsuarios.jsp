<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate titulo="Lista de Usuários">
	    
	<div class="container">
		
		<h1><a href="${s:mvcUrl('UC#formUsuario').build() }" rel="nofollow"><fmt:message key="lista.usuarios.novo_usuario"/></a></h1>
		<h1><fmt:message key="lista.usuarios.titulo"/></h1>
		
		<c:if test="${sucesso != null}"> 
		<br/>
			<div class="alert alert-success text-center alert-dismissible" role="alert" style="font-size: 30px;">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				${sucesso}
			</div>
		</c:if>
		<c:if test="${falha != null}"> 
			<div class="alert alert-danger text-center alert-dismissible" role="alert" style="font-size: 30px;">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				${falha}
			</div>
		</c:if>
	
		<table class="table table-bordered table-striped table-hover">
			<tr>
				<th><fmt:message key="lista.usuarios.nome"/></th>
				<th><fmt:message key="lista.usuarios.email"/></th>
				<th><fmt:message key="lista.usuarios.role"/></th>
				<th><img src="${contextPath}resources/imagens/editar.png" alt="Editar"/></th>
			</tr>
			<c:forEach items="${usuarios}" var="usuario">
				<tr>
					<td>${usuario.nome}</td>
					<td>${usuario.email}</td>
					<td>
					<c:forEach items="${usuario.roles}" var="role">
							<c:if test="${fn:length(usuario.roles) gt contador.count}">
								${role.nome},
							</c:if>
							${role.nome}
					</c:forEach>
					</td>
					<td>
						<form:form action="${s:mvcUrl('UC#adicionarRole').arg(0, item.produto.id).arg(1,item.tipoPreco).build() }" method="POST">
							<input type="image" src="${contextPath}resources/imagens/adicionar.png" 
								alt="Adicionar" title="Adicionar" />
						</form:form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</tags:pageTemplate>
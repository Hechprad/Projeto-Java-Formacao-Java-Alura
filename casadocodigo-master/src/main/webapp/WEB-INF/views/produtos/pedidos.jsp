<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate titulo="Lista de pedidos Atuais">

	<security:authorize access="hasRole('ROLE_ADMIN')">
	<div class="container">
		<h1><fmt:message key="pedidos.cabecalho"/></h1>
	
		<table class="table table-bordered table-striped table-hover">
			<tr>
				<th><fmt:message key="pedidos.id"/></th>
				<th><fmt:message key="pedidos.valor"/></th>
				<th><fmt:message key="pedidos.data_pedido"/></th> 
				<th><fmt:message key="pedidos.titulos"/></th>
			</tr>
			<c:forEach items="${response}" var="response">
				<tr>
					<td>${response.id}</td>
					<td>${response.valor}</td>
					<td><fmt:formatDate value="${response.data.time}" pattern="dd/MM/yyyy"/></td>
					<td>
						<c:forEach items="${response.produtos}" var="produtos" varStatus="contador" >
							<c:if test="${fn:length(response.produtos) gt contador.count}">
								${produtos.titulo},
							</c:if>
							${produtos.titulo}
						</c:forEach>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	</security:authorize>
	
</tags:pageTemplate>
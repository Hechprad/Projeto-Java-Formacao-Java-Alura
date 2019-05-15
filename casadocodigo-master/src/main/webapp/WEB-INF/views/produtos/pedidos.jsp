<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate titulo="Lista de pedidos">

	<div class="container">
		<h1>Lista de Pedidos</h1>
	
		<table class="table table-bordered table-striped table-hover">
			<tr>
				<th>Id</th>
				<th>Valor</th>
				<th>Data Pedido</th> 
				<th>Títulos</th>
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

</tags:pageTemplate>
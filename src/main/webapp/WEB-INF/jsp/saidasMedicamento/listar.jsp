<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:import url="../import/css.jsp"></c:import>
<c:import url="../import/javascripts.jsp"></c:import>
<title>Saida Medicamentos</title>
</head>
<body>
	<c:import url="../import/header.jsp"></c:import>
	<table class="table table-hover">
		<thead>
			<td><strong>Data da Saida</strong></td>
			<td><strong>Quantidade</strong></td>
			<td><strong>Codigo Lote</strong></td>
			<td><strong>Nome Medico</strong></td>
			<td><strong>Nome Pacinte</strong></td>
			
		</thead>
		<!--Sql para buscar consultas na fila de antendimento no banco de dados-->
		<tbody>
			<c:forEach items="${saidasMedicamentoList}" var="saidasMedicamento">
				<tr>
					<td><fmt:formatDate  value="${saidasMedicamento.dataSaida.time}" pattern="dd/MM/yyyy" /></td>
					<td>${saidasMedicamento.quantidade}</td>
					<td>${saidasMedicamento.lote.nomeLote}</td>
					<td>${saidasMedicamento.medico.nome}</td>
					<td>${saidasMedicamento.paciente.nome}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:import url="../import/footer.jsp"></c:import>
</body>
<c:import url="../import/footer.jsp"></c:import>
</html>
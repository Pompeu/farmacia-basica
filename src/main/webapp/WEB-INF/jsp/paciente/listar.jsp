<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:import url="../import/css.jsp"></c:import>


<title>Medicos</title>
</head>
<body>
<c:import url="../import/header.jsp"></c:import>
	<table class="table table-hover">
		<thead>
			<td><strong>Nome</strong></td>
			<td><strong>CPF</strong></td>
			<td><strong>NaScimento</strong></td>
			<td><strong>Nome Mãe</strong></td>
			<td><strong>Cidade</strong></td>
			<td><strong>Estado</strong></td>
			<td><strong>Editar</strong></td>
			<td><strong>Excluir</strong></td>
		</thead>
		<!--Sql para buscar consultas na fila de antendimento no banco de dados-->
		<tbody>
			<c:forEach items="${pacienteList}" var="paciente">
				<tr>
					
					<td>${paciente.nome}</td>
					<td>${paciente.cpf}</td>
					<td> <fmt:formatDate value="${paciente.dataNascimento.time}" pattern="dd/MM/yyyy"/></td>
					<td>${paciente.nomeMae}</td>	
					<td>${paciente.cidade.nome}</td>
					<td>${paciente.cidade.estado.uf}</td>
					<td><a
						href="${linkTo[PacienteController].editar}?pkKey=${paciente.pkPaciente}"><button
								type="submit" id="icnEditar" class="btn btn-default">
								<i class="glyphicon glyphicon-edit"></i>
							</button></a></td>
					<td><a
						href="${linkTo[PacienteController].deletar}?pkKey=${paciente.pkPaciente}">
							<button type="submit" id="icnCancelar" class="btn btn-danger">
								<i class="glyphicon glyphicon-remove"></i>
							</button>
					</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:import url="../import/javascripts.jsp"></c:import>
</body>
</html>
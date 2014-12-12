<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:import url="../import/css.jsp"></c:import>
<c:import url="../import/javascripts.jsp"></c:import>

<title>Medicos</title>
</head>
<body>
<c:import url="../import/header.jsp"></c:import>
	<table class="table table-hover">
		<thead>
			<td><strong>Nome</strong></td>
			<td><strong>CRM</strong></td>
			<td><strong>Telefone</strong></td>

			<td><strong>Editar</strong></td>
			<td><strong>Excluir</strong></td>
		</thead>
		<!--Sql para buscar consultas na fila de antendimento no banco de dados-->
		<tbody>
			<c:forEach items="${medicoList}" var="medico">
				<tr>
					<td>${medico.nome}</td>
					<td>${medico.crm}</td>
					<td>${medico.telefone}</td>

					<td><a
						href="${linkTo[MedicoController].editar}?pkKey=${medico.pkMedicos}"><button
								type="submit" id="icnEditar" class="btn btn-default">
								<i class="glyphicon glyphicon-edit"></i>
							</button></a></td>
					<td><a
						href="${linkTo[MedicoController].deletar}?pkKey=${medico.pkMedicos}">
							<button type="submit" id="icnCancelar" class="btn btn-danger">
								<i class="glyphicon glyphicon-remove"></i>
							</button>
					</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:import url="../import/footer.jsp"></c:import>
</body>
</html>
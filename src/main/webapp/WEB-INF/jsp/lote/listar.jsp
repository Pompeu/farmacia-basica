<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Lotes</title>
</head>
<body>
	<table class="table table-hover">
		<thead>
			<td><strong>Codigo do Lote</strong></td>
			<td><strong>Quandidate</strong></td>
			<td><strong>Nome do Medicamento</strong></td>

			<td><strong>Editar</strong></td>
			<td><strong>Excluir</strong></td>
		</thead>
		<tbody>
			<c:forEach items="${loteList}" var="lote">
				<tr>
					<td>${lote.nomeLote}</td>
					<td>${lote.qtdMedicamento}</td>
					<td>${lote.medicamento.nomeMedicamento}</td>

					<td><a
						href="${linkTo[LoteController].editar}?pkKey=${lote.pkLote}"><button
								type="submit" id="icnEditar" class="btn btn-default">
								<i class="glyphicon glyphicon-edit"></i>
							</button></a></td>
					<td><a
						href="${linkTo[LoteController].deletar}?pkKey=${lote.pkLote}">
							<button type="submit" id="icnCancelar" class="btn btn-danger">
								<i class="glyphicon glyphicon-remove"></i>
							</button>
					</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
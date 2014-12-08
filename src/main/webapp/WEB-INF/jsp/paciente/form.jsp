<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:import url="../import/css.jsp"></c:import>
<title>Medicamento</title>
</head>
<body>
<!-- String cpf, Date dataNascimento, String nome,
			String nomeMae, Cidade cidade
				<td>${paciente.nome}</td>
					<td>${paciente.cpf}</td>
					<td>${paciente.dataNascimento}</td>
					<td>${paciente.nomeMae}</td> -->
 <fieldset>	
	<form action="create">
		<input type="hidden" value="${paciente.pkPaciente}" name="paciente.pkPaciente">
		<label>Nome</label>
		<input type="text" value="${paciente.nome}" name="paciente.nome">
		<label>CPF</label>
		<input type="text"<fmt:formatDate value="${paciente.cpf}"  type="date" pattern="dd/MM/yyyy"/> name="paciente.cpf">
		<label>Data Nascimento</label>>
		<input type="text" value="${paciente.dataNascimento}" name="paciente.dataNascimento">
		<label>Nome Mãe</label>
		<input type="text" value="${paciente.nomeMae}" name="paciente.nomeMae">
		<label>Cidade</label>
		<input type="text" value="${paciente.cidade.nome}" name="paciente.cidade.nome">
		<label>UF</label>
		<input type="text" value="${paciente.cidade.estado.uf}" name="paciente.cidade.estado.uf">
		<input type="submit" value="adicionar">
	</form>
</fieldset>
<c:import url="../import/javascripts.jsp"></c:import>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:import url="../import/css.jsp"></c:import>

<title>Cadastro Pacientes</title>
</head>
<body>
<c:import url="../import/header.jsp"></c:import>
 <fieldset>	
 <div style="width: 500px; height:400px; margin: 0px auto">
	<form class="form" action="create"  method="post">
		<div class="form-group">
			<legend>Cadastro Pacientes</legend>
			<input class="form-control" type="hidden" value="${paciente.pkPaciente}" name="paciente.pkPaciente">
		</div>
		<div class="form-group">				
			<label>Nome</label>
			<input class="form-control" type="text" value="${paciente.nome}" name="paciente.nome">
		</div>
		<div class="form-group">
			<label>CPF</label>
			<input class="form-control"  type="text" value="${paciente.cpf}"  name="paciente.cpf">
		</div>
		<div class="form-group">
			<label>Data Nascimento</label>
			<input class="form-control" type="text" <fmt:formatDate type="date" value="${paciente.dataNascimento.time}"/> name="paciente.dataNascimento.time">
		</div>
		<div class="form-group">
			<label>Nome Mãe</label>
			<input class="form-control" type="text" value="${paciente.nomeMae}" name="paciente.nomeMae">
		</div>
		<div class="form-group">
			<label>Cidade</label>
			<input class="form-control" type="text" value="${paciente.cidade.nome}" name="paciente.cidade.nome">
			<label>UF</label>
			<input class="form-control" type="text" value="${paciente.cidade.estado.uf}" name="paciente.cidade.estado.uf">
		</div>
		<div style="float: right;" class="form-group">
			<input class="btn btn-primary"  type="submit" value="adicionar">
		</div>
	</form>
</div>
</fieldset>
<c:import url="../import/javascripts.jsp"></c:import>
<c:import url="../import/footer.jsp"></c:import>
</body>
</html>
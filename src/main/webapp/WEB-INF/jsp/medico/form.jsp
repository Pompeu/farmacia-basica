<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:import url="../import/css.jsp"></c:import>

<title>Medico</title>
</head>
<body>
<c:import url="../import/header.jsp"></c:import>
 <div style="width: 500px; height:400px; margin: 0px auto">
 <fieldset>	
 	<form class="form" action="create"  method="post">
 		<legend>Cadastro Medico</legend>
		<input type="hidden" value="${medico.pkMedicos}" name="medico.pkMedicos"/>
		<div class="form-group">
			<label>Nome</label>
			<input class="form-control" type="text" value="${medico.nome}" name="medico.nome"/>
		</div>
		<div class="form-group">
			<label>CRM</label>
			<input class="form-control"type="text" value="${medico.crm}" name="medico.crm"/>
		</div>
		<div class="form-group">
			<label>TELEFONE</label>
			<input class="form-control"type="text" value="${medico.telefone}" name="medico.telefone"/>
		</div>
		<div style="float: right;" class="form-group">
			<input class="btn btn-primary" type="submit" value="Gravar" name="btn">
		</div>
	</form>
</div>
</fieldset>
<c:import url="../import/javascripts.jsp"></c:import>
</body>
</html>
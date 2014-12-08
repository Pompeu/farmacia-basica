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
 <fieldset>	
	<form action="create">
		<input type="hidden" value="${medico.pkMedicos}" name="medico.pkMedicos"/>
		<label>Nome</label>
		<input type="text" value="${medico.nome}" name="medico.nome"/>
		<label>CRM</label>
		<input type="text" value="${medico.crm}" name="medico.crm"/>
		<label>TELEFONE</label>
		<input type="text" value="${medico.telefone}" name="medico.telefone"/>
		<input type="submit" value="Gravar" name="btn">
	</form>
</fieldset>
<c:import url="../import/javascripts.jsp"></c:import>
</body>
</html>
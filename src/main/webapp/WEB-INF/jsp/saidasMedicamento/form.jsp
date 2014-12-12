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
<div style="width: 400px; height:300px; margin: 0px auto">
	<form class="form" action="create"  method="post">
		<legend>Saida de Medicamentos</legend>	
		<input id="medicamento" class="form-control" type="hidden" value="" name="" >			
		<div class="form-group">
		 	 	<label for="quant">Quantidade</label>
				<input id="quant" class="form-control" type="number" value="" name="" required="required"   pattern="[0-9]{2}+$">			
		</div>
		<a class="btn btn-primary" href="<c:url value="/"/>">Voltar Ao Inicio</a>
		<input class="btn btn-primary" type="submit"  value="gravar">			
	</form>
</div>
</body>
<c:import url="../import/footer.jsp"></c:import>
</html>
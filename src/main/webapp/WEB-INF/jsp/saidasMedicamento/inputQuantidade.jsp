<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form id="" action="<c:url value="create"/>" method="post"
	class="navbar-form navbar-left" role="search">
	<div class="form-group">
		<label for="quant">Quantidade</label> <input id="quant"
			class="form-control" type="text" value="${quantidade}"
			name="quantidade" required="required" pattern="[0-9]{2}+$">

	</div>
	<a class="btn btn-primary" href="<c:url value="/"/>">Voltar Ao
		Inicio</a> <input class="btn btn-primary" type="submit" value="gravar">
</form>
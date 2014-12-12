<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="form-group">
	<form id="cpfNun" action="<c:url value="/findpaciente"/>" method="post"
		class="navbar-form navbar-left" role="search">
		<label for="paciente">CPF Paciente</label> <input id="paciente"
			class="form-control" type="text" value="${cpf}" name="cpf"
			required="required" pattern="[0-9a-zA-Z]+$"> <input
			class="btn btn-primary" type="submit" value="buscar">
	</form>
</div>
<div class="resultP"></div>
<script>
	$("#cpfNun").submit(
			function(event) {
				event.preventDefault();
				var $form = $(this), term = $form.find("input[name='cpf']")
						.val(), url = $form.attr("action");
				var posting = $.post(url, {
					cpf : term
				});
				posting.done(function(data) {
					$(".resultP").html(data);
				});
			});
</script>
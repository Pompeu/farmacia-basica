<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="form-group">
	<form id="crmNun" action="<c:url value="/findmedico"/>" method="post"
		class="navbar-form navbar-left" role="search">
		<label for="medico">CRM Medico</label> <input id="medico"
			class="form-control" type="text" value="${crm}" name="crm"
			required="required" pattern="[0-9]+$"> <input
			class="btn btn-primary" type="submit" value="buscar">
	</form>
</div>
<div class="resultM"></div>
<script>
	$("#crmNun").submit(
			function(event) {
				event.preventDefault();
				var $form = $(this), term = $form.find("input[name='crm']")
						.val(), url = $form.attr("action");
				var posting = $.post(url, {
					crm : term
				});
				posting.done(function(data) {
					$(".resultM").html(data);
				});
			});
</script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="form-group">
	<form id="loteNum" action="<c:url value="/findlote"/>" method="post"
		class="navbar-form navbar-left" role="search">
		<label for="lote">Codigo do Lote</label> <input id="lote"
			class="form-control" type="text" value="${lotevalue}" name="lotevalue"
			required="required" pattern="[0-9a-zA-Z]+$"> <input
			style="float: right;" class="btn btn-primary" type="submit"
			value="buscar">
	</form>
</div>
<div class="resultL"></div>
<script>
	$("#loteNum").submit(
			function(event) {
				event.preventDefault();
				var $form = $(this), term = $form.find("input[name='lotevalue']")
						.val(), url = $form.attr("action");
				var posting = $.post(url, {
					lotevalue : term
				});
				posting.done(function(data) {
					$(".resultL").html(data);
				});
			});
</script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:import url="../import/css.jsp"></c:import>
<c:import url="../import/javascripts.jsp"></c:import>

<title>Formulario Medicamentos</title>
</head>
<body>
<c:import url="../import/header.jsp"></c:import>
<div style="width: 900px; height:600px">	
	<form class="form" action="create" role="form" method="post">
	<div style="float: left;width:320; margin: 50px">
		<legend>Entrada de Medicamento</legend>
		 <div class="form-group">
		 	 	<label for="codigo">Nome Lote</label>
		 	 	<input type="hidden" id="lote" value="${lote.pkLote}" name="lote.pkLote">
				<input class="form-control" type="text" id="lote" value="${lote.nomeLote}" name="lote.nomeLote">			
		</div>	
		<div class="form-group">
			<label for="codigo">Codigo Barras</label>
			<input class="form-control" type="number" id="codigo" value="${lote.codBarras}" name="lote.codBarras">
		</div>
		<div class="form-group">
			<label for="nf">Numero Nota Fiscal</label>
			<input class="form-control" type="number" id="nf" value="${lote.numeroNf}" name="lote.numeroNf">
		</div>
		<div class="form-group">
			<label for="quant">Quanditade</label>	
			<input class="form-control" type="number" id="quant value="${lote.qtdMedicamento}" name="lote.qtdMedicamento">
		</div>
		<div class="form-group">
			<label for="un">Unidade Medida</label>	
			<input class="form-control" type="text" id="un" value="${lote.unidade}" name="lote.unidade">
		</div>
		<div class="form-group">
			<label for="entradada">Data Entrada</label>
			
			<input class="form-control" type="text" id="entradada" value="<fmt:formatDate value="${lote.dataEntrada}" pattern="dd/MM/yyyy"/> " name="lote.dataEntrada">
		</div>
		<div class="form-group">
			<label for="fab">Data Frabricação</label>
			<input class="form-control" type="text" id="fab" value="<fmt:formatDate  value="${lote.dataFabricacao}" pattern="dd/MM/yyyy" /> "name="lote.dataFabricacao">
		</div>
		<div class="form-group">
			<label for="venc">Data Vencimento</label>
			<input class="form-control" type="text" id="venc" value="<fmt:formatDate value="${lote.dataVencimento}" pattern="dd/MM/yyyy"/>" name="lote.dataVencimento">
		</div>
	</div>
	<div style="float: left;width:320; margin: 50px">
			<legend>Cadastro Medicamento</legend>
			<div class="form-group">
				<label for="nomeMed">Nome Medicamento</label>
				<input class="form-control" type="text" id="nomeMed" value="${lote.medicamento.nomeMedicamento }" name="lote.medicamento.nomeMedicamento ">
			</div>
			<div class="form-group">
				<label for="desc">Descrição Medicamento</label>
				<input class="form-control" type="text" id="desc" value="${lote.medicamento.descricao }" name="lote.medicamento.descricao">
			</div>
	</div>
	<div style="float: left;width:320; margin: 50px">
			<legend>Cadastro de Grupo</legend>
			<div class="form-group">
				<label for="dGrup">Descrição do Grupo</label>	
				<input class="form-control" type="text" id="dGrup" value="${lote.medicamento.grupo.descricaoGrupo}" name="lote.medicamento.grupo.descricaoGrupo">
			</div>
			<div class="form-group">
				<label for="nGrup">Nome do Grupo </label>
				<input class="form-control" type="text" id="nGrup" value="${lote.medicamento.grupo.nomeGrupo}" name="lote.medicamento.grupo.nomeGrupo">
			</div>
			<div class="form-group">
				<label for="nSGrup">Nome do Sub-Grupo</label>
				<input class="form-control" type="text" id="nSGrup" value="${lote.medicamento.grupo.nomeSubGrupo}" name="lote.medicamento.grupo.nomeSubGrupo">
			</div>
			<a class="btn btn-primary" href="<c:url value="/"/>">Voltar Ao Inicio</a>
			<input class="btn btn-primary" type="submit"  value="gravar">
	</div>
	</form>
	</div>
	<c:import url="../import/right.jsp"></c:import>
	<c:import url="../import/footer.jsp"></c:import>
</body>
</html>
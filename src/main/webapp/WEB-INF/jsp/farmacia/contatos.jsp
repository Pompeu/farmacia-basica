<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:import url="../import/css.jsp"></c:import>
<c:import url="../import/javascripts.jsp"></c:import>
<title>Cadastros</title>
</head>
<body>
<c:import url="../import/header.jsp"></c:import>
<div style="margin-left: 100px; margin-top: 50px;">
	<div class="media" style="font-size: 40px">
	 	<img alt="" src='<c:url value="/assets/img/naruto.jpg" />' width="150px" height="150px" />
	 		Itacir Ferreira Pompeu
		 <a class="media-left" href="https://www.facebook.com/itacir.pompeu">Facebook </a>
		 <a class="media-left" href="https://github.com/Pompeu">Github </a>
		 
	</div>
	<div class="media" style="font-size: 40px">
	<img alt="" src='<c:url value="/assets/img/fada.jpg" />' width="150px" height="150px" />
		Asser Martins
		<a class="media-left" href="https://www.facebook.com/assermartins">Facebook</a>
		<a class="media-left" href="https://github.com/assermartins">Github </a>
	</div>
</div>
</body>
<c:import url="../import/footer.jsp"></c:import>
</html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="page-header" style="background-color: #fff; color: #000;">
	<h1 style="background-color: #fff; color: #000;">
		Farmacia Basica <small>esse e um sistema para controle de
			medicamentos</small>
		<ul class="nav pull-right top-menu">
			<li><a class="btn logout" href="<c:url value='/login/logout'/>">
					Sair </a></li>
		</ul>
	</h1>

</div>
<c:import url="../import/leftMenu.jsp"></c:import>
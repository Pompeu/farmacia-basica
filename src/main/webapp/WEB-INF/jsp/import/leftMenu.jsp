<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group">
  <button type="button" class="btn btn-primary">Cadastros</button>
  <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
    <span class="caret"></span>
    <span class="sr-only">Toggle Dropdown</span>
  </button>
<ul class="dropdown-menu" role="menu">
    <li role="presentation"><a role="menuitem" tabindex="-1" href="<c:url value='/paciente/form'/>">Paciente</a></li>
   	<li class="divider"></li>
    <li role="presentation"><a role="menuitem" tabindex="-1" href="<c:url value='/medico/form'/>">Medicos</a></li>
    </ul>
</div>
<div class="btn-group">
  <button type="button" class="btn btn-primary">Movimentação</button>
  <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
    <span class="caret"></span>
    <span class="sr-only">Toggle Dropdown</span>
  </button>
  <ul class="dropdown-menu" role="menu">
    <li role="presentation"><a role="menuitem" tabindex="-1" href="<c:url value='/lote/form'/>">Entradas Medicamentos</a>
    </li>
    <li class="divider"></li>
    <li role="presentation"><a role="menuitem" tabindex="-1" href="<c:url value='/lote/listar'/>">Consultar Entradas Medicamentos</a></li>
  	<li class="divider"></li>
    <li role="presentation"><a role="menuitem" tabindex="-1"  href="<c:url value='/saidasMedicamento/form'/>">Saidas Medicamentos</a></li>
    <li class="divider"></li>
    <li role="presentation"><a role="menuitem" tabindex="-1" href="<c:url value='/saidasMedicamento/listar'/>">Consultar Saidas Medicamentos</a></li>
  	<li class="divider"></li>
  	<li role="presentation"><a role="menuitem" tabindex="-1" href="<c:url value='/medico/listar'/>">Consultar Medico</a></li>
  	<li class="divider"></li>
  	<li role="presentation"><a role="menuitem" tabindex="-1" href="<c:url value='/paciente/listar'/>">Consultar Paciente</a></li>
  	<li class="divider"></li>
  	<li role="presentation"><a role="menuitem" tabindex="-1" onclick='alert("Não implentado");' href="#">Relatorios</a></li>
  </ul>
</div>
<div class="btn-group">
  <button type="button" class="btn btn-primary">Ajuda</button>
  <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
    <span class="caret"></span>
    <span class="sr-only">Toggle Dropdown</span>
  </button>
  <ul class="dropdown-menu" role="menu">
    <li role="presentation"><a role="menuitem" tabindex="-1"  href="#">Ajuda</a></li>
    <li class="divider divider-background"></li>
    <li role="presentation"><a role="menuitem" tabindex="-1" href="<c:url value='/contatos'/>">Contato</a></li>
    <li class="divider"></li>
    <li role="presentation"><a role="menuitem" tabindex="-1" href="<c:url value='/login/logout'/>">sair</a></li>
  </ul>
</div>
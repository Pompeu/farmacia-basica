<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="btn-group">
  <button type="button" class="btn btn-primary">Principal</button>
  <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
    <span class="caret"></span>
    <span class="sr-only">Toggle Dropdown</span>
  </button>
  <ul class="dropdown-menu" role="menu">
    <li><a class="btn btn-primary" href="#">Cadastros</a></li>
    <li class="divider"></li>
    <li><a class="btn btn-primary" href="#">Relatorios</a></li>
  </ul>
</div>
<div class="btn-group">
  <button type="button" class="btn btn-primary">Mivimentação</button>
  <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
    <span class="caret"></span>
    <span class="sr-only">Toggle Dropdown</span>
  </button>
  <ul class="dropdown-menu" role="menu">
    <li><a class="btn btn-primary" href="<c:url value='/lote/form'/>">Entradas Medicamentos</a>
    </li>
    <li class="divider"></li>
    <li><a class="btn btn-primary" href="<c:url value='/saidasMedicamento/form'/>">Saidas Medicamentos</a></li>
    <li class="divider"></li>
    <li><a class="btn btn-primary" href="<c:url value='/lote/listar'/>">Consultar Lotes</a></li>
  </ul>
</div>
<div class="btn-group">
  <button type="button" class="btn btn-primary">Ajuda</button>
  <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
    <span class="caret"></span>
    <span class="sr-only">Toggle Dropdown</span>
  </button>
  <ul class="dropdown-menu" role="menu">
    <li><a class="btn btn-primary" href="#">Ajuda</a></li>
    <li class="divider divider-background"></li>
    <li><a class="btn btn-primary" href="#">Contato</a></li>
    <li class="divider"></li>
    <li><a class="btn btn-primary" href="#">sair</a></li>
  </ul>
</div>
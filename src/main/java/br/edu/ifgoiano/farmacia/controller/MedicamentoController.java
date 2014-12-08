package br.edu.ifgoiano.farmacia.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.edu.ifgoiano.farmacia.dao.DAO;
import br.edu.ifgoiano.farmacia.model.Medicamento;

@Controller
public class MedicamentoController {

	private Result result;
	private DAO<Medicamento> dao;
	private Medicamento medicamento;

	@Inject
	public MedicamentoController(Result result) {
		this.result = result;
		this.dao = new DAO<Medicamento>(Medicamento.class);
	}

	@Deprecated
	public MedicamentoController() {
		this(null);
	}

	public void form() {

	}

	public void create(Medicamento medicamento) {
		dao.create(medicamento);
		result.redirectTo(this).listar();
	}

	public void editar(Integer pkKey) {
		medicamento = dao.retrivetbyId(pkKey);
		dao.update(medicamento);
		result.include(medicamento);
		result.redirectTo(this).form();
	}

	public void deletar(Integer pkKey) {
		medicamento = dao.retrivetbyId(pkKey);
		dao.delete(medicamento);
		result.redirectTo(this).listar();

	}

	public List<Medicamento> listar() {
		result.include(medicamento);
		return dao.retrivetAll();
	}

}

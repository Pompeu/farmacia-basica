package br.edu.ifgoiano.farmacia.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.edu.ifgoiano.farmacia.dao.DAO;
import br.edu.ifgoiano.farmacia.model.SaidasMedicamento;

@Controller
public class SaidasMedicamentoController {
	private Result result;
	private DAO<SaidasMedicamento> dao;
	private SaidasMedicamento saidasMedicamento;

	@Inject
	public SaidasMedicamentoController(Result result) {
		this.result = result;
		this.dao = new DAO<SaidasMedicamento>(SaidasMedicamento.class);
	}

	@Deprecated
	public SaidasMedicamentoController() {
		this(null);
	}

	public void form() {

	}

	public void create(SaidasMedicamento saidasMedicamento) {
		dao.create(saidasMedicamento);
		result.redirectTo(this).listar();
	}

	public void editar(Integer pkKey) {
		saidasMedicamento = dao.retrivetbyId(pkKey);
		dao.update(saidasMedicamento);
		result.include(saidasMedicamento);
		result.redirectTo(this).form();
	}

	public void deletar(Integer pkKey) {
		saidasMedicamento = dao.retrivetbyId(pkKey);
		dao.delete(saidasMedicamento);
		result.redirectTo(this).listar();

	}

	public List<SaidasMedicamento> listar() {
		result.include(saidasMedicamento);
		return dao.retrivetAll();
	}
	

}

package br.edu.ifgoiano.farmacia.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.edu.ifgoiano.farmacia.dao.DAO;
import br.edu.ifgoiano.farmacia.model.Medico;

@Controller
public class MedicoController {

	private Result result;
	private DAO<Medico> dao;
	private Medico medico;

	@Inject
	public MedicoController(Result result) {
		this.result = result;
		this.dao = new DAO<Medico>(Medico.class);
	}

	@Deprecated
	public MedicoController() {
		this(null);
	}

	public void form() {

	}

	public void create(Medico medico) {
		dao.create(medico);
		result.redirectTo(this).listar();
	}

	public void editar(Integer pkKey) {
		medico = dao.retrivetbyId(pkKey);
		dao.update(medico);
		result.include(medico);
		result.redirectTo(this).form();
	}

	public void deletar(Integer pkKey) {
		medico = dao.retrivetbyId(pkKey);
		dao.delete(medico);
		result.redirectTo(this).listar();

	}

	public List<Medico> listar() {
		result.include(medico);
		return dao.retrivetAll();
	}

}

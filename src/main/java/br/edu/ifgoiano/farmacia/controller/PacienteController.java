package br.edu.ifgoiano.farmacia.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.edu.ifgoiano.farmacia.dao.DAO;
import br.edu.ifgoiano.farmacia.model.Cidade;
import br.edu.ifgoiano.farmacia.model.Estado;
import br.edu.ifgoiano.farmacia.model.Paciente;

@Controller
public class PacienteController {

	private Result result;
	private DAO<Paciente> dao;
	private Paciente paciente;

	@Inject
	public PacienteController(Result result) {
		this.result = result;
		this.dao = new DAO<Paciente>(Paciente.class);
	}

	@Deprecated
	public PacienteController() {
		this(null);
	}

	public void form() {

	}

	public void create(Paciente paciente) {
		if (paciente.getPkPaciente() == null)
			dao.create(paciente);
		else
			dao.update(paciente);
		result.redirectTo(this).listar();
	}

	public void editar(Integer pkKey) {
		paciente = dao.retrivetbyId(pkKey);
		result.include(paciente);
		result.redirectTo(this).form();
	}

	public void deletar(Integer pkKey) {
		paciente = dao.retrivetbyId(pkKey);
		dao.delete(paciente);
		result.redirectTo(this).listar();

	}

	public List<Paciente> listar() {
		result.include(paciente);
		return dao.retrivetAll();
	}

}

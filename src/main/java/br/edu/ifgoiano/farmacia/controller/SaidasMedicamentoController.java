package br.edu.ifgoiano.farmacia.controller;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.ifgoiano.farmacia.dao.DAO;
import br.edu.ifgoiano.farmacia.dao.SaidaDAO;
import br.edu.ifgoiano.farmacia.model.Lote;
import br.edu.ifgoiano.farmacia.model.Medico;
import br.edu.ifgoiano.farmacia.model.Paciente;
import br.edu.ifgoiano.farmacia.model.SaidasMedicamento;

@Controller
@SessionScoped
public class SaidasMedicamentoController implements Serializable {

	private static final long serialVersionUID = 1L;
	private Result result;
	private DAO<SaidasMedicamento> dao;
	private DAO<Lote> daoLote;
	private SaidasMedicamento saidasMedicamento;
	private SaidaDAO finder;
	private Paciente paciente;
	private Medico medico;
	private Lote lote;

	@Inject
	public SaidasMedicamentoController(Result result, SaidaDAO finder,
			SaidasMedicamento saidasMedicamento) {
		this.result = result;
		this.finder = finder;
		this.saidasMedicamento = saidasMedicamento;
		this.dao = new DAO<SaidasMedicamento>(SaidasMedicamento.class);
	}

	@Deprecated
	public SaidasMedicamentoController() {
		this(null, null, null);
	}

	public void form() {

	}

	public void create(Integer quantidade) {
		saidasMedicamento.setQuantidade(quantidade);
		Calendar dataSaida = Calendar.getInstance();
		saidasMedicamento.setDataSaida(dataSaida);
		saidasMedicamento.setLote(lote);
		saidasMedicamento.setPaciente(paciente);
		saidasMedicamento.setMedico(medico);
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
		dao = new DAO<SaidasMedicamento>(SaidasMedicamento.class);
		return dao.retrivetAll();
	}

	@Post("/findlote")
	public void findLote(String lotevalue) {
		lote = finder.retriveLoteValue(lotevalue);
		result.include(lote);
		result.redirectTo(this).resultLote();
	}

	public void resultLote() {
		result.include(lote);
	}

	@Post("/findmedico")
	public void findMedico(String crm) {
		medico = finder.retriveByMedicoByCRM(crm);
		result.include(lote);
		result.include(medico);
		result.redirectTo(this).resultMedico();
	}

	public void resultMedico() {
		result.include(lote);
		result.include(medico);
	}

	@Post("/findpaciente")
	public void findPaciente(String cpf) {
		paciente = finder.retriveByCPF(cpf);
		result.include(lote);
		result.include(medico);
		result.include(paciente);
		result.redirectTo(this).resultPaciente();
	}

	public void resultPaciente() {
		result.include(lote);
		result.include(medico);
		result.include(paciente);
	}
}

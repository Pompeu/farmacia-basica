package br.edu.ifgoiano.farmacia.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.edu.ifgoiano.farmacia.dao.DAO;
import br.edu.ifgoiano.farmacia.model.EntradasMedicamento;
import br.edu.ifgoiano.farmacia.model.Lote;

@Controller
public class LoteController {

	private Result result;
	private DAO<Lote> dao;
	private Lote lote;

	public Lote getLote() {
		return lote;
	}

	public void setLote(Lote lote) {
		this.lote = lote;
	}

	@Inject
	public LoteController(Result result) {
		this.result = result;
		this.dao = new DAO<Lote>(Lote.class);
	}

	@Deprecated
	public LoteController() {
		this(null);
	}

	public void form() {

	}

	public void create(Lote lote) {
		lote.setEntradasMedicamento(new EntradasMedicamento(lote.getNumeroNf()));
		System.out.println(lote.toString());
		System.out.println(lote.getMedicamento().toString());
		System.out.println(lote.getMedicamento().getGrupo().toString());
		System.out.println(lote.getEntradasMedicamento().toString());
		if (lote.getPkLote() == null)
			dao.create(lote);
		else
			dao.update(lote);
		result.redirectTo(this).listar();
	}

	public void editar(Integer pkKey) {
		lote = dao.retrivetbyId(pkKey);
		result.include(lote);
		result.redirectTo(this).form();
	}

	public void deletar(Integer pkKey) {
		lote = dao.retrivetbyId(pkKey);
		dao.delete(lote);
		result.redirectTo(this).listar();

	}

	public List<Lote> listar() {
		result.include(lote);
		return dao.retrivetAll();
	}
}

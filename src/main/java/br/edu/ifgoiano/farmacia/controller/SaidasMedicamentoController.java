package br.edu.ifgoiano.farmacia.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.ifgoiano.farmacia.controller.logic.MedicamentosLogic;
import br.edu.ifgoiano.farmacia.dao.DAO;
import br.edu.ifgoiano.farmacia.dao.SaidaDAO;
import br.edu.ifgoiano.farmacia.model.Lote;
import br.edu.ifgoiano.farmacia.model.Medico;
import br.edu.ifgoiano.farmacia.model.Paciente;
import br.edu.ifgoiano.farmacia.model.SaidasMedicamento;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Controller
@SessionScoped
public class SaidasMedicamentoController implements Serializable {

	private static final long serialVersionUID = 1L;
	private Result result;
	private DAO<SaidasMedicamento> dao;
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
		MedicamentosLogic.atulizarEstoqueMedicamentos(lote.getPkLote(),
				Math.abs(quantidade));
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

	@Get
	@Path("/controller/relatorios")
	public File relatorioSaidas() {

		Document document = new Document();

		try {
			PdfWriter.getInstance(document, new FileOutputStream("teste.pdf"));
			document.open();
			document.setPageSize(PageSize.A4);

			PdfPTable table = new PdfPTable(5);
			PdfPCell data = new PdfPCell(new Paragraph("Data"));
			table.addCell(data);

			PdfPCell quantidade = new PdfPCell(new Paragraph("Quantidade"));
			table.addCell(quantidade);

			PdfPCell codigoLote = new PdfPCell(new Paragraph("Código Lote"));
			table.addCell(codigoLote);

			PdfPCell nomeMedico = new PdfPCell(new Paragraph("Medico"));
			table.addCell(nomeMedico);

			PdfPCell nomePacinte = new PdfPCell(new Paragraph("Paciente"));
			table.addCell(nomePacinte);

			dao = new DAO<SaidasMedicamento>(
					SaidasMedicamento.class);
			List<SaidasMedicamento> saidas = dao.retrivetAll();
			for (SaidasMedicamento s : saidas) {
				table.addCell(s.getDataSaida().getTime().toString().substring(0, 10));
				table.addCell(s.getQuantidade().toString());
				table.addCell(s.getLote().getNomeLote().toString());
				table.addCell(s.getMedico().getNome().toString());
				table.addCell(s.getPaciente().getNome().toString());
			}
			document.add(table);

		} catch (DocumentException | IOException e) {

			e.printStackTrace();
		}

		document.close();

		return new File("teste.pdf");

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

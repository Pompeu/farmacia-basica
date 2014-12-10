package br.edu.ifgoiano.farmacia.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.edu.ifgoiano.farmacia.dao.DAO;
import br.edu.ifgoiano.farmacia.dao.SaidaDAO;
import br.edu.ifgoiano.farmacia.dao.SaidaImpl;
import br.edu.ifgoiano.farmacia.model.Lote;
import br.edu.ifgoiano.farmacia.model.Medico;
import br.edu.ifgoiano.farmacia.model.Paciente;
import br.edu.ifgoiano.farmacia.model.SaidasMedicamento;

public class TestarSaidaMedicamentos {

	@Before
	public void init() {

	}

	@Test
	public void deveRegistrarAsaidadeMedicamentos() {
		DAO<SaidasMedicamento> daoSaida = new DAO<>(SaidasMedicamento.class);

		SaidaDAO daoLote = new SaidaImpl();

		String value = "123545";
		Lote lote = daoLote.retriveLoteValue(value);
		lote.setQtdMedicamento(lote.getQtdMedicamento() - Math.abs(5));
		assertEquals(lote.getNomeLote(), value);

		String crm = "132135";
		Medico medico = daoLote.retriveByMedicoByCRM(crm);
		assertEquals(medico.getCrm(), crm);

		String cpf = "12345678999";
		Paciente paciente = daoLote.retriveByCPF(cpf);
		assertEquals(paciente.getCpf(), cpf);

		SaidasMedicamento obj = new SaidasMedicamento(5, lote, medico, paciente);
		assertEquals(obj.getLote(), lote);
		assertEquals(obj.getMedico(), medico);
		assertEquals(obj.getPaciente(), paciente);

		daoSaida.create(obj);

	}

}

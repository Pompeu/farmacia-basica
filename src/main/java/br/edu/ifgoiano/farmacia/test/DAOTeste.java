package br.edu.ifgoiano.farmacia.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.edu.ifgoiano.farmacia.dao.DAO;
import br.edu.ifgoiano.farmacia.model.Medicamento;
import br.edu.ifgoiano.farmacia.model.Medico;
import br.edu.ifgoiano.farmacia.model.Paciente;

public class DAOTeste {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void deveRecuperaTodosPacientes() {
		DAO<Paciente> dao = new DAO<>(Paciente.class);
		// dao.create(new Paciente("12345678988", new Date(),
		// "Jose Maria","Maria Jose", new Cidade("Buriti Alegre", new
		// Estado("GO"))));
		List<Paciente> retrivetAll = dao.retrivetAll();
		assertTrue(retrivetAll.size() > 0);
	}

	@Test
	public void deveRecuperaTodosMedicos() {
		DAO<Medico> dao = new DAO<>(Medico.class);
		List<Medico> retrivetAll = dao.retrivetAll();
		assertTrue(retrivetAll.size() > 0);
	}

	@Test
	public void deveRecuperarTodoMedicamentos() {
		DAO<Medicamento> dao = new DAO<>(Medicamento.class	);
		List<Medicamento> retrivetAll = dao.retrivetAll();
		assertTrue(retrivetAll.size() > 0);
	}

}

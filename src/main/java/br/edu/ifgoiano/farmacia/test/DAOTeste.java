package br.edu.ifgoiano.farmacia.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.edu.ifgoiano.farmacia.dao.DAO;
import br.edu.ifgoiano.farmacia.model.Cidade;
import br.edu.ifgoiano.farmacia.model.Estado;
import br.edu.ifgoiano.farmacia.model.Medico;
import br.edu.ifgoiano.farmacia.model.Paciente;
import br.edu.ifgoiano.farmacia.util.JPAUtil;

public class DAOTeste {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void deveRecuperaTodosPacientes() {
		DAO<Paciente> dao = new DAO<>(Paciente.class,
				JPAUtil.criaEntityManager());
		// dao.create(new Paciente("12345678988", new Date(),
		// "Jose Maria","Maria Jose", new Cidade("Buriti Alegre", new
		// Estado("GO"))));
		List<Paciente> retrivetAll = dao.retrivetAll();
		assertTrue(retrivetAll.size() > 0);
	}

	@Test
	public void deveRecuperaTodosMedicos() {
		DAO<Medico> dao = new DAO<>(Medico.class, JPAUtil.criaEntityManager());
//		 dao.create(new Medico("1234", "Maricotinho", "34441827"));
		List<Medico> retrivetAll = dao.retrivetAll();
		assertTrue(retrivetAll.size() > 0);
	}

}

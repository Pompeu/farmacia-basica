package br.edu.ifgoiano.farmacia.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.edu.ifgoiano.farmacia.dao.LoteDAO;
import br.edu.ifgoiano.farmacia.dao.LoteImpl;
import br.edu.ifgoiano.farmacia.model.Lote;
import br.edu.ifgoiano.farmacia.util.JPAUtil;

public class TesteLoteDAO {
	private Lote lote;
	private LoteDAO loteDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		this.loteDAO = new LoteImpl(JPAUtil.criaEntityManager());
	}

	@After
	public void tearDown() throws Exception {
	}

//	public void deveGravarUmLoteDeMedicamentos() {
//
//		Medicamento recuperarMedicamentoById = loteDAO
//				.recuperarMedicamentoById(8);
//		Grupo recuperarGrupoById = loteDAO.recuperarGrupoById(7);
//		recuperarMedicamentoById.setGrupo(recuperarGrupoById);
//		String numeroNf = "112233";
//		EntradasMedicamento entradasMedicamento = new EntradasMedicamento(
//				numeroNf);
//
//		lote = new Lote(Calendar.getInstance(), Calendar.getInstance(),
//				Calendar.getInstance(), "0213516519949", "AZLV25XKL", numeroNf,
//				400, Unidade.UN, recuperarMedicamentoById, entradasMedicamento);
//		/*
//		 * lote = new Lote(Date.from(Instant.now()), new
//		 * Date(Calendar.getInstance().getTimeInMillis() - (120*24*60*60*1000)),
//		 * new Date(Calendar.getInstance().getTimeInMillis() +
//		 * (120*24*60*60*1000)), "0213516519949", "AZLV25XKL", "112233", 400,
//		 * Unidade.UN, new Medicamento("Remedio Contra Alergia", "Argenlix", new
//		 * Grupo( "Medicamentos anti-Zueira", "NeverEnds", "Creatianicos")),
//		 * EntradasMedicamento.newEntradasMedicamentos());
//		 */
//		loteDAO.salvar(lote);
//
//	}
//
//	@Test
//	public void deveRecuperarUmLoteDeMedicamentos() {
//
//		Lote recuperarById = loteDAO.recuperarById(7);
//		EntradasMedicamento entradasMedicamento = loteDAO.entradaById(1);
//
//		Medicamento recuperarMedicamentoById = loteDAO
//				.recuperarMedicamentoById(7);
//		Grupo recuperarGrupoById = loteDAO.recuperarGrupoById(6);
//
//		assertEquals(recuperarById.getMedicamento(), recuperarMedicamentoById);
//		assertEquals(recuperarMedicamentoById.getGrupo(), recuperarGrupoById);
//		assertEquals(recuperarById.getEntradasMedicamento().getPkEntrada(),
//				entradasMedicamento.getPkEntrada());
//	}
//
	@Test
	public void deveDiminuirQuantidadeUmLote() {
		Lote recuperarById = loteDAO.recuperarById(10);

		Integer qtdMedicamento = recuperarById.getQtdMedicamento();
		int medicamentosEntregues = 5;

		recuperarById.setQtdMedicamento(qtdMedicamento
				- Math.abs(medicamentosEntregues));
		loteDAO.salvar(recuperarById);

		assertTrue(qtdMedicamento == recuperarById.getQtdMedicamento()
				+ Math.abs(medicamentosEntregues));

	}

	@Test
	public void deveMostrarNomeDomedicamento() {
		List<Lote> recupearTodos = loteDAO.recupearTodos();
		for (Lote lote : recupearTodos) {
			System.out.println(lote.getMedicamento().getNomeMedicamento());
		}
	}

}

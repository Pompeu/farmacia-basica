package br.edu.ifgoiano.farmacia.controller.logic;

import br.edu.ifgoiano.farmacia.dao.DAO;
import br.edu.ifgoiano.farmacia.model.Lote;

public class MedicamentosLogic {

	private static DAO<Lote> dao;

	private MedicamentosLogic() {

	}

	public static void atulizarEstoqueMedicamentos(Integer pkLote,
			Integer qtdMedicamentoEntregue) {
		dao = new DAO<>(Lote.class);
		Lote lote = dao.retrivetbyId(pkLote);
		if (lote.getQtdMedicamento() > 0) {
			lote.setQtdMedicamento(lote.getQtdMedicamento()
					- Math.abs(qtdMedicamentoEntregue));
			dao.update(dao.retrivetbyId(pkLote));
		} else
			throw new RuntimeException(
					"Não pode entragar medicamento sem estoque");

	}
}

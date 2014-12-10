package br.edu.ifgoiano.farmacia.dao;

import br.edu.ifgoiano.farmacia.model.Lote;
import br.edu.ifgoiano.farmacia.model.Medico;
import br.edu.ifgoiano.farmacia.model.Paciente;

public interface SaidaDAO {
	Lote retriveLoteValue(String lotevalue);
	Medico retriveByMedicoByCRM(String cmr);
	Paciente retriveByCPF(String cpf);
}

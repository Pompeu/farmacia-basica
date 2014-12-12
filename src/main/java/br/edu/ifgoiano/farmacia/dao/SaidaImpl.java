package br.edu.ifgoiano.farmacia.dao;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.persistence.TypedQuery;

import br.edu.ifgoiano.farmacia.model.Lote;
import br.edu.ifgoiano.farmacia.model.Medico;
import br.edu.ifgoiano.farmacia.model.Paciente;
import br.edu.ifgoiano.farmacia.model.SaidasMedicamento;


@RequestScoped
public class SaidaImpl extends DAO<SaidasMedicamento> implements SaidaDAO,Serializable {

	private static final long serialVersionUID = 1L;

	public SaidaImpl() {
		super(SaidasMedicamento.class);
	}

	@Override
	public Lote retriveLoteValue(String loteValue) {
		String consulta = "select l from Lote l where l.nomeLote = :pLoteValue";

		TypedQuery<Lote> query = em.createQuery(consulta, Lote.class);

		query.setParameter("pLoteValue", loteValue);

		return query.getSingleResult();
	}

	@Override
	public Medico retriveByMedicoByCRM(String cmr) {
		String consulta = "select m from Medico m where m.crm = :pCrm";

		TypedQuery<Medico> query = em.createQuery(consulta, Medico.class);

		query.setParameter("pCrm", cmr);

		return query.getSingleResult();
	}

	@Override
	public Paciente retriveByCPF(String cpf) {
		String consulta = "select p from Paciente p where p.cpf = :pCpf";

		TypedQuery<Paciente> query = em.createQuery(consulta, Paciente.class);

		query.setParameter("pCpf", cpf);

		return query.getSingleResult();
	}

}

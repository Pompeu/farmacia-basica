package br.edu.ifgoiano.farmacia.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the medicamentos database table.
 * 
 */
@Entity
@Table(name = "medicamentos")
@NamedQuery(name = "Medicamento.findAll", query = "SELECT m FROM Medicamento m")
public class Medicamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_medicamento")
	@SequenceGenerator(allocationSize = 1, sequenceName = "seq_pk_medicamento", name = "pk_medicamento")
	@Column(name = "pk_medicamento")
	private Integer pkMedicamento;

	private String descricao;

	private String nomeMedicamento;

	@OneToMany(mappedBy = "medicamento", cascade = CascadeType.ALL)
	private List<Lote> lotes;

	Medicamento() {
	}

	public Medicamento(String descricao, String nomeMedicamento) {
		this.descricao = descricao;
		this.nomeMedicamento = nomeMedicamento;

	}

	public Integer getPkMedicamento() {
		return pkMedicamento;
	}

	public void setPkMedicamento(Integer pkMedicamento) {
		this.pkMedicamento = pkMedicamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNomeMedicamento() {
		return nomeMedicamento;
	}

	public void setNomeMedicamento(String nomeMedicamento) {
		this.nomeMedicamento = nomeMedicamento;
	}

	public List<Lote> getLotes() {
		return lotes;
	}

	public void setLotes(List<Lote> lotes) {
		this.lotes = lotes;
	}

	@Override
	public String toString() {
		return "Medicamento [pkMedicamento=" + pkMedicamento + ", descricao="
				+ descricao + ", nomeMedicamento=" + nomeMedicamento + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result
				+ ((pkMedicamento == null) ? 0 : pkMedicamento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medicamento other = (Medicamento) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (pkMedicamento == null) {
			if (other.pkMedicamento != null)
				return false;
		} else if (!pkMedicamento.equals(other.pkMedicamento))
			return false;
		return true;
	}

}
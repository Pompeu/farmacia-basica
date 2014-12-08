package br.edu.ifgoiano.farmacia.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the medicos database table.
 * 
 */
@Entity
@Table(name = "medicos")
@NamedQuery(name = "Medico.findAll", query = "SELECT m FROM Medico m")
public class Medico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_medicos")
	@SequenceGenerator(name = "pk_medicos", sequenceName = "sq_pk_medicos", allocationSize = 1)
	@Column(name = "pk_medicos")
	private Integer pkMedicos;

	private String crm;

	private String nome;

	private String telefone;

	// bi-directional many-to-one association to SaidasMedicamento
	@OneToMany(mappedBy = "medico")
	private List<SaidasMedicamento> saidasMedicamentos;

	Medico() {
	}

	public Medico(String crm, String nome, String telefone) {
		this.crm = crm;
		this.nome = nome;
		this.telefone = telefone;
	}

	public Integer getPkMedicos() {
		return pkMedicos;
	}

	public void setPkMedicos(Integer pkMedicos) {
		this.pkMedicos = pkMedicos;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<SaidasMedicamento> getSaidasMedicamentos() {
		return saidasMedicamentos;
	}

	public void setSaidasMedicamentos(List<SaidasMedicamento> saidasMedicamentos) {
		this.saidasMedicamentos = saidasMedicamentos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((pkMedicos == null) ? 0 : pkMedicos.hashCode());
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
		Medico other = (Medico) obj;
		if (pkMedicos == null) {
			if (other.pkMedicos != null)
				return false;
		} else if (!pkMedicos.equals(other.pkMedicos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Medico [pkMedicos=" + pkMedicos + ", crm=" + crm + ", nome="
				+ nome + ", telefone=" + telefone;
	}

}
package br.edu.ifgoiano.farmacia.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the pacientes database table.
 * 
 */
@Entity
@Table(name = "pacientes")
@NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p")
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_paciente")
	@SequenceGenerator(name = "pk_paciente", allocationSize = 1, sequenceName = "sq_pk_paciente")
	@Column(name = "pk_paciente")
	private Integer pkPaciente;

	private String cpf;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento",nullable=false)
	private Date dataNascimento;

	private String nome;

	@Column(name = "nome_mae")
	private String nomeMae;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pk_cidade")
	private Cidade cidade;

	Paciente() {

	}

	public Paciente(String cpf, Date dataNascimento, String nome,
			String nomeMae, Cidade cidade) {
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.nome = nome;
		this.nomeMae = nomeMae;
		this.cidade = cidade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getPkPaciente() {
		return pkPaciente;
	}

	public String getCpf() {
		return cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return "Paciente [pkPaciente=" + pkPaciente + ", cpf=" + cpf
				+ ", dataNascimento=" + dataNascimento + ", nome=" + nome
				+ ", nomeMae=" + nomeMae + ", cidade=" + cidade + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((pkPaciente == null) ? 0 : pkPaciente.hashCode());
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
		Paciente other = (Paciente) obj;
		if (pkPaciente == null) {
			if (other.pkPaciente != null)
				return false;
		} else if (!pkPaciente.equals(other.pkPaciente))
			return false;
		return true;
	}
}
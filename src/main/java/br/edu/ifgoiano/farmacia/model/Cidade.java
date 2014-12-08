package br.edu.ifgoiano.farmacia.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the cidades database table.
 * 
 */
@Entity
@Table(name = "cidades")
@NamedQuery(name = "Cidade.findAll", query = "SELECT c FROM Cidade c")
public class Cidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_cidade")
	@SequenceGenerator(name = "pk_cidade", allocationSize = 1, sequenceName = "sq_pk_cidade")
	@Column(name = "pk_cidade")
	private Integer pkCidade;

	private String nome;

	// bi-directional many-to-one association to Estado
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pk_estado")
	private Estado estado;

	@OneToMany(mappedBy = "cidade")
	private List<Paciente> pacientes;

	Cidade() {

	}

	public Cidade(String nome, Estado estado) {
		this.nome = nome;
		this.estado = estado;

	}

	public Integer getPkCidade() {
		return pkCidade;
	}

	public void setPkCidade(Integer pkCidade) {
		this.pkCidade = pkCidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((pkCidade == null) ? 0 : pkCidade.hashCode());
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
		Cidade other = (Cidade) obj;
		if (pkCidade == null) {
			if (other.pkCidade != null)
				return false;
		} else if (!pkCidade.equals(other.pkCidade))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cidade [pkCidade=" + pkCidade + ", nome=" + nome + ", estado="
				+ estado;
	}

}
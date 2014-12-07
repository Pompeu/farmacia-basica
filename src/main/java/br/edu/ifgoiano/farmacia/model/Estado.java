package br.edu.ifgoiano.farmacia.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the estados database table.
 * 
 */
@Entity
@Table(name = "estados")
@NamedQuery(name = "Estado.findAll", query = "SELECT e FROM Estado e")
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_estado")
	@SequenceGenerator(name = "pk_estado", allocationSize = 1, sequenceName = "sq_pk_estado")
	@Column(name = "pk_estado")
	private Integer pkEstado;

	private String uf;

	@OneToMany(mappedBy = "estado")
	private List<Cidade> cidades;

	 Estado() {
	}

	public Estado(String uf) {
		this.uf = uf;
		
	}

	public Integer getPkEstado() {
		return pkEstado;
	}

	public void setPkEstado(Integer pkEstado) {
		this.pkEstado = pkEstado;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((pkEstado == null) ? 0 : pkEstado.hashCode());
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
		Estado other = (Estado) obj;
		if (pkEstado == null) {
			if (other.pkEstado != null)
				return false;
		} else if (!pkEstado.equals(other.pkEstado))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Estado [pkEstado=" + pkEstado + ", uf=" + uf;
	}

	

}
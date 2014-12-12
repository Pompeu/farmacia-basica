package br.edu.ifgoiano.farmacia.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "saidas_lotes")
public class SaidasMedicamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_saida")
	@SequenceGenerator(sequenceName = "seq_pk_saida", name = "pk_saida", allocationSize = 1)
	@Column(name = "pk_saida")
	private Integer pkSaida;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_saida")
	private Calendar dataSaida;

	private Integer quantidade;

	@ManyToOne
	@JoinColumn(name = "pk_lote")
	private Lote lote;

	@ManyToOne
	@JoinColumn(name = "pk_medicos")
	private Medico medico;

	@ManyToOne
	@JoinColumn(name = "pk_paciente")
	private Paciente paciente;

	SaidasMedicamento() {
	}

	public SaidasMedicamento(Integer quantidade, Lote lote, Medico medico,
			Paciente paciente) {
		this.dataSaida = Calendar.getInstance();
		this.quantidade = quantidade;
		this.lote = lote;
		this.medico = medico;
		this.paciente = paciente;
	}

	public Integer getPkSaida() {
		return pkSaida;
	}

	public void setPkSaida(Integer pkSaida) {
		this.pkSaida = pkSaida;
	}

	public Calendar getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Calendar dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Lote getLote() {
		return lote;
	}

	public void setLote(Lote lote) {
		this.lote = lote;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	@Override
	public String toString() {
		return "SaidasLote [pkSaida=" + pkSaida + ", dataSaida=" + dataSaida
				+ ", quantidade=" + quantidade + ", lote=" + lote + ", medico="
				+ medico + ", paciente=" + paciente + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pkSaida == null) ? 0 : pkSaida.hashCode());
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
		SaidasMedicamento other = (SaidasMedicamento) obj;
		if (pkSaida == null) {
			if (other.pkSaida != null)
				return false;
		} else if (!pkSaida.equals(other.pkSaida))
			return false;
		return true;
	}

}
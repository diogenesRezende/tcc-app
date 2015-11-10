package br.edu.univas.restapiapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "atualizacoes")
public class Atualizacao {

	@Id
	@SequenceGenerator(name = "id_atualizacao", sequenceName = "seq_id_atualizacao", allocationSize = 1)
	@GeneratedValue(generator = "id_atualizacao", strategy = GenerationType.IDENTITY)
	@Column(name = "id_atualizacao", nullable = false)
	private Long idAtualizacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date data;

	public Long getIdAtualizacao() {
		return idAtualizacao;
	}

	public void setIdAtualizacao(Long idAtualizacao) {
		this.idAtualizacao = idAtualizacao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}

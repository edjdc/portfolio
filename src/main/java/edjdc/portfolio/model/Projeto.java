package edjdc.portfolio.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "PROJETO")
public class Projeto implements Serializable {

	private static final long serialVersionUID = 392519580099531893L;

	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "projeto_seq", sequenceName = "projeto_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projeto_seq")
	private Long id;

	@Column(name = "NOME", nullable = false, length = 100)
	@NotBlank(message = "Nome é uma informação obrigatória.")
	private String nome;

	@Column(name = "DESCRICAO", nullable = false, length = 2000)
	@NotBlank(message = "Descrição é uma informação obrigatória.")
	private String descricao;

	@Column(name = "GERENTE_RESPONSAVEL")
	private String gerenteResponsavel;

	@Column(name = "DATA_INICIO", nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Data de início é uma informação obrigatória.")
	private Date dataInicio;

	@Column(name = "PREVISAO_TERMINO")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date previsaoTermino;

	@Column(name = "DATA_REAL_TERMINO")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataRealTermino;

	@Column(name = "ORCAMENTO_TOTAL")
	private BigDecimal orcamentoTotal;

	@Column(name = "STATUS")
	@Enumerated(EnumType.STRING)
	private Status status;

	@Column(name = "CLASSIFICACAO")
	@Enumerated(EnumType.STRING)
	private Classificacao classificacao;

	public Projeto() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getGerenteResponsavel() {
		return gerenteResponsavel;
	}

	public void setGerenteResponsavel(String gerenteResponsavel) {
		this.gerenteResponsavel = gerenteResponsavel;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getPrevisaoTermino() {
		return previsaoTermino;
	}

	public void setPrevisaoTermino(Date previsaoTermino) {
		this.previsaoTermino = previsaoTermino;
	}

	public Date getDataRealTermino() {
		return dataRealTermino;
	}

	public void setDataRealTermino(Date dataRealTermino) {
		this.dataRealTermino = dataRealTermino;
	}

	public BigDecimal getOrcamentoTotal() {
		return orcamentoTotal;
	}

	public void setOrcamentoTotal(BigDecimal orcamentoTotal) {
		this.orcamentoTotal = orcamentoTotal;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Classificacao getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(Classificacao classificacao) {
		this.classificacao = classificacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Projeto other = (Projeto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

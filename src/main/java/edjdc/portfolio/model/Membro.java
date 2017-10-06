package edjdc.portfolio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "MEMBRO")
public class Membro implements Serializable {

	private static final long serialVersionUID = 7735777712280076702L;

	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "membro_seq", sequenceName = "membro_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "membro_seq")
	private Long id;

	@Column(name = "NOME", nullable = false, length = 100)
	@NotBlank(message = "Nome é uma informação obrigatória.")
	private String nome;

	@Column(name = "CARGO", nullable = false, length = 100)
	@NotBlank(message = "Cargo é uma informação obrigatória.")
	private String cargo;

	public Membro() {

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

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
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
		Membro other = (Membro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

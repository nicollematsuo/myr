package com.algaworks.contatos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Regras {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@NotNull
	private String nomeRegras;
	private String descricaoRegras;
	private String nomeParEntrada;
	private String tipoParEntrada;
	private Boolean mandatorio;
	private String nomeParSaida;
	private String tipoParSaida;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getnomeRegras() {
		return nomeRegras;
	}

	public void setnomeRegras(String nomeRegras) {
		this.nomeRegras = nomeRegras;
	}
	
	public String getdescricaoRegras() {
		return descricaoRegras;
	}

	public void setdescricaoRegras(String descricaoRegras) {
		this.descricaoRegras = descricaoRegras;
	}
	
	public String getnomeParEntrada() {
		return nomeParEntrada;
	}

	public void setnomeParEntrada(String nomeParEntrada) {
		this.nomeParEntrada = nomeParEntrada;
	}

	public String gettipoParEntrada() {
		return tipoParEntrada;
	}

	public void settipoParEntrada(String tipoParEntrada) {
		this.tipoParEntrada = tipoParEntrada;
	}

	public Boolean getmandatorio() {
		return mandatorio;
	}

	public void setmandatorio(String mandatorio) {
		this.mandatorio = mandatorio;
	}

	public String getnomeParSaida() {
		return tipoParEntrada;
	}

	public void setnomeParSaida(String nomeParSaida) {
		this.nomeParSaida = nomeParSaida;
	}

	public String gettipoParSaida() {
		return tipoParSaida;
	}

	public void settipoParSaida(String tipoParSaida) {
		this.tipoParSaida = tipoParSaida;
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
		Regras other = (Regras) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}

package com.onetwork.apps.admin.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.onetwork.domain.Domain;

@Entity
@Table(name="PAIS")
@Inheritance(strategy=InheritanceType.JOINED)
public class Pais extends Domain {

	private static final long serialVersionUID = 1L;
	private String nome;
	private String sigla;
	
	public Pais() {}

	@Column(name="NOME")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name="SIGLA")
	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
}

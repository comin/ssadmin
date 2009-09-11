package com.softsimples.apps.admin.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.softsimples.domain.Domain;

@Entity
@Table(name = "BAIRRO")
@Inheritance(strategy = InheritanceType.JOINED)
public class Bairro extends Domain {


	private static final long serialVersionUID = 1L;
	private String nome;
	private String sigla;
	
	public Bairro() {}

	@Column(name = "NOME")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "SIGLA")
	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
}
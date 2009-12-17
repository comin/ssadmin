package com.softsimples.apps.admin.domain;

import com.softsimples.domain.Domain;

public class Bairro extends Domain {
	
	private String nome;
	private String sigla;
	
	public Bairro() {}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
}
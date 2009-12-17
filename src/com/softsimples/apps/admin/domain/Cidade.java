package com.softsimples.apps.admin.domain;

import java.util.List;

import com.softsimples.domain.Domain;

public class Cidade extends Domain {

	private String nome;
	private List<Bairro> bairros; 
	
	public Cidade() {}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Bairro> getBairros() {
		return bairros;
	}

	public void setBairros(List<Bairro> bairros) {
		this.bairros = bairros;
	}
}

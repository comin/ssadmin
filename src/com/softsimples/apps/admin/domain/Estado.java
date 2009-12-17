package com.softsimples.apps.admin.domain;

import java.util.List;

import com.softsimples.domain.Domain;

public class Estado extends Domain {

	private String nome;
	private String uf;
	private List<Cidade> cidades;
	
	public Estado() {}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
}

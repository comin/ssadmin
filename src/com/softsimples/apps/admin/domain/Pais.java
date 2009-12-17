package com.softsimples.apps.admin.domain;

import java.util.List;

import com.softsimples.domain.Domain;

public class Pais extends Domain {

	private String nome;
	private String sigla;
	private List<Estado> estados;
	
	public Pais() {}

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

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
}

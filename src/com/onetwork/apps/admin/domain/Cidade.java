package com.onetwork.apps.admin.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.onetwork.domain.Domain;

@Entity
@Table(name="CIDADE")
@Inheritance(strategy=InheritanceType.JOINED)
public class Cidade extends Domain {

	private static final long serialVersionUID = 1L;
	private String nome;
	private List<Bairro> bairros; 
	
	public Cidade() {}

	@Column(name="NOME")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="CIDADE")
	public List<Bairro> getBairros() {
		return bairros;
	}

	public void setBairros(List<Bairro> bairros) {
		this.bairros = bairros;
	}
}

package com.onetwork.apps.admin.domain;

import com.onetwork.domain.Domain;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "BAIRRO")
@Inheritance(strategy = InheritanceType.JOINED)
public class Bairro extends Domain {


	private static final long serialVersionUID = 1L;
	private String nome;
	private Cidade cidade;
	
	public Bairro() {}

	@Column(name = "NOME")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "CIDADE")
	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
}
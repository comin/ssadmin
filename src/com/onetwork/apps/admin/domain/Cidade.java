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
@Table(name="CIDADE")
@Inheritance(strategy=InheritanceType.JOINED)
public class Cidade extends Domain {

	private static final long serialVersionUID = 1L;
	private String nome;
	private Estado estado;
	
	public Cidade() {}

	@Column(name="NOME")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="ESTADO")
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}

package com.softsimples.apps.admin.domain;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import com.softsimples.domain.Domain;

@MappedSuperclass
public abstract class Conta extends Domain {

	private static final long serialVersionUID = 1L;

	private int acessos;
	private boolean ativa;
	private TipoConta tipoConta;

	public Conta() {}

	@Column(name="ACESSOS")
	public int getAcessos() {
		return acessos;
	}

	public void setAcessos(int acessos) {
		this.acessos = acessos;
	}

	@Column(name="ATIVA")
	public boolean isAtiva() {
		return ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}

	@Transient
	public abstract String getApplication();

	@Column(name="TIPOCONTA")
	@Enumerated(EnumType.ORDINAL)
	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}
}

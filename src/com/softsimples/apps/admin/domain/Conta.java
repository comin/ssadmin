package com.softsimples.apps.admin.domain;

import com.softsimples.domain.Domain;

public abstract class Conta extends Domain {

	private static final long serialVersionUID = 1L;

	private int acessos;
	private boolean ativa;
	private TipoConta tipoConta;

	public Conta() {}

	public int getAcessos() {
		return acessos;
	}

	public void setAcessos(int acessos) {
		this.acessos = acessos;
	}

	public boolean isAtiva() {
		return ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}

	public abstract String getApplication();

	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}
}

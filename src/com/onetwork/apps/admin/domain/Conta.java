package com.onetwork.apps.admin.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.onetwork.domain.Domain;
import com.onetwork.servlet.Application;


@Entity
@Table(name="CONTA")
@Inheritance(strategy=InheritanceType.JOINED)
public class Conta extends Domain {

	private static final long serialVersionUID = 1L;

	private int acessos;
	private boolean ativa;
	private Application application;
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

	@Column(name="APPLICATION")
	@Enumerated(EnumType.STRING)
	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	@Column(name="TIPOCONTA")
	@Enumerated(EnumType.STRING)
	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}
}

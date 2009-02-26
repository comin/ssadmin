package com.onetwork.apps.admin.domain;

import com.onetwork.domain.Domain;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name="PREFERENCIASPESSOAIS")
@Inheritance(strategy=InheritanceType.JOINED)
public class PreferenciasPessoais extends Domain {

	private static final long serialVersionUID = 1L;
	private boolean esportes;
	private boolean tecnologia;
	private boolean negocios;
	private boolean relacionamentos;
	private boolean jogosEletronicos;

	public PreferenciasPessoais() {}

	@Column(name="ESPORTES")
	public boolean isEsportes() {
		return esportes;
	}

	public void setEsportes(boolean esportes) {
		this.esportes = esportes;
	}

	@Column(name="TECNOLOGIA")
	public boolean isTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(boolean tecnologia) {
		this.tecnologia = tecnologia;
	}

	@Column(name="NEGOCIOS")
	public boolean isNegocios() {
		return negocios;
	}

	public void setNegocios(boolean negocios) {
		this.negocios = negocios;
	}

	@Column(name="RELACIONAMENTOS")
	public boolean isRelacionamentos() {
		return relacionamentos;
	}

	public void setRelacionamentos(boolean relacionamentos) {
		this.relacionamentos = relacionamentos;
	}

	@Column(name="JOGOSELETRONICOS")
	public boolean isJogosEletronicos() {
		return jogosEletronicos;
	}

	public void setJogosEletronicos(boolean jogosEletronicos) {
		this.jogosEletronicos = jogosEletronicos;
	}
}

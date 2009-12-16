package com.softsimples.apps.admin.domain;

import com.softsimples.domain.Domain;

public class PreferenciasPessoais extends Domain {

	private static final long serialVersionUID = 1L;
	private boolean esportes;
	private boolean tecnologia;
	private boolean negocios;
	private boolean relacionamentos;
	private boolean jogosEletronicos;

	public PreferenciasPessoais() {}

	public boolean isEsportes() {
		return esportes;
	}

	public void setEsportes(boolean esportes) {
		this.esportes = esportes;
	}

	public boolean isTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(boolean tecnologia) {
		this.tecnologia = tecnologia;
	}

	public boolean isNegocios() {
		return negocios;
	}

	public void setNegocios(boolean negocios) {
		this.negocios = negocios;
	}

	public boolean isRelacionamentos() {
		return relacionamentos;
	}

	public void setRelacionamentos(boolean relacionamentos) {
		this.relacionamentos = relacionamentos;
	}

	public boolean isJogosEletronicos() {
		return jogosEletronicos;
	}

	public void setJogosEletronicos(boolean jogosEletronicos) {
		this.jogosEletronicos = jogosEletronicos;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getOid() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}
}

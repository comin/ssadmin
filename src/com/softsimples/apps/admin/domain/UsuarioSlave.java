package com.softsimples.apps.admin.domain;

public class UsuarioSlave extends Usuario {
	
	private static final long serialVersionUID = 1L;
	private boolean temPermissoesDeMaster;

	public UsuarioSlave() {}

	public boolean isTemPermissoesDeMaster() {
		return temPermissoesDeMaster;
	}

	public void setTemPermissoesDeMaster(boolean temPermissoesDeMaster) {
		this.temPermissoesDeMaster = temPermissoesDeMaster;
	}

	@Override
	public boolean isMaster() {
		return this.temPermissoesDeMaster;
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

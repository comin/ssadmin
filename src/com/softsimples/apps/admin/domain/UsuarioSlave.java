package com.softsimples.apps.admin.domain;

public class UsuarioSlave extends Usuario {
	
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
}

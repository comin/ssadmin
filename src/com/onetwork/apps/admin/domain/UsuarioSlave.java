package com.onetwork.apps.admin.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="USUARIOSLAVE")
@Inheritance(strategy=InheritanceType.JOINED)
public class UsuarioSlave extends Usuario {
	
	private static final long serialVersionUID = 1L;
	private boolean temPermissoesDeMaster;

	public UsuarioSlave() {}

	@Column(name="PERMISSOES_MASTER")
	public boolean isTemPermissoesDeMaster() {
		return temPermissoesDeMaster;
	}

	public void setTemPermissoesDeMaster(boolean temPermissoesDeMaster) {
		this.temPermissoesDeMaster = temPermissoesDeMaster;
	}

	@Override
	@Transient
	public boolean isMaster() {
		return this.temPermissoesDeMaster;
	}
}

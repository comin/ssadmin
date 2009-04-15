package com.onetwork.apps.admin.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="USUARIOSLAVE")
@Inheritance(strategy=InheritanceType.JOINED)
public class UsuarioSlave extends Usuario {
	
	private static final long serialVersionUID = 1L;
	private UsuarioMaster usuarioMaster;
	private boolean temPermissoesDeMaster;

	public UsuarioSlave() {}

	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="USUARIO_MASTER")
	public UsuarioMaster getUsuarioMaster() {
		return usuarioMaster;
	}

	public void setUsuarioMaster(UsuarioMaster usuarioMaster) {
		this.usuarioMaster = usuarioMaster;
	}

	@Column(name="PERMISSOES_MASTER")
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

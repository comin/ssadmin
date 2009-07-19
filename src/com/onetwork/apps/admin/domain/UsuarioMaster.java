package com.onetwork.apps.admin.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="USUARIOMASTER")
@Inheritance(strategy=InheritanceType.JOINED)
public class UsuarioMaster extends Usuario {

	private static final long serialVersionUID = 1L;
	private List<UsuarioSlave> usuarios;
	
	public UsuarioMaster() {}

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="USUARIO_MASTER")
	public List<UsuarioSlave> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioSlave> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	@Transient
	public boolean isMaster() {
		return true;
	}
}

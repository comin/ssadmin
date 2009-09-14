package com.softsimples.apps.admin.domain;

import java.util.ArrayList;
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

import com.softsimples.apps.admin.exception.JaExisteUsuarioComEsteLoginException;

@Entity
@Table(name="USUARIO_MASTER")
@Inheritance(strategy=InheritanceType.JOINED)
public class UsuarioMaster extends Usuario {

	private static final long serialVersionUID = 1L;
	private List<UsuarioSlave> usuarios;
	
	public UsuarioMaster() {}

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="USUARIO_MASTER")
	public List<UsuarioSlave> getUsuarios() {
		if (this.usuarios == null) this.usuarios = new ArrayList<UsuarioSlave>();
		return this.usuarios;
	}

	public void setUsuarios(List<UsuarioSlave> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	@Transient
	public boolean isMaster() {
		return true;
	}

	public void jaExisteUsuarioSlaveComEsteLoginParaCadastro(String login) throws JaExisteUsuarioComEsteLoginException {
		List<UsuarioSlave> slaves = this.getUsuarios();
		for (UsuarioSlave usuarioSlave : slaves) {
			if (usuarioSlave.getLogin().equals(login)) throw new JaExisteUsuarioComEsteLoginException();
		}
	}

	public void adicionarUsuarioSlave(UsuarioSlave usuarioSlave) {
		this.getUsuarios().add(usuarioSlave);
	}
}

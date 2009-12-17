package com.softsimples.apps.admin.domain;

import java.util.ArrayList;
import java.util.List;

import com.softsimples.apps.admin.exception.JaExisteUsuarioComEsteLoginException;

public class UsuarioMaster extends Usuario {

	private List<UsuarioSlave> usuarios;
	
	public UsuarioMaster() {}

	public List<UsuarioSlave> getUsuarios() {
		if (this.usuarios == null) this.usuarios = new ArrayList<UsuarioSlave>();
		return this.usuarios;
	}

	public void setUsuarios(List<UsuarioSlave> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public boolean isMaster() {
		return true;
	}

	public void jaExisteUsuarioSlaveComEsteLoginParaCadastro(String login) throws JaExisteUsuarioComEsteLoginException {
//		List<UsuarioSlave> slaves = this.getUsuarios();
//		for (UsuarioSlave usuarioSlave : slaves) {
//			if (usuarioSlave.getLogin().equals(login)) throw new JaExisteUsuarioComEsteLoginException();
//		}
	}

	public void adicionarUsuarioSlave(UsuarioSlave usuarioSlave) {
		this.getUsuarios().add(usuarioSlave);
	}
}

package com.softsimples.apps.admin.controller;

import java.io.IOException;
import java.util.List;

import com.softsimples.apps.admin.AdminActivatorImpl;
import com.softsimples.apps.admin.domain.Usuario;
import com.softsimples.apps.admin.view.UsuarioView;
import com.softsimples.controller.MetodoPublico;
import com.softsimples.controller.SecurityController;

public class UsuarioController extends SecurityController<Usuario> {

	public UsuarioController() {
		super(AdminActivatorImpl.getInstance().getApplication());
	}
	
	@SuppressWarnings("unchecked")
	public UsuarioView getView() {
		return super.getView();
	}

	@MetodoPublico
	public void login() throws Exception {
		Usuario usuario = Usuario.login(json());
		this.setUsuarioDaSessao(usuario);
		this.getView().login(usuario);
	}
	
	public void logout() throws Exception {
		Usuario usuario =  this.getUsuarioDaSessao();
		usuario.setLogado(false);
		usuario.save(this.getApplication());
		this.setUsuarioDaSessao(null);
		this.getView().logout(usuario);
	}

	public void listarUsuarios() throws IOException {		
		List<Usuario> usuarios = Usuario.findAll();
		this.getView().listarUsuarios(usuarios);
	}	
}
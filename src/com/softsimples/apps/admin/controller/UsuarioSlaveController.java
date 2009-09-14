package com.softsimples.apps.admin.controller;

import org.json.JSONObject;

import com.softsimples.apps.admin.domain.Usuario;
import com.softsimples.apps.admin.domain.UsuarioMaster;
import com.softsimples.apps.admin.domain.UsuarioSlave;

public class UsuarioSlaveController extends UsuarioController {

	public UsuarioSlaveController() {}

	public void adicionarUsuario() throws Exception {
		Usuario usuario = this.getUsuarioDaSessao();
		if (usuario.isMaster()) {
			JSONObject jsonObject = this.json();
			UsuarioMaster usuarioMaster = (UsuarioMaster)usuario;
			usuarioMaster.jaExisteUsuarioSlaveComEsteLoginParaCadastro(jsonObject.getString("login"));
			UsuarioSlave usuarioSlave = buildNewInstance(UsuarioSlave.class, jsonObject);
			usuarioMaster.adicionarUsuarioSlave(usuarioSlave);
			usuarioMaster.save();
			this.escreverVODeCadastroOK(usuarioSlave);
		} else throw new UsuarioMasterRequerido();
		
	}
	
	public void removerUsuario() throws Exception {
		JSONObject jsonObject = this.json();
		Usuario usuario = Usuario.existeUsuarioComEsteOidParaExclusao(jsonObject.getString("oid"));
		usuario.delete();
		this.escreverVODeCadastroOK(usuario);
	}
}
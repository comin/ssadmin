package com.softsimples.apps.admin.controller;

import org.json.JSONObject;

import com.softsimples.apps.admin.domain.Usuario;
import com.softsimples.apps.admin.domain.UsuarioSlave;

public class UsuarioSlaveController extends UsuarioController {

	public UsuarioSlaveController() {}

	public void adicionarUsuarioSlave() throws Exception {
		JSONObject jsonObject = this.json();
		Usuario.jaExisteUsuarioComEsteLoginParaCadastro(jsonObject.getString("login"));		
		UsuarioSlave usuarioSlave = buildNewInstance(UsuarioSlave.class, jsonObject);
		usuarioSlave.save();
		this.escreverVODeCadastroOK(usuarioSlave);
	}
	
	public void removerUsuarioSlave() throws Exception {
		JSONObject jsonObject = this.json();
		Usuario usuario = Usuario.existeUsuarioComEsteOidParaExclusao(jsonObject.getString("oid"));
		usuario.delete();
		this.escreverVODeCadastroOK(usuario);
	}
}
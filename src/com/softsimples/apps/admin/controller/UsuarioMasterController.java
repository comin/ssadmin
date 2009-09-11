package com.softsimples.apps.admin.controller;

import org.json.JSONObject;

import com.softsimples.apps.admin.domain.Usuario;
import com.softsimples.apps.admin.domain.UsuarioMaster;


public class UsuarioMasterController extends UsuarioController {

	public UsuarioMasterController() {}

	public void adicionarUsuarioMaster() throws Exception {
		JSONObject jsonObject = this.json();
		Usuario.jaExisteUsuarioComEsteLoginParaCadastro(jsonObject.getString("login"));
		UsuarioMaster usuarioMaster = buildNewInstance(UsuarioMaster.class, jsonObject);
		usuarioMaster.save();
		this.escreverVODeCadastroOK(usuarioMaster);
	}
	
	public void removerUsuarioMaster() throws Exception {
		JSONObject jsonObject = this.json();
		Usuario usuario = Usuario.existeUsuarioComEsteOidParaExclusao(jsonObject.getString("oid"));
		usuario.delete();
		this.escreverVODeCadastroOK(usuario);
	}
}
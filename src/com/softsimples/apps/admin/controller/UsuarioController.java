package com.softsimples.apps.admin.controller;

import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONArrayImpl;
import org.json.JSONObject;
import org.json.JSONObjectImpl;

import com.softsimples.apps.admin.AdminActivatorImpl;
import com.softsimples.apps.admin.domain.Usuario;
import com.softsimples.controller.SecurityController;
import com.softsimples.controller.MetodoPublico;

public class UsuarioController extends SecurityController<Usuario> {

	public UsuarioController() {
		setApplication(AdminActivatorImpl.getInstance().getApplication());
	}

	@MetodoPublico
	public void login() throws Exception {
		Usuario user = Usuario.login(json());
		noticaLoginOk(user);
	}
	
	public void logout() throws IOException {
		Usuario usuario =  this.getUsuarioDaSessao();
		usuario.setLogado(false);
		usuario.save();
		this.setUsuarioDaSessao(null);
		JSONObject jsonUser = new JSONObjectImpl();
		jsonUser.put("nome", usuario.getNome());
		this.getView().write(jsonUser);
	}

	private void noticaLoginOk(Usuario user) throws IOException {
		this.setUsuarioDaSessao(user);
		JSONObject jsonUser = new JSONObjectImpl();
		jsonUser.put("oid", user.getOid());
		jsonUser.put("nome", user.getNome());
		this.getView().write(jsonUser);
	}
	
	public void escreverVODeCadastroOK(Usuario usuario) throws Exception {
		JSONObject vo = new JSONObjectImpl();
		vo.put("oid", usuario.getOid());
		vo.put("nome", usuario.getNome());
		this.getView().write(vo);
	}

	public void listarUsuarios() throws IOException {		
		List<Usuario> listaUsuarios = Usuario.findAll();
		JSONArray jsonUsers = new JSONArrayImpl();
		if (listaUsuarios != null) for (Usuario usuario : listaUsuarios) jsonUsers.put(Usuario.userToJSON(usuario));
		this.getView().write(jsonUsers);
	}	
}
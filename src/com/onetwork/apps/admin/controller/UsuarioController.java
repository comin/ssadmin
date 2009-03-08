package com.onetwork.apps.admin.controller;

import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONArrayImpl;
import org.json.JSONObject;
import org.json.JSONObjectImpl;

import com.onetwork.apps.admin.domain.Usuario;
import com.onetwork.controller.SecurityController;
import com.onetwork.controller.SemProtecaoDeAcesso;
import com.onetwork.servlet.Application;

public class UsuarioController extends SecurityController<Usuario> {

	public UsuarioController() {
		super(Application.Administration);
	}

	@Override
	public Class<Usuario> getSessionClass() {
		return Usuario.class;
	}

	@SemProtecaoDeAcesso
	public void login() throws IOException {
		Usuario user = Usuario.login(json());
		if (user != null) noticaLoginOk(user);
		else notificaLoginComFalha();
	}
	
	@SemProtecaoDeAcesso
	public void addNewUser() throws Exception {
		JSONObject jsonObject = this.json();
		if (!Usuario.existUserWithLogin(jsonObject.getString("login"))) {
			this.efetiveAddNewUser(jsonObject);
		} else {
			this.notAddNewUser(jsonObject);
		}
	}

	private void efetiveAddNewUser(JSONObject jsonObject) throws Exception {
		this.beginTransaction();
		Usuario user = new Usuario();
		user.properties(this.json());
		user.save();
		JSONObject jsonUser = new JSONObjectImpl();
		jsonUser.put("oid", user.getOid());
		jsonUser.put("nome", user.getNome());
		this.getViewWithCommitTransaction().write(jsonUser);
	}

	private void notAddNewUser(JSONObject jsonObject) throws IOException {
		this.getView().writeErrorMesage("Usuario ja existe");
	}

	public void removeUser() throws Exception {
		Usuario user = new Usuario();
		user.properties(this.json());
		user.delete();
		JSONObject jsonUser = new JSONObjectImpl();
		jsonUser.put("oid", user.getOid());
		jsonUser.put("nome", user.getNome());
		this.getView().write(jsonUser);
	}

	public void allUsers() throws IOException {		
		List<Usuario> listaUsuarios = Usuario.findAll();
		JSONArray jsonUsers = new JSONArrayImpl();
		if (listaUsuarios != null) for (Usuario usuario : listaUsuarios) jsonUsers.put(Usuario.userToJSON(usuario));
		this.getView().write(jsonUsers);
	}	

	private void notificaLoginComFalha() throws IOException {
		this.getView().writeErrorMesage("Login ou Password invalido!");
	}

	private void noticaLoginOk(Usuario user) throws IOException {
		this.setUsuarioDaSessao(user);
		JSONObject jsonUser = new JSONObjectImpl();
		jsonUser.put("oid", user.getOid());
		jsonUser.put("nome", user.getNome());
		this.getView().write(jsonUser);
	}
}
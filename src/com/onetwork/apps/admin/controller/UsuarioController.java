package com.onetwork.apps.admin.controller;

import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONArrayImpl;
import org.json.JSONObject;
import org.json.JSONObjectImpl;

import com.onetwork.apps.admin.ActivatorImpl;
import com.onetwork.apps.admin.domain.Usuario;
import com.onetwork.apps.admin.domain.UsuarioMaster;
import com.onetwork.apps.admin.domain.UsuarioSlave;
import com.onetwork.controller.SecurityController;
import com.onetwork.controller.SemProtecaoDeAcesso;

public class UsuarioController extends SecurityController<Usuario> {

	public UsuarioController() {
		setApplication(ActivatorImpl.getInstance().getApplication());
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
	
	public void logout() throws IOException {
		Usuario usuario =  this.getUsuarioDaSessao();
		usuario.setLogado(false);
		usuario.save();
		this.setUsuarioDaSessao(null);
		JSONObject jsonUser = new JSONObjectImpl();
		jsonUser.put("nome", usuario.getNome());
		this.getView().write(jsonUser);
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
	
	public void adicionarUsuarioMaster() throws Exception {
		JSONObject jsonObject = this.json();
		Usuario usuario = Usuario.findByLogin(jsonObject.getString("login"));
		if (usuario == null) {
			UsuarioMaster usuarioMaster = buildNewInstance(UsuarioMaster.class);
			usuarioMaster.properties(jsonObject);
			usuarioMaster.save();
			this.escreverVODeCadastroOK(usuarioMaster);
		} else this.getView().writeErrorMesage("Já existe usuário com este login cadastrado!");
	}
	
	public void adicionarUsuarioSlave() throws Exception {
		JSONObject jsonObject = this.json();
		Usuario usuario = Usuario.findByLogin(jsonObject.getString("login"));
		if (usuario == null) {
			UsuarioSlave usuarioSlave = buildNewInstance(UsuarioSlave.class);
			usuarioSlave.properties(jsonObject);
			usuarioSlave.save();
			this.escreverVODeCadastroOK(usuarioSlave);
		} else this.getView().writeErrorMesage("Já existe usuário com este login cadastrado!");
	}
	
	public void escreverVODeCadastroOK(Usuario usuario) throws Exception {
		JSONObject vo = new JSONObjectImpl();
		vo.put("oid", usuario.getOid());
		vo.put("nome", usuario.getNome());
		this.getView().write(vo);
	}
	
	public void removerUsuarioMaster() throws Exception {
		JSONObject jsonObject = this.json();
		Usuario usuario = Usuario.findByLogin(jsonObject.getString("login"));
		if (usuario != null) {
			UsuarioMaster usuarioMaster = buildNewInstance(UsuarioMaster.class);
			usuarioMaster.delete();
			this.escreverVODeCadastroOK(usuarioMaster);
		} else this.getView().writeErrorMesage("Este usuário não esta cadastrado!");
	}
	
	public void removerUsuarioSlave() throws Exception {
		JSONObject jsonObject = this.json();
		Usuario usuario = Usuario.findByLogin(jsonObject.getString("login"));
		if (usuario != null) {
			UsuarioSlave usuarioSlave = buildNewInstance(UsuarioSlave.class);
			usuarioSlave.delete();
			this.escreverVODeCadastroOK(usuarioSlave);
		} else this.getView().writeErrorMesage("Este usuário não esta cadastrado!");
	}

	public void allUsers() throws IOException {		
		List<Usuario> listaUsuarios = Usuario.findAll();
		JSONArray jsonUsers = new JSONArrayImpl();
		if (listaUsuarios != null) for (Usuario usuario : listaUsuarios) jsonUsers.put(Usuario.userToJSON(usuario));
		this.getView().write(jsonUsers);
	}	
}
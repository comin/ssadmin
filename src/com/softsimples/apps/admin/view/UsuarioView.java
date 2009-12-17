package com.softsimples.apps.admin.view;

import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONArrayImpl;
import org.json.JSONObject;
import org.json.JSONObjectImpl;

import com.softsimples.apps.admin.AdminActivatorImpl;
import com.softsimples.apps.admin.domain.Usuario;
import com.softsimples.view.View;

public class UsuarioView extends View {

	public UsuarioView() {
		super(AdminActivatorImpl.getInstance().getApplication());
	}
	
	public void login(Usuario usuario) throws IOException {
		JSONObject jsonUser = new JSONObjectImpl();
//		jsonUser.put("oid", usuario.getOid());
//		jsonUser.put("nome", usuario.getNome());
		this.write(jsonUser);
	}
	
	public void logout(Usuario usuario) throws IOException {
		JSONObject jsonUser = new JSONObjectImpl();
//		jsonUser.put("nome", usuario.getNome());
		this.write(jsonUser);
	}
	
	public void adicionarUsuario(Usuario usuario) throws IOException {
		this.escreverVOPadraoParaOperacoesDeAdicionarERemover(usuario);
	}
	
	public void removerUsuario(Usuario usuario) throws IOException {
		this.escreverVOPadraoParaOperacoesDeAdicionarERemover(usuario);
	}
	
	public void listarUsuarios(List<Usuario> usuarios) throws IOException {
		JSONArray jsonUsers = new JSONArrayImpl();
		if (usuarios != null) for (Usuario usuario : usuarios) {
			JSONObject jsonUser = new JSONObjectImpl();
//			jsonUser.put("nome",usuario.getNome());
//			jsonUser.put("login", usuario.getLogin());
//			jsonUser.put("password", usuario.getPassword());
//			jsonUser.put("enderecos", usuario.getEnderecos());
//			jsonUser.put("contas",usuario.getContas());
//			jsonUser.put("preferenciasPessoais",usuario.getPreferenciasPessoais());
//			jsonUsers.put(jsonUser);
		}
		this.write(jsonUsers);
	}
	
	private void escreverVOPadraoParaOperacoesDeAdicionarERemover(Usuario usuario) throws IOException {
		JSONObject vo = new JSONObjectImpl();
		vo.put("oid", usuario.getOid());
//		vo.put("nome", usuario.getNome());
		this.write(vo);
	}
}
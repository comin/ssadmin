package com.onetwork.apps.admin.controller;

import com.onetwork.apps.admin.domain.Usuario;
import com.onetwork.controller.Controller;
import com.onetwork.domain.Domain;
import com.onetwork.servlet.Application;

public class SecurityController<T> extends Controller<T> {

	public SecurityController(Application application) {
		super(application);
	}
	
	public Usuario getUsuarioDaSessao() {
		Usuario usuario = null;
		String userOid = (String)this.parameters().get("sessionid");
		if (userOid != null && userOid.trim().length() > 0) {
			usuario =Domain.findByOid(Usuario.class, userOid);
		}
		return usuario;
	}
	
	@Override
	public void execute(String string) throws Exception {
		Usuario usuario = getUsuarioDaSessao(); 
		if (usuario!= null && usuario.isLogado()) super.execute(string);
		else this.getView().writeErrorMesage("É necessário estar logado para executar esta operação!");
	}
}

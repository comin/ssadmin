package com.onetwork.apps.admin.controller;

public class UsuarioNaoCadastrado extends Exception {

	private static final long serialVersionUID = 1L;

	public UsuarioNaoCadastrado() {
		super("Este usuário não esta cadastrado!");
	}
}

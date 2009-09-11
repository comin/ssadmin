package com.softsimples.apps.admin.exception;

public class UsuarioNaoCadastradoException extends Exception {

	private static final long serialVersionUID = 1L;

	public UsuarioNaoCadastradoException() {
		super("Este usuário não esta cadastrado!");
	}
}

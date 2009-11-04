package com.softsimples.apps.admin.exception;

public class UsuarioMasterRequeridoException extends Exception {

	private static final long serialVersionUID = 1L;

	public UsuarioMasterRequeridoException() {
		super("Usuário master é requerido!");
	}
}

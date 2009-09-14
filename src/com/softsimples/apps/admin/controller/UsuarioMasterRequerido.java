package com.softsimples.apps.admin.controller;

public class UsuarioMasterRequerido extends Exception {

	private static final long serialVersionUID = 1L;

	public UsuarioMasterRequerido() {
		super("Usuário master é requerido!");
	}
}

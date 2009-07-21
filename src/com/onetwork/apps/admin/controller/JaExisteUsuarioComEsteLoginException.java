package com.onetwork.apps.admin.controller;

public class JaExisteUsuarioComEsteLoginException extends Exception {

	private static final long serialVersionUID = 1L;

	public JaExisteUsuarioComEsteLoginException() {
		super("Já existe usuário com este login cadastrado!");
	}
}

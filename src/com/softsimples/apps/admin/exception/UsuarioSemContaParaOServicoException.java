package com.softsimples.apps.admin.exception;


public class UsuarioSemContaParaOServicoException extends Exception {

	private static final long serialVersionUID = 1L;

	public UsuarioSemContaParaOServicoException() {
		super("Usuário não tem conta para este serviço");
	}
}

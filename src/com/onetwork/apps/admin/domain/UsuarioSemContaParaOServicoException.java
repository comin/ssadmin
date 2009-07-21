package com.onetwork.apps.admin.domain;

public class UsuarioSemContaParaOServicoException extends Exception {

	private static final long serialVersionUID = 1L;

	public UsuarioSemContaParaOServicoException() {
		super(Usuario.USUARIO_NAO_TEM_CONTA_PARA_ESTE_SERVICO);
	}
}

package com.softsimples.apps.admin.exception;

import com.softsimples.apps.admin.domain.Usuario;

public class UsuarioSemContaParaOServicoException extends Exception {

	private static final long serialVersionUID = 1L;

	public UsuarioSemContaParaOServicoException() {
		super(Usuario.USUARIO_NAO_TEM_CONTA_PARA_ESTE_SERVICO);
	}
}

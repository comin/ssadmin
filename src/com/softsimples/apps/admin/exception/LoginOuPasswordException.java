package com.softsimples.apps.admin.exception;

public class LoginOuPasswordException extends Exception {

	private static final long serialVersionUID = 1L;

	public LoginOuPasswordException() {
		super("Login ou Password invalido!");
	}
}

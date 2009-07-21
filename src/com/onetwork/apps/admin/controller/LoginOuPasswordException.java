package com.onetwork.apps.admin.controller;

public class LoginOuPasswordException extends Exception {

	private static final long serialVersionUID = 1L;

	public LoginOuPasswordException() {
		super("Login ou Password invalido!");
	}
}

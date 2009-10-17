package com.softsimples.apps.admin;

import com.softsimples.activator.Activator;


public class AdminActivatorImpl extends Activator {

	private static final String APPLICATION = "admin";
	private static Activator INSTANCE = new AdminActivatorImpl();
	
	private AdminActivatorImpl() {
		super(APPLICATION);
	}
	
	public static Activator getInstance() {
		return INSTANCE;
	}

	@Override
	public void startModule() {}
}

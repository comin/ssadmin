package com.softsimples.apps.admin;

import com.softsimples.activator.Activator;


public class AdminActivatorImpl extends Activator {

	private static final String APPLICATION = "admin";
	private static Activator INSTANCE = null;
	
	private AdminActivatorImpl() {
		super(APPLICATION);
	}
	
	public static Activator getInstance() {
		if (INSTANCE == null) INSTANCE = new AdminActivatorImpl();
		return INSTANCE;
	}

	@Override
	public void startModule() {}
}

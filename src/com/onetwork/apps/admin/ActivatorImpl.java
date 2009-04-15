package com.onetwork.apps.admin;

import com.onetwork.activator.Activator;


public class ActivatorImpl extends Activator {

	private static final String APPLICATION = "admin";
	private static Activator INSTANCE = null;
	
	private ActivatorImpl() {
		super(APPLICATION);
	}
	
	public static Activator getInstance() {
		if (INSTANCE == null) INSTANCE = new ActivatorImpl();
		return INSTANCE;
	}

	@Override
	public void startModule() {}
}

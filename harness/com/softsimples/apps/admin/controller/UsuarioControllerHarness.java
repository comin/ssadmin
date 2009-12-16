package com.softsimples.apps.admin.controller;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import com.softsimples.apps.admin.domain.Usuario;
import com.softsimples.apps.admin.domain.UsuarioMaster;
import com.softsimples.apps.admin.domain.UsuarioSlave;
import com.softsimples.builder.DomainInstanceBuilder;
import com.softsimples.controller.Controller;
import com.softsimples.servlet.Resource;
import com.softsimples.servlet.ResourceType;


public class UsuarioControllerHarness {
	
	@SuppressWarnings("unchecked")
	@Test
	public void adicionarUsuarioMasterHappyDay() {
		try {
			Mockery context = new Mockery();
			final JSONObject jsonObject = context.mock(JSONObject.class);
			final Map<String, Object> parameters = context.mock(Map.class);
			final HttpServletResponse response = context.mock(HttpServletResponse.class);
			final HttpSession httpSession = context.mock(HttpSession.class);
			final DomainInstanceBuilder domainInstanceBuilder = context.mock(DomainInstanceBuilder.class);
			final List<Usuario> usuarios = context.mock(List.class);
			final StringWriter stringWriter = new StringWriter();
			final PrintWriter printWriter = new PrintWriter(stringWriter);
			final Usuario usuario = new UsuarioMaster();
			
			context.checking(new Expectations() {{
			    oneOf (parameters).get("json");
			    will(returnValue(jsonObject));
			    
			    oneOf (jsonObject).getString("login");
			    will(returnValue("agnaldo@teste.com"));
			    
			    oneOf (usuarios).size();
			    will(returnValue(0));
			    
			    oneOf (domainInstanceBuilder).buildDomainInstance(UsuarioMaster.class);
			    will(returnValue(usuario));
			    
			    oneOf (jsonObject).has("oid");
			    will(returnValue(false));
			    
			    oneOf (jsonObject).has("cadastro");
			    will(returnValue(false));
			    
			    oneOf (jsonObject).has("atualizacao");
			    will(returnValue(false));
			    
			    oneOf (jsonObject).has("nome");
			    will(returnValue(true));
			    
			    oneOf (jsonObject).get("nome");
			    will(returnValue("Agnaldo de Oliveira"));
			    
			    oneOf (jsonObject).has("avatar");
			    will(returnValue(true));
			    
			    oneOf (jsonObject).get("avatar");
			    will(returnValue("c:/teste/agnaldo.jpeg"));
			    
			    oneOf (jsonObject).has("login");
			    will(returnValue(true));
			    
			    oneOf (jsonObject).get("login");
			    will(returnValue("agnaldo@teste.com"));
			    
			    oneOf (jsonObject).has("password");
			    will(returnValue(true));
			    
			    oneOf (jsonObject).get("password");
			    will(returnValue("aaaaaa"));
			    
			    oneOf (jsonObject).has("dataNascimento");
			    will(returnValue(true));
			    
			    oneOf (jsonObject).get("dataNascimento");
			    will(returnValue("60209834400000"));
			    
			    oneOf (jsonObject).has("dataNascimento");
			    will(returnValue(true));
			    
			    oneOf (jsonObject).getString("dataNascimento");
			    will(returnValue("60209834400000"));
			    
			    oneOf (jsonObject).has("enderecos");
			    will(returnValue(false));
			    
			    oneOf (jsonObject).has("contas");
			    will(returnValue(false));
			    
			    oneOf (jsonObject).has("preferenciasPessoais");
			    will(returnValue(false));
			    
			    oneOf (jsonObject).has("logado");
			    will(returnValue(false));
			    
			    oneOf (jsonObject).has("usuarios");
			    will(returnValue(false));
			    
			    oneOf (response).getWriter();
			    will(returnValue(printWriter));
			}});
			
			Resource.add(ResourceType.Parameters, parameters);
			Resource.add(ResourceType.HttpServletResponse, response);
			Resource.add(ResourceType.HttpServletSession, httpSession);
			Resource.add(ResourceType.DomainInstanceBuilder, domainInstanceBuilder);
			Resource.add(ResourceType.Path, new File("").getAbsolutePath());
		
			Controller controller = new UsuarioMasterController();
			controller.execute("adicionarUsuario");
			
			System.out.println(stringWriter.toString());
			
			Resource.removeAll();
			Assert.assertNull(Resource.get(ResourceType.PrevalentSystem));
			Assert.assertNull(Resource.get(ResourceType.Parameters));
			Assert.assertNull(Resource.get(ResourceType.HttpServletResponse));
			Assert.assertNull(Resource.get(ResourceType.HttpServletSession));
			Assert.assertNull(Resource.get(ResourceType.DomainInstanceBuilder));
			Assert.assertNull(Resource.get(ResourceType.Path));
			Assert.assertNull(Resource.get(ResourceType.SessionUser));
		} catch(Exception exception) {
			exception.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void adicionarUsuarioSlaveHappyDay() {
		try {
			Mockery context = new Mockery();
			final JSONObject jsonObject = context.mock(JSONObject.class);
			final Map<String, Object> parameters = context.mock(Map.class);
			final HttpServletResponse response = context.mock(HttpServletResponse.class);
			final HttpSession httpSession = context.mock(HttpSession.class);
			final DomainInstanceBuilder domainInstanceBuilder = context.mock(DomainInstanceBuilder.class);
			final List<Usuario> usuarios = context.mock(List.class);
			final StringWriter stringWriter = new StringWriter();
			final PrintWriter printWriter = new PrintWriter(stringWriter);
			final Usuario usuarioMaster = new UsuarioMaster();
			final Usuario usuario = new UsuarioSlave();
			
			context.checking(new Expectations() {{
				oneOf (httpSession).getAttribute("idUsuario");
			    will(returnValue("1234567890"));
			    
			    oneOf (usuarios).size();
			    will(returnValue(1));
			    
			    oneOf (usuarios).get(0);
			    will(returnValue(usuarioMaster));
			    
				oneOf (parameters).get("json");
			    will(returnValue(jsonObject));
			    
			    oneOf (jsonObject).getString("login");
			    will(returnValue("agnaldo@teste.com"));
			    
			    oneOf (usuarios).size();
			    will(returnValue(0));
			    
			    oneOf (domainInstanceBuilder).buildDomainInstance(UsuarioSlave.class);
			    will(returnValue(usuario));
			    
			    oneOf (jsonObject).has("oid");
			    will(returnValue(false));
			    
			    oneOf (jsonObject).has("cadastro");
			    will(returnValue(false));
			    
			    oneOf (jsonObject).has("atualizacao");
			    will(returnValue(false));
			    
			    oneOf (jsonObject).has("nome");
			    will(returnValue(true));
			    
			    oneOf (jsonObject).get("nome");
			    will(returnValue("Agnaldo de Oliveira"));
			    
			    oneOf (jsonObject).has("avatar");
			    will(returnValue(true));
			    
			    oneOf (jsonObject).get("avatar");
			    will(returnValue("c:/teste/agnaldo.jpeg"));
			    
			    oneOf (jsonObject).has("login");
			    will(returnValue(true));
			    
			    oneOf (jsonObject).get("login");
			    will(returnValue("agnaldo@teste.com"));
			    
			    oneOf (jsonObject).has("password");
			    will(returnValue(true));
			    
			    oneOf (jsonObject).get("password");
			    will(returnValue("aaaaaa"));
			    
			    oneOf (jsonObject).has("dataNascimento");
			    will(returnValue(true));
			    
			    oneOf (jsonObject).get("dataNascimento");
			    will(returnValue("60209834400000"));
			    
			    oneOf (jsonObject).has("dataNascimento");
			    will(returnValue(true));
			    
			    oneOf (jsonObject).getString("dataNascimento");
			    will(returnValue("60209834400000"));
			    
			    oneOf (jsonObject).has("temPermissoesDeMaster");
			    will(returnValue(false));
			    
			    oneOf (jsonObject).has("enderecos");
			    will(returnValue(false));
			    
			    oneOf (jsonObject).has("contas");
			    will(returnValue(false));
			    
			    oneOf (jsonObject).has("preferenciasPessoais");
			    will(returnValue(false));
			    
			    oneOf (jsonObject).has("logado");
			    will(returnValue(false));
			    
			    oneOf (jsonObject).has("usuarios");
			    will(returnValue(false));
			    
			    oneOf (response).getWriter();
			    will(returnValue(printWriter));
			}});
			
			Resource.add(ResourceType.Parameters, parameters);
			Resource.add(ResourceType.HttpServletResponse, response);
			Resource.add(ResourceType.HttpServletSession, httpSession);
			Resource.add(ResourceType.DomainInstanceBuilder, domainInstanceBuilder);
			Resource.add(ResourceType.Path, new File("").getAbsolutePath());
		
			Controller controller = new UsuarioSlaveController();
			controller.execute("adicionarUsuario");
			
			System.out.println(stringWriter.toString());
			
			Resource.removeAll();
			Assert.assertNull(Resource.get(ResourceType.PrevalentSystem));
			Assert.assertNull(Resource.get(ResourceType.Parameters));
			Assert.assertNull(Resource.get(ResourceType.HttpServletResponse));
			Assert.assertNull(Resource.get(ResourceType.HttpServletSession));
			Assert.assertNull(Resource.get(ResourceType.DomainInstanceBuilder));
			Assert.assertNull(Resource.get(ResourceType.Path));
			Assert.assertNull(Resource.get(ResourceType.SessionUser));
		} catch(Exception exception) {
			exception.printStackTrace();
			Assert.assertTrue(false);
		}
	}
}
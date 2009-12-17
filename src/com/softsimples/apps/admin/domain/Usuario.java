package com.softsimples.apps.admin.domain;

import java.util.List;

import org.json.JSONObject;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.softsimples.apps.admin.AdminActivatorImpl;
import com.softsimples.apps.admin.exception.ContaExistenteException;
import com.softsimples.apps.admin.exception.JaExisteUsuarioComEsteLoginException;
import com.softsimples.apps.admin.exception.LoginOuPasswordException;
import com.softsimples.apps.admin.exception.UsuarioNaoCadastradoException;
import com.softsimples.apps.admin.exception.UsuarioSemContaParaOServicoException;
import com.softsimples.domain.Domain;

public abstract class Usuario extends Domain {

	/*
	private String nome;
	private String avatar;	
	private String login;
	private String password;
	private Date dataNascimento;
	private List<Endereco> enderecos;
	private List<Conta> contas;
	private PreferenciasPessoais preferenciasPessoais;
	private boolean logado; 
	*/
	
	public Usuario() {
		this.vo = new BasicDBObject();
		this.vo.put("nome", "");
		this.vo.put("avatar", "");
		this.vo.put("login", "");
		this.vo.put("password", "");
		this.vo.put("dataNascimento", null);
		this.vo.put("logado", false);
		this.vo.put("enderecos", new BasicDBList());
		this.vo.put("preferenciasPessoais", new BasicDBObject());
		
	}
	
	public void adicionarNovaConta(Assinatura conta) throws ContaExistenteException {
//		Conta contaExistente = procuraPorContaDaAplicacao(conta.getApplication());
//		if (contaExistente == null) contas.add(conta);
//		else throw new ContaExistenteException("Usuário já contem uma conta para esta aplicação!");
	}
	
	@SuppressWarnings("unchecked")
	public <T> T procuraPorContaDaAplicacao(String application) {
//		Conta conta = null;
//		List<Conta> cachedContas = this.getContas();
//		for (Conta cachedConta : cachedContas) {
//			if (cachedConta.getApplication().equalsIgnoreCase(application)) {
//				conta = cachedConta;
//				break;
//			}
//		}
//		return (T)conta;
		return null;
	}

	public static boolean existUserWithLogin(String login) {
		Usuario user = findByLogin("obj.login = '"+login+"'");
		return (user != null);
	};

	public static Usuario findByLogin(String login) {
		return null;
	}
	
	public static Usuario findByLoginAndPassword(String where) {
		return null;
	}
	
	public static List<Usuario> findAll() {
		return null;
	}

	public static Usuario login(JSONObject json) throws LoginOuPasswordException {
		return null;
	}

	public abstract boolean isMaster();
	
	public void setMaster(boolean master){};
	
	public Assinatura tenhoContaNesteServico(String application) throws UsuarioSemContaParaOServicoException {
		Assinatura conta = this.procuraPorContaDaAplicacao(application);
		if (conta == null) throw new UsuarioSemContaParaOServicoException();
		return conta;
	}

	public static void jaExisteUsuarioComEsteLoginParaCadastro(String login) throws JaExisteUsuarioComEsteLoginException {
		Usuario usuario = Usuario.findByLogin(login);
		if (usuario != null) throw new JaExisteUsuarioComEsteLoginException();
	}
	
	public static Usuario existeUsuarioComEsteOidParaExclusao(String oid) throws Exception {
		Usuario usuario = Usuario.findByOid(AdminActivatorImpl.getInstance().getApplication(), Usuario.class, oid);
		if (usuario != null) throw new UsuarioNaoCadastradoException();
		return usuario;
	}
}

package com.softsimples.apps.admin.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;

import com.softsimples.apps.admin.AdminActivatorImpl;
import com.softsimples.apps.admin.exception.ContaExistenteException;
import com.softsimples.apps.admin.exception.JaExisteUsuarioComEsteLoginException;
import com.softsimples.apps.admin.exception.LoginOuPasswordException;
import com.softsimples.apps.admin.exception.UsuarioNaoCadastradoException;
import com.softsimples.apps.admin.exception.UsuarioSemContaParaOServicoException;
import com.softsimples.domain.Domain;

public abstract class Usuario extends Domain {

	private String nome;
	private String avatar;	
	private String login;
	private String password;
	private Date dataNascimento;
	private List<Endereco> enderecos;
	private List<Conta> contas;
	private PreferenciasPessoais preferenciasPessoais;
	private boolean logado; 
	
	public Usuario() {}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public List<Conta> getContas() {
		if (contas == null) this.contas = new ArrayList<Conta>();
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}
	
	public void adicionarNovaConta(Conta conta) throws ContaExistenteException {
		Conta contaExistente = procuraPorContaDaAplicacao(conta.getApplication());
		if (contaExistente == null) this.getContas().add(conta);
		else throw new ContaExistenteException("Usuário já contem uma conta para esta aplicação!");
	}
	
	@SuppressWarnings("unchecked")
	public <T> T procuraPorContaDaAplicacao(String application) {
		Conta conta = null;
		List<Conta> cachedContas = this.getContas();
		for (Conta cachedConta : cachedContas) {
			if (cachedConta.getApplication().equalsIgnoreCase(application)) {
				conta = cachedConta;
				break;
			}
		}
		return (T)conta;
	}

	public PreferenciasPessoais getPreferenciasPessoais() {
		return preferenciasPessoais;
	}

	public void setPreferenciasPessoais(PreferenciasPessoais preferenciasPessoais) {
		this.preferenciasPessoais = preferenciasPessoais;
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

	public boolean isLogado() {
		return this.logado;
	}

	public void setLogado(boolean estaLogado) {
		this.logado = estaLogado;
	}
	
	public abstract boolean isMaster();
	
	public void setMaster(boolean master){};
	
	public Conta tenhoContaNesteServico(String application) throws UsuarioSemContaParaOServicoException {
		Conta conta = this.procuraPorContaDaAplicacao(application);
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

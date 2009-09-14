package com.softsimples.apps.admin.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Query;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.json.JSONObject;
import org.json.JSONObjectImpl;

import com.softsimples.apps.admin.exception.ContaExistenteException;
import com.softsimples.apps.admin.exception.JaExisteUsuarioComEsteLoginException;
import com.softsimples.apps.admin.exception.LoginOuPasswordException;
import com.softsimples.apps.admin.exception.UsuarioNaoCadastradoException;
import com.softsimples.apps.admin.exception.UsuarioSemContaParaOServicoException;
import com.softsimples.domain.Domain;
import com.softsimples.servlet.Resource;
import com.softsimples.servlet.ResourceType;

@MappedSuperclass
public abstract class Usuario extends Domain {

	private static final long serialVersionUID = 1L;
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
	
	@Column(name="NOME")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name="AVATAR")
	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Column(name="LOGIN")
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name="PASSWORD")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_NASCIMENTO")
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="USUARIO")
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="USUARIO")
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

	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="PREFERENCIAS_PESSOAIS")
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

	@SuppressWarnings("unchecked")
	public static Usuario findByLogin(String login) {
		EntityManager entityManager = Resource.get(ResourceType.PrevalentSystem);
		Query query = entityManager.createQuery("from "+Usuario.class.getName()+" as obj where obj.login = '"+login+"'");
		List<Usuario> listaUsuario = query.getResultList();
		if (listaUsuario != null && listaUsuario.size() > 0) return listaUsuario.get(0); 
		else return null;
	}
	
	@SuppressWarnings("unchecked")
	public static Usuario findByLoginAndPassword(String where) {
		EntityManager entityManager = Resource.get(ResourceType.PrevalentSystem);
		Query query = entityManager.createQuery("from "+Usuario.class.getName()+" as obj where "+where);
		List<Usuario> listaUsuario = query.getResultList();
		if (listaUsuario != null && listaUsuario.size() > 0) return listaUsuario.get(0); 
		else return null;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Usuario> findAll() {
		EntityManager entityManager = Resource.get(ResourceType.PrevalentSystem);
		Query query = entityManager.createQuery("from "+Usuario.class.getName()+" as obj");
		return (List<Usuario>)query.getResultList();
	}

	public static Usuario login(JSONObject json) throws LoginOuPasswordException {
		Usuario usuario = Usuario.findByLoginAndPassword(" obj.login = '"+json.getString("login")+"' AND obj.password = '"+json.getString("password")+"'");
		if (usuario == null) throw new LoginOuPasswordException();
		return usuario;
	}
	
	public static JSONObject userToJSON(Usuario usuario) {
		JSONObject jsonUser = new JSONObjectImpl();
		jsonUser.put("nome",usuario.getNome());
		jsonUser.put("login", usuario.getLogin());
		jsonUser.put("password", usuario.getPassword());
		jsonUser.put("enderecos", usuario.getEnderecos());
		jsonUser.put("contas",usuario.getContas());
		jsonUser.put("preferenciasPessoais",usuario.getPreferenciasPessoais());
		return jsonUser;
	}

	public boolean isLogado() {
		return this.logado;
	}

	public void setLogado(boolean estaLogado) {
		this.logado = estaLogado;
	}
	
	@Transient
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
	
	public static Usuario existeUsuarioComEsteOidParaExclusao(String oid) throws UsuarioNaoCadastradoException {
		Usuario usuario = Usuario.findByOid(Usuario.class, oid);
		if (usuario != null) throw new UsuarioNaoCadastradoException();
		return usuario;
	}
}

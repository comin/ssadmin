package com.onetwork.apps.admin.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Query;
import javax.persistence.Table;

import org.json.JSONObject;
import org.json.JSONObjectImpl;

import com.onetwork.domain.Domain;
import com.onetwork.servlet.Resource;
import com.onetwork.servlet.ResourceType;

@Entity
@Table(name="USUARIO")
@Inheritance(strategy=InheritanceType.JOINED)
public class Usuario extends Domain {

	private static final long serialVersionUID = 1L;
	private String nome;
	private String login;
	private String password;
	private List<Endereco> enderecos;
	private Endereco endereco;
	private List<Conta> contas;
	private PreferenciasPessoais preferenciasPessoais;
	
	public Usuario() {}

	@Column(name="NOME")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="USUARIO")
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="ENDERECO")
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="USUARIO")
	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="PREFERENCIASPESSOAIS")
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
	public static Usuario findByLogin(String where) {
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

	public static Usuario login(JSONObject json) {
		return null;
	}
	
	public static JSONObject userToJSON(Usuario usuario) {
		JSONObject jsonUser = new JSONObjectImpl();
		jsonUser.put("nome",usuario.getNome());
		jsonUser.put("login", usuario.getLogin());
		jsonUser.put("password", usuario.getPassword());
		jsonUser.put("enderecos", usuario.getEnderecos());
		jsonUser.put("endereco", usuario.getEndereco());
		jsonUser.put("contas",usuario.getContas());
		jsonUser.put("preferenciasPessoais",usuario.getPreferenciasPessoais());
		return jsonUser;
	}
}

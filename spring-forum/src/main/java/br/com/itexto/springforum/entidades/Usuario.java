package br.com.itexto.springforum.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity @Table(name="usuario")
public class Usuario implements java.io.Serializable {
	
	@Id @Generated(GenerationTime.INSERT) 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", unique=true) 
	protected long id;
	
	public long getId() {return id;}
	public void setId(long valor) {this.id = valor;}
	
	@NotNull @NotEmpty
	@Column(name="nome", nullable=false, length=128)
	private String nome;
	@Email(message="Isto não é e-mail") @NotNull @NotEmpty
	@Column(name="email", nullable=false, length=128, unique=true)
	private String email;
	@NotNull
	@Column(name="data_cadastro", nullable=false) @Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro = new Date();
	@NotNull @NotEmpty
	@Size(min=8, max=32, message="Login muito curto ou muito longo") 
	@Column(name="login", nullable=false, unique=true, length=64)
	private String login;
	@Column(name="twitter", nullable=true, length=64, unique=true)
	private String twitter;
	
	
	
	
	private transient String senha;
	@Column(name="ultimo_login", nullable=true) @Temporal(TemporalType.TIMESTAMP)
	private Date ultimoLogin;
	
	
	@Column(name="hash_senha", nullable=false, length=128)
	private String hashSenha;
	
	public String getHashSenha() {return hashSenha;}
	public void setHashSenha(String valor) {hashSenha = valor;}
	
	
	
	public Date getUltimoLogin() {return ultimoLogin;}
	public void setUltimoLogin(Date data) {ultimoLogin = data;}
	
	public String getTwitter() {return twitter;}
	public void setTwitter(String valor) {twitter = valor;}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		setHashSenha(org.apache.commons.codec.digest.DigestUtils.sha256Hex(senha));
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	

}

package br.com.itexto.springforum.entidades;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Usuario extends Entidade {
	
	
	@NotNull @NotEmpty
	private String nome;
	@Email(message="Isto não é um e-mail") @NotNull @NotEmpty
	private String email;
	@NotNull
	private Date dataCadastro = new Date();
	@NotNull @NotEmpty
	@Size(min=8, max=32, message="Login muito curto ou muito longo") 
	private String login;
	
	private String twitter;
	
	private String senha;
	
	private Date ultimoLogin;
	
	private Assunto assunto;
	public Assunto getAssunto() {return assunto;}
	public void setAssunto(Assunto ass) {assunto = ass;}
	
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

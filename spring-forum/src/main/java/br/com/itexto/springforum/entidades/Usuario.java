package br.com.itexto.springforum.entidades;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Usuario extends Entidade {
	
	@Size(max=128) @NotNull @NotEmpty
	private String nome;
	@Email @NotNull @NotEmpty
	private String email;
	@NotNull
	private Date dataCadastro = new Date();
	@Size(min=8, max=32) @NotNull @NotEmpty
	private String login;
	
	private String senha;
	

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
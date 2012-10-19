package br.com.itexto.springforum.dao;

import java.util.List;

import br.com.itexto.springforum.entidades.PermissaoUsuario;
import br.com.itexto.springforum.entidades.Usuario;

public interface DAOPermissaoUsuario {
	
	public List<PermissaoUsuario> getPermissoesUsuario(Usuario usuario);
	
	public void addRole(String role, Usuario usuario);
	
}

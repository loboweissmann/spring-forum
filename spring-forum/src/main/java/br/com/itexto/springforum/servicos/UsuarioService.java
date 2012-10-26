package br.com.itexto.springforum.servicos;

import org.springframework.security.access.annotation.Secured;

import br.com.itexto.springforum.entidades.Usuario;

public class UsuarioService {
	// Usando SpEL
	@Secured("hasRole('ROLE_ADMIN')")
	public void banir(Usuario usuario) {
		
	}
	// Passando uma lista de permissões
	@Secured({"ROLE_ADMIN", "ROLE_MODERADOR"})
	public void advertir(Usuario usuario, String mensagem) {
		
	}

}

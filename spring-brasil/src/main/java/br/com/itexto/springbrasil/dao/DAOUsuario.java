package br.com.itexto.springbrasil.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.itexto.springbrasil.entidades.Usuario;

@Component("daoUsuario")
public class DAOUsuario {
	
	private List<Usuario> todos;
	
	public List<Usuario> list() {
		if (todos == null) {
			todos = new ArrayList();
			String[] nomes = {"Henrique Lobo", "Kico", "Josué", "Amadeus", "Carvalhinho", "John McCarty"};
			for (int i = 0; i < nomes.length; i++) {
				Usuario usuario = new Usuario();
				usuario.setNome(nomes[i]);
				usuario.setId(i + 1);
				usuario.setEmail(nomes[i] + "@spring.com");
				usuario.setLogin(nomes[i].replaceAll(" ", "_").toLowerCase());
				usuario.setSenha(usuario.getLogin());
				todos.add(usuario);
			}
		}
		return todos;
	}
	
}

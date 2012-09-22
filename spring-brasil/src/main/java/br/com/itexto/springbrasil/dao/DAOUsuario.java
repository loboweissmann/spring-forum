package br.com.itexto.springbrasil.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.itexto.springbrasil.entidades.Usuario;

@Component("daoUsuario")
public class DAOUsuario extends DAOBase<Usuario> {
	
	private List<Usuario> todos;
	
	public List<Usuario> list(int offset, int max) {
		if (todos == null) {
			todos = new ArrayList<Usuario>();
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
	
	public void persistir(Usuario obj) {
		list(-1,-1).add(obj);
	}
	
	public void excluir(Usuario obj) {
		list(-1,-1).remove(obj);
	}
	
	public Class getClazz() {
		return Usuario.class;
	}
	
	
	
}

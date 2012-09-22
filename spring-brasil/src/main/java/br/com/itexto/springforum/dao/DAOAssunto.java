package br.com.itexto.springforum.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.itexto.springforum.entidades.Assunto;

@Component("daoAssunto")
public class DAOAssunto {
	
	private List<Assunto> todos;
	
	public List<Assunto> list() {
		if (todos == null) {
			todos = new ArrayList<Assunto>();
			String[] assuntos = {"Container IoC", "AOP", "Spring MVC", "ORM", "Spring Batch", "Spring WebFlow"};
			for (int i = 0; i < assuntos.length; i++) {
				Assunto assunto = new Assunto();
				assunto.setNome(assuntos[i]);
				assunto.setId(i + 1);
				todos.add(assunto);
			}
			java.util.Collections.sort(todos);
		}
		return todos;
	}
	
}

package br.com.itexto.springforum.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.itexto.springforum.entidades.Assunto;
import br.com.itexto.springforum.entidades.Topico;
import br.com.itexto.springforum.entidades.Usuario;

@Component("daoTopico")
public class DAOTopico {
	
	private List<Topico> topicos = new ArrayList<Topico>();
	
	@Autowired
	private DAOAssunto daoAssunto;
	
	public DAOAssunto getDaoAssunto() {return daoAssunto;}
	public void setDaoAssunto(DAOAssunto dao) {daoAssunto = dao;}
	
	private String[] titulos = {"Como eu configuro o Spring?", 
								"Problema com suporte a DAO", 
								"Como funciona AOP?", 
								"Dúvida com Spring Security",
								"JDBCTemplate: como eu uso?", 
								"Configuração XML: problema", 
								"Projeto de exemplo", 
								"Hibernate: como definir o SessionFactory?", 
								"DataSource: como obter via JNDI?", 
								"Como funciona a requisição no MVC?", 
								"Aonde uso o Spring?"};
	
	
	public List<Topico> getTopicosPorAutor(Usuario usuario) {
		List<Topico> resultado = new ArrayList<Topico>();
		if (usuario != null) {
			int num_registros = (int) (Math.random() * titulos.length);
			List<Assunto> assuntos = getDaoAssunto().list();
			for (int i = 0; i < num_registros; i++) {
				Topico topico = new Topico();
				topico.setTitulo(titulos[i]);
				topico.setAutor(usuario);
				topico.setAssunto(assuntos.get((int) (Math.random() * assuntos.size())));
				resultado.add(topico);
			}
		}
		return resultado;
	}
	
}

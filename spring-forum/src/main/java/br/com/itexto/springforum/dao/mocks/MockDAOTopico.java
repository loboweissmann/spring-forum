package br.com.itexto.springforum.dao.mocks;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.itexto.springforum.dao.DAOTopico;
import br.com.itexto.springforum.entidades.Assunto;
import br.com.itexto.springforum.entidades.Topico;
import br.com.itexto.springforum.entidades.Usuario;

@Component("daoTopico")
public class MockDAOTopico extends MockDAOBase<Topico> implements DAOTopico {
	
	private List<Topico> topicos = new ArrayList<Topico>();
	
	@Autowired
	private MockDAOAssunto daoAssunto;
	
	public MockDAOAssunto getDaoAssunto() {return daoAssunto;}
	public void setDaoAssunto(MockDAOAssunto dao) {daoAssunto = dao;}
	
	private String[] titulos = {"Como eu configuro o Spring?", 
								"Problema com suporte a DAO", 
								"Como funciona AOP?", 
								"D�vida com Spring Security",
								"JDBCTemplate: como eu uso?", 
								"Configura��o XML: problema", 
								"Projeto de exemplo", 
								"Hibernate: como definir o SessionFactory?", 
								"DataSource: como obter via JNDI?", 
								"Como funciona a requisi��o no MVC?", 
								"Aonde uso o Spring?"};
	
	
	public List<Topico> getTopicosPorAutor(Usuario usuario) {
		List<Topico> resultado = new ArrayList<Topico>();
		if (usuario != null) {
			int num_registros = (int) (Math.random() * titulos.length);
			List<Assunto> assuntos = getDaoAssunto().list(-1, -1);
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
	@Override
	public Class getClazz() {
		return Topico.class;
	}
	public List<Topico> getTopicosPorAssunto(Assunto assunto, int offset,
			int max) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

package br.com.itexto.springforum.dao.hibernate;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.com.itexto.springforum.dao.DAOTopico;
import br.com.itexto.springforum.entidades.Assunto;
import br.com.itexto.springforum.entidades.Topico;
import br.com.itexto.springforum.entidades.Usuario;
@Repository
public class HBTopico extends HBDAO<Topico> implements DAOTopico {


	protected Class getClazz() {
		return Topico.class;
	}

	public List<Topico> getTopicosPorAutor(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Topico> getTopicosPorAssunto(Assunto assunto, int offset, int max) {
		Query busca = getSession().createQuery("from Topico topico where topico.assunto = ?");
		busca.setEntity(0, assunto);
		busca.setMaxResults(max);
		busca.setFirstResult(offset);
		return busca.list();
	}

}

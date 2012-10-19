package br.com.itexto.springforum.dao.hibernate;

import org.springframework.stereotype.Repository;

import br.com.itexto.springforum.dao.DAOAssunto;
import br.com.itexto.springforum.entidades.Assunto;

@Repository
public class HBAssunto extends HBDAO<Assunto> implements DAOAssunto {


	protected Class getClazz() {
		return Assunto.class;
	}

}

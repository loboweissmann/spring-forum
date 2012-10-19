package br.com.itexto.springforum.dao.hibernate;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.itexto.springforum.dao.DAOUsuario;
import br.com.itexto.springforum.entidades.Usuario;

@Transactional(propagation=Propagation.SUPPORTS)
@Repository("daoUsuario")
public class HBUsuario extends HBDAO<Usuario> implements DAOUsuario {
	
	

	
	protected Class getClazz() {
		return Usuario.class;
	}

	public Usuario getUsuario(String login, String senha) {
		Query query = getSession().createQuery("from Usuario usr where usr.login = ? and usr.hashSenha = ?");
		query.setString(0, login);
		query.setString(1, DigestUtils.sha256Hex(senha));
		return (Usuario) query.uniqueResult();				   
	}

	public Usuario getUsuario(String login) {
		Query query = getSession().createQuery("from Usuario usr where usr.login = ?");
		query.setString(0, login);
		return (Usuario) query.uniqueResult();
	}

	
	
}

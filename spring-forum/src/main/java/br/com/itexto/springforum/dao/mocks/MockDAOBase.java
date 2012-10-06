package br.com.itexto.springforum.dao.mocks;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class MockDAOBase<T> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {return sessionFactory;}
	public void setSessionFactory(SessionFactory sf) {sessionFactory = sf;}
	
	public Session getSession() {
		return getSessionFactory().getCurrentSession();
	}
	
	public T get(Long id) {
		return (T) getSession().get(getClazz(), id);
	}
	
	public void persistir(T obj) {
		getSession().saveOrUpdate(obj);
	}
	
	public void excluir(T obj) {
		getSession().delete(obj);
	}
	
	public abstract Class getClazz();
	
	public List<T> list(int offset, int max) {
		Criteria criteria = getSession().createCriteria(getClazz());
		criteria.setMaxResults(max);
		criteria.setFirstResult(offset);
		return criteria.list();
	}
	
}

package br.com.itexto.springforum.dao.hibernate;

import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.itexto.springforum.dao.DAOUsuario;

public class TestConfigData  {
	
	private ApplicationContext contextoSpring;
	
	@Before
	public void before() {
		contextoSpring = new ClassPathXmlApplicationContext("spring-data.xml");
	}
	
	@Test
	public void testDaos() throws Exception {
		assertNotNull(contextoSpring);
		DAOUsuario dao = contextoSpring.getBean(DAOUsuario.class);
		assertNotNull(dao);
		assertNotNull(dao.list(0, 1000));
		DataSource ds = contextoSpring.getBean(DataSource.class);
		assertNotNull(ds.getConnection());
	}
}

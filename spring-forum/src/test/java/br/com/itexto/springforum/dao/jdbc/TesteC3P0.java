package br.com.itexto.springforum.dao.jdbc;

import static org.junit.Assert.assertNotSame;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TesteC3P0 {
	
	private ApplicationContext contextoSpring;
	
	@Test
	public void testDataSource() throws Throwable {
		contextoSpring = new ClassPathXmlApplicationContext("spring-c3p0.xml");
		DataSource ds = contextoSpring.getBean(DataSource.class);
		assertNotSame(ds.getConnection(), ds.getConnection());
		try {
			ds.getConnection();
		} catch (SQLException ex) {
			switch (ex.getErrorCode()) {
				case 1022:
					// chave duplicada
				break;
				case 1037:
					// out of memory
				break;
			}
		}
	}

}

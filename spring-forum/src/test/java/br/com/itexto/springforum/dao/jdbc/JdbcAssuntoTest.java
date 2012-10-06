package br.com.itexto.springforum.dao.jdbc;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import br.com.itexto.springforum.entidades.Assunto;

public class JdbcAssuntoTest {

	private JdbcAssunto jdbcAssunto;
	
	@Before
	public void before() {
		jdbcAssunto = new JdbcAssunto();
		
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/spring_forum");
		ds.setUsername("sf");
		ds.setPassword("sf");
		jdbcAssunto.setJdbcTemplate(new JdbcTemplate(ds));
	}
	
	@Test
	public void testPersistir() {
		Assunto assunto = new Assunto();
		assunto.setNome(java.util.UUID.randomUUID().toString());
		jdbcAssunto.persistir(assunto);
		assertTrue(assunto.getId() > 0l);
	}
	
	@Test
	public void testList() {
		assertNotNull(jdbcAssunto.list(0, 1000));
	}

	

	@Test
	public void testExcluir() {
		Assunto teste = new Assunto();
		teste.setNome("Assunto de teste bruto");
		jdbcAssunto.persistir(teste);
		assertNotNull(jdbcAssunto.get(teste.getId()));
		jdbcAssunto.excluir(teste);
		assertNull(jdbcAssunto.get(teste.getId()));
	}

	@Test
	public void testGet() {
		Assunto teste = new Assunto();
		teste.setNome("Assunto de teste bruto");
		jdbcAssunto.persistir(teste);
		assertNotNull(jdbcAssunto.get(teste.getId()));
	}

}

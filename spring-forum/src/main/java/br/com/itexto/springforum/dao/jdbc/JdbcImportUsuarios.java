package br.com.itexto.springforum.dao.jdbc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import br.com.itexto.springforum.entidades.Usuario;

public class JdbcImportUsuarios {
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		
		return jdbcTemplate;
	}
	
	@Autowired
	public void setDataSource(DataSource ds) {
		jdbcTemplate = new JdbcTemplate(ds);
	}
	
	public List<Usuario> obterUsuarios(File arquivo) {
		List<Usuario> resultado = new ArrayList<Usuario>();
		if (arquivo.exists()) {
			InputStream input = null;
			try {
				input = new FileInputStream(arquivo);
				BufferedReader reader = new BufferedReader(new InputStreamReader(input));
				String linha = null;
				while ((linha = reader.readLine()) != null) {
					String[] componentes = linha.split(",");
					Usuario usuario = new Usuario(); 
					usuario.setNome(componentes[0]);
					usuario.setLogin(componentes[1]);
					usuario.setSenha(componentes[2]);
					resultado.add(usuario);
				}
			} catch (IOException ex) {
				
			}
		}
		return resultado;
	}
	
	public void importarUsuarios(File arquivo) {
		final List<Usuario> usuarios = obterUsuarios(arquivo);
		jdbcTemplate.batchUpdate("insert into usuario (nome, login, senha) values (?,?,?)", 
				new BatchPreparedStatementSetter() {

					public void setValues(PreparedStatement ps, int i)
							throws SQLException {
						Usuario usr = usuarios.get(i);
						ps.setString(1, usr.getNome());
						ps.setString(2, usr.getLogin());
						ps.setString(3, usr.getSenha());
					}

					public int getBatchSize() {
						return usuarios.size();
					}
			
		}
				);
	}
	
	
}

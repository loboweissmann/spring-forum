package br.com.itexto.springforum.dao.jdbc;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import br.com.itexto.springforum.dao.DAOBase;

public abstract class JdbcBase<T> extends JdbcDaoSupport implements DAOBase<T> {


}

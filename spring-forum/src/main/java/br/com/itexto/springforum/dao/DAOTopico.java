package br.com.itexto.springforum.dao;

import java.util.List;

import br.com.itexto.springforum.entidades.Assunto;
import br.com.itexto.springforum.entidades.Topico;
import br.com.itexto.springforum.entidades.Usuario;

public interface DAOTopico extends DAOBase<Topico> {
	
	public List<Topico> getTopicosPorAutor(Usuario usuario);
	
	public List<Topico> getTopicosPorAssunto(Assunto assunto, int offset, int max);

}

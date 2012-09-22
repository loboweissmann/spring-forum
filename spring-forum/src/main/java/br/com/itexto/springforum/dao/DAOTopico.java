package br.com.itexto.springforum.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.itexto.springforum.entidades.Topico;

@Component("daoTopico")
public class DAOTopico {
	
	private List<Topico> topicos = new ArrayList<Topico>();
	
}

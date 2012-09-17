package br.com.itexto.springbrasil.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.itexto.springbrasil.entidades.Topico;

@Component("daoTopico")
public class DAOTopico {
	
	private List<Topico> topicos = new ArrayList<Topico>();
	
}

package br.com.itexto.springforum.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.itexto.springforum.dao.DAOAssunto;
import br.com.itexto.springforum.dao.DAOTopico;
import br.com.itexto.springforum.entidades.Assunto;

@Controller
public class AssuntoController {
	@Autowired
	private DAOAssunto daoAssunto;
	
	@Autowired
	private DAOTopico daoTopico;
	
	@RequestMapping("/assunto/{id}")
	public ModelAndView show(Long id) {
		ModelAndView resultado = new ModelAndView();
		
		resultado.addObject("assunto", daoAssunto.get(id));
		resultado.addObject("topicos", daoTopico.getTopicosPorAssunto((Assunto)resultado.getModel().get("assunto"), 0, 20));
		resultado.setViewName("assunto/show");
		
		return resultado;
	}
	
}

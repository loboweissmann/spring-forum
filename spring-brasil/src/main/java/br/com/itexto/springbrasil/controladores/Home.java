package br.com.itexto.springbrasil.controladores;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.itexto.springbrasil.dao.DAOAssunto;
import br.com.itexto.springbrasil.dao.DAOTopico;
import br.com.itexto.springbrasil.dao.DAOUsuario;

@Controller
public class Home {
	
	
	@Autowired
	private DAOUsuario daoUsuario;
	@Autowired
	private DAOTopico daoTopico;
	@Autowired
	private DAOAssunto daoAssunto;
	
	public DAOUsuario getDaoUsuario() {
		return daoUsuario;
	}

	public void setDaoUsuario(DAOUsuario daoUsuario) {
		this.daoUsuario = daoUsuario;
	}

	public DAOTopico getDaoTopico() {
		return daoTopico;
	}

	public void setDaoTopico(DAOTopico daoTopico) {
		this.daoTopico = daoTopico;
	}

	public DAOAssunto getDaoAssunto() {
		return daoAssunto;
	}

	public void setDaoAssunto(DAOAssunto daoAssunto) {
		this.daoAssunto = daoAssunto;
	}
	
	/**
	 * A anotação @RequestMapping identifica qual a URL relacionada ao método (action)
	 * a ser executado.
	 * 
	 * Neste exemplo, vemos que a URL padrão para nosso sistema, o "/" sempre apontará para 
	 * esta chamada.
	 * @param model
	 * @return
	 */
	@RequestMapping("/")
	public String index(Map<String, Object> model) {
		model.put("assuntos", getDaoAssunto().list());
		model.put("usuarios", getDaoUsuario().list());
		return "index";
	}
	
}

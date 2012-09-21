package br.com.itexto.springbrasil.controladores;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.itexto.springbrasil.dao.DAOAssunto;
import br.com.itexto.springbrasil.dao.DAOTopico;
import br.com.itexto.springbrasil.dao.DAOUsuario;
import br.com.itexto.springbrasil.entidades.Usuario;

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
	
	@RequestMapping("/signup")
	public String signup(Map<String, Object> model) {
		model.put("usuario", new Usuario());
		return "signup";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(Usuario usuario, BindingResult bindingResult) {
		
		System.out.println("usuario.login: " + usuario.getLogin());
		for (ObjectError erro : bindingResult.getAllErrors()) {
			System.out.println("Erro: " + erro.toString());
		}
		
		return "redirect:/";
	}
	
}

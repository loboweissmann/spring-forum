package br.com.itexto.springforum.controladores;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.itexto.springforum.dao.DAOAssunto;
import br.com.itexto.springforum.dao.DAOTopico;
import br.com.itexto.springforum.dao.DAOUsuario;
import br.com.itexto.springforum.entidades.Usuario;

@Controller
public class ControllerHome {
	
	
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
		model.put("usuarios", getDaoUsuario().list(0,100));
		return "index";
	}
	
	@RequestMapping("/signup")
	public String signup(Map<String, Object> model) {
		if (model.get("usuario") == null) {
			model.put("usuario", new Usuario());
		}
		return "signup";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(@Valid Usuario usuario, BindingResult bindingResult, HttpSession sessao) {
		
		if (bindingResult.hasErrors()) {
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("usuario", usuario);
			return signup(model);
		}
		getDaoUsuario().persistir(usuario);
		sessao.setAttribute("usuario", usuario);
		return "redirect:/";
	}
	
}

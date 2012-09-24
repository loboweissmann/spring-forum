package br.com.itexto.springforum.controladores;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.itexto.springforum.dao.DAOUsuario;
import br.com.itexto.springforum.entidades.Usuario;

@Controller
public class ControllerUsuario {
	
	@Autowired
	private DAOUsuario daoUsuario;
	public DAOUsuario getDaoUsuario() {return daoUsuario;}
	public void setDaoUsuario(DAOUsuario dao) {daoUsuario = dao;}
	
	@RequestMapping("/usuario/show")
	public String usuario(Long id, Map<String, Object> model) {
		Usuario usuario = getDaoUsuario().get(id);
		model.put("usuario", usuario);
		return "usuario/show";
	}
	
}

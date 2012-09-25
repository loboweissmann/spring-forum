package br.com.itexto.springforum.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.itexto.springforum.dao.DAOUsuario;
import br.com.itexto.springforum.entidades.Usuario;

@Controller("usuario")
public class ControllerUsuario {
	
	@Autowired
	private DAOUsuario daoUsuario;
	public DAOUsuario getDaoUsuario() {return daoUsuario;}
	public void setDaoUsuario(DAOUsuario dao) {daoUsuario = dao;}
	
	/**
	 * Exemplo de como lidar com requisições que possuam variáveis embutidas.
	 * @param id
	 * @return
	 */
	@RequestMapping("/usuario/show/{id}")
	public ModelAndView usuario(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView();
		Usuario usuario = getDaoUsuario().get(id);
		mav.getModel().put("usuario", usuario);
		mav.setViewName("usuario/show");
		return mav;
	}
	
}

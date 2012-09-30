package br.com.itexto.springforum.controladores;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import br.com.itexto.springforum.dao.DAOUsuario;
import br.com.itexto.springforum.entidades.Usuario;

@Controller("usuario")
@SessionAttributes("usuario")
public class UsuarioController {
	
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
	
	@RequestMapping("/usuario/autenticado")
	public ModelAndView infoAutenticado(@ModelAttribute("usuario") Usuario usuario) {
		ModelAndView mav = new ModelAndView("usuario/show");
		mav.getModel().put("usuario", usuario);
		return mav;
	}
	
	@RequestMapping("/usuario/avatar/{login}")
	@ResponseBody
	public byte[] avatar(@PathVariable("login") String login) throws IOException {
		File arquivo = new File("/springForum/avatares/" + login + ".png");
		
		if (! arquivo.exists()) {
			arquivo = new File("/springForum/avatares/avatar.png");
		}
		
		byte[] resultado = new byte[(int)arquivo.length()];
		FileInputStream input = new FileInputStream(arquivo);
		input.read(resultado);
		input.close();
		
		return resultado;
	}
	
}

package br.com.itexto.springforum.controladores;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.com.itexto.springforum.dao.DAOAssunto;
import br.com.itexto.springforum.dao.DAOPermissaoUsuario;
import br.com.itexto.springforum.dao.DAOTopico;
import br.com.itexto.springforum.dao.DAOUsuario;
import br.com.itexto.springforum.dao.mocks.MockDAOAssunto;
import br.com.itexto.springforum.entidades.Assunto;
import br.com.itexto.springforum.entidades.Usuario;

@Controller
public class HomeController {
	
	
	@Autowired
	private DAOUsuario daoUsuario;
	@Autowired
	private DAOTopico daoTopico;
	@Autowired
	private DAOAssunto daoAssunto;
	@Autowired
	private DAOPermissaoUsuario daoPermissaoUsuario;
	
	public DAOPermissaoUsuario getDaoPermissaoUsuario() {
		return daoPermissaoUsuario;
	}
	
	public void setDaoPermissaoUsuario(DAOPermissaoUsuario dao) {
		daoPermissaoUsuario = dao;
	}
	
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

	public void setDaoAssunto(MockDAOAssunto daoAssunto) {
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
		model.put("assuntos", getDaoAssunto().list(0,100));
		model.put("usuarios", getDaoUsuario().list(0,100));
		return "index";
	}
	
	@RequestMapping("/registro")
	public String registro(Map<String, Object> model) {
		if (model.get("usuario") == null) {
			Usuario usr = new Usuario();
			
			model.put("usuario", usr);
		}
		return "registro";
	}
	
	@RequestMapping(value="/executarRegistro", method=RequestMethod.POST)
	public String executarRegistro(@Valid Usuario usuario, 
									BindingResult bindingResult, 
									HttpSession sessao, 
									@RequestParam(value="avatar", required=false) MultipartFile avatar) {
		if (bindingResult.hasErrors()) {
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("usuario", usuario);
			return registro(model);
		}
		getDaoUsuario().persistir(usuario);
		getDaoPermissaoUsuario().addRole("ROLE_MEMBRO", usuario);
		if (! avatar.isEmpty()) {
			processarAvatar(usuario, avatar);
		}
		
		sessao.setAttribute("usuario", usuario);
		return "redirect:/";
	}
	
	private void processarAvatar(Usuario usuario, MultipartFile avatar) {
		File diretorio = new File("/springForum/avatares");
		if (! diretorio.exists()) {
			diretorio.mkdirs();
		}
			try {
				FileOutputStream arquivo = new FileOutputStream(diretorio.getAbsolutePath() + "/" + usuario.getLogin() + ".png");
				arquivo.write(avatar.getBytes());
				arquivo.close();
			} catch (IOException ex) {
				
			}
		
	}
	
}

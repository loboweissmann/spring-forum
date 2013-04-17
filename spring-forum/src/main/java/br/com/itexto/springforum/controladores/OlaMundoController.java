package br.com.itexto.springforum.controladores;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OlaMundoController {
	
	@RequestMapping("/ola")
	public ModelAndView olaMundo() {
		ModelAndView resultado = new ModelAndView("mundo");
		resultado.addObject("data", new Date());
		return resultado;
	}
	
}

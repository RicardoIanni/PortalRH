package br.com.ricardoianni.infrastructure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ricardoianni.domain.usuario.Usuario;
import br.com.ricardoianni.util.SecurityUtils;

@Controller
@RequestMapping(path = "/")
public class UsuarioController {
	private Usuario user;			 
	
	@GetMapping(path = "master/home")
	public String masterUserLogged(Model model) {
		user = SecurityUtils.getUsuario();
		
		model.addAttribute("master", user.isMaster());
		model.addAttribute("administrator", user.isAdminstrator());
		
		return "index";
	}

	@GetMapping(path = "admin/home")
	public String administratorUserLogged(Model model) {
		user = SecurityUtils.getUsuario();
		
		model.addAttribute("master", user.isMaster());
		model.addAttribute("administrator", user.isAdminstrator());
		
		return "index";
	}

	@GetMapping(path = "holerite/home")
	public String employeeUserLogged(Model model) {
		user = SecurityUtils.getUsuario();
		
		model.addAttribute("master", user.isMaster());
		model.addAttribute("administrator", user.isAdminstrator());
		
		return "index";
	}
}

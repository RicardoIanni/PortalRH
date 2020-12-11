package br.com.ricardoianni.infrastructure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/admin")
public class AdministradorController {
	
	@GetMapping(path = "/home")
	public String administratorUserLogged(Model model) {

		return "index-administrador";
	}

}

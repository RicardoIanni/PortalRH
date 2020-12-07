package br.com.ricardoianni.infrastructure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/colab")
public class ColaboradorController {
	
	@GetMapping(path = "/home")
	public String employeeUserLogged(Model model) {
		
		model.addAttribute("master", false);
		model.addAttribute("administrator", false);
		
		return "index";
	}
}

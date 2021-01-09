package br.com.ricardoianni.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ricardoianni.domain.customer.Cliente;
import br.com.ricardoianni.domain.customer.ClienteRepository;

@Controller
@RequestMapping(path = "/master")
public class MasterUserController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping(path = "/home")
	public String masterUserLogged(Model model) {

		ControllerHelper.setLoggedUser(model);
		
		List<Cliente> clientes = clienteRepository.findAll();
		
		model.addAttribute("msgError", "");
		model.addAttribute("clientes", clientes);
		
		if (clientes.size() == 0) {
			model.addAttribute("cliente", new Cliente());
			return "cli_add";
		}
		
		return "cliente";
	}

}

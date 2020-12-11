package br.com.ricardoianni.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.ricardoianni.application.service.ClienteService;
import br.com.ricardoianni.domain.company.Empresa;
import br.com.ricardoianni.domain.company.EmpresaRepository;
import br.com.ricardoianni.domain.customer.Cliente;
import br.com.ricardoianni.domain.customer.ClienteRepository;
import br.com.ricardoianni.webservice.client.WebServiceClient;
import br.com.ricardoianni.webservice.client.WebServiceClientException;

@Controller
@RequestMapping(path = {"master/cliente", "/admin/cliente"})
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private ClienteService clienteService;

	@PostMapping(path = "/save")
	public String clienteIncluir(@ModelAttribute("cliente") Cliente cliente, Model model) {
		
		WebServiceClient webService = new WebServiceClient();
		
		//TODO: conectar conforme empresa do colaborador ativo ou escolhido
		webService.setCostumerID(cliente.getCustomerID());
		webService.setUsername(cliente.getUsername());
		webService.setPassword(cliente.getPassword());
		
		try {
			webService.webServiceStart(cliente.getEndpoint());
			
			clienteService.clienteSave(cliente);

			model.addAttribute("msgError", "");
			model.addAttribute("cliente", new Cliente());
			
		} catch (WebServiceClientException e) {
		
			model.addAttribute("msgError", e.getMessage());
			model.addAttribute("cliente", cliente);
			
		}
		
		List<Cliente> clientes = clienteRepository.findAll();
		model.addAttribute("clientes", clientes);
		
		return "redirect:../home";
	}
	
	@GetMapping(path = "/details")
	public String clienteDetalhes(@RequestParam(name = "idcliente") Integer idCliente, Model model) {
		Cliente cliente = clienteRepository.findByIdCliente(idCliente);
		List<Empresa> empresas = empresaRepository.findByClienteEmpresa(cliente);
		
		model.addAttribute("cliente", cliente);
		model.addAttribute("empresas", empresas);
		
		return "cli_details";
	}
}

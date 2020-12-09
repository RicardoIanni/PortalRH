package br.com.ricardoianni.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.ricardoianni.application.service.EmpresaService;
import br.com.ricardoianni.domain.customer.Cliente;
import br.com.ricardoianni.domain.customer.ClienteRepository;
import br.com.ricardoianni.webservice.client.WebServiceClientException;

@Controller
@RequestMapping(path = {"/master/empresa", "/admin/empresa"})
public class EmpresaController {
	
	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private ClienteController clienteController;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@PostMapping(path = "/importar")
	public String empresaImportar(@RequestParam("idcliente") Integer idCliente, Model model) {
		Cliente cliente = clienteRepository.findByIdCliente(idCliente);

		try {
			empresaService.empresaImportar(cliente);
		} catch (WebServiceClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return clienteController.clienteDetalhes(idCliente, model);
	}

}

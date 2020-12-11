package br.com.ricardoianni.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.ricardoianni.application.service.EmpresaService;
import br.com.ricardoianni.domain.company.Empresa;
import br.com.ricardoianni.domain.company.EmpresaRepository;
import br.com.ricardoianni.domain.customer.Cliente;
import br.com.ricardoianni.domain.customer.ClienteRepository;
import br.com.ricardoianni.domain.employee.Colaborador;
import br.com.ricardoianni.domain.employee.ColaboradorRepository;
import br.com.ricardoianni.webservice.client.WebServiceClientException;

@Controller
@RequestMapping(path = {"/master/cliente/empresa", "/admin/cliente/empresa"})
public class EmpresaController {
	
	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	@PostMapping(path = "/importar")
	public String empresaImportar(@RequestParam("idcliente") Integer idCliente, Model model) {
		Cliente cliente = clienteRepository.findByIdCliente(idCliente);

		try {
			empresaService.empresaImportar(cliente);
		} catch (WebServiceClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:../details?idcliente=" + idCliente;
	}
	
	@GetMapping(path = "/")
	public String empresaDetails(@RequestParam("idempresa") Integer idEmpresa, Model model) {
		Empresa empresa = empresaRepository.findByIdEmpresa(idEmpresa);
		List<Colaborador> colaboradores = colaboradorRepository.findByEmpresasColaborador_IdEmpresa(empresa.getIdEmpresa());
		
		model.addAttribute("empresa", empresa);
		model.addAttribute("colaboradores", colaboradores);
		
		return "empresa";
	}

}

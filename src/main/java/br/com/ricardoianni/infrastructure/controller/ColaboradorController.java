package br.com.ricardoianni.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.ricardoianni.application.service.ColaboradorService;
import br.com.ricardoianni.domain.company.Empresa;
import br.com.ricardoianni.domain.company.EmpresaRepository;
import br.com.ricardoianni.webservice.client.WebServiceClientException;

@Controller
@RequestMapping(path = {"/master/cliente/empresa/colab", "/admin/empresa/colab", "/colab" })
public class ColaboradorController {
	
	@Autowired
	private ColaboradorService colaboradorService;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@GetMapping(path = "/home")
	public String employeeUserLogged(Model model) {
		
		return "index-colaborador";
	}
	
	@PostMapping(path = "/importar")
	public String colaboradorImportar(@RequestParam("idempresa") Integer idEmpresa, Model model) {
		Empresa empresa = empresaRepository.findByIdEmpresa(idEmpresa);
		
		try {
			colaboradorService.colaboradorImportar(empresa);
		} catch (WebServiceClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:../../empresa/?idempresa=" + idEmpresa;
	}
}

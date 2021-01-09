package br.com.ricardoianni.infrastructure.controller;

import java.util.ArrayList;
import java.util.List;

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
import br.com.ricardoianni.domain.employee.Colaborador;
import br.com.ricardoianni.domain.employee.Competencia;
import br.com.ricardoianni.domain.holerite.TipoRecibo;import br.com.ricardoianni.domain.user.Usuario;
import br.com.ricardoianni.util.CollectionUtils;
import br.com.ricardoianni.webservice.client.WebServiceClientException;

@Controller
@RequestMapping(path = {"/master/cliente/empresa/colab", "/admin/empresa/colab", "/colab" })
public class ColaboradorController {
	
	@Autowired
	private ColaboradorService colaboradorService;
	
	@Autowired
	private EmpresaRepository empresaRepository;

	@GetMapping(path = {"/", "/home"})
	public String employeeUserLogged(@RequestParam(name = "idcolaborador", required = false) Integer idColaborador, Model model) {
		Usuario usuario = ControllerHelper.setLoggedUser(model);
		
		Colaborador colaborador;
		
		if (idColaborador != null) {
			colaborador = colaboradorService.colaboradorSearchID(idColaborador);			
		} else {
			colaborador = (Colaborador) usuario;
		}
		
		// TODO: Ajustar para colaboradores com mais de uma empresa
		List<Competencia> competencias = new ArrayList<>();
		
		try {
			competencias = colaboradorService.competenciaList(colaborador);
		} catch (WebServiceClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Empresa empresa = empresaRepository.findByIdEmpresa(colaborador.getEmpresasColaborador().get(0).getIdEmpresa());
		
		List<TipoRecibo> tiposRecibo = CollectionUtils.listOf(TipoRecibo.values());
		
		model.addAttribute("colaborador", colaborador);
		model.addAttribute("competencias", competencias);
		model.addAttribute("empresa", empresa);
		model.addAttribute("tiposRecibo", tiposRecibo);
		model.addAttribute("usuario", model.getAttribute("usuario"));
		
		return "colaborador";
	}
	
	@PostMapping(path = "/importar")
	public String colaboradorImportar(@RequestParam("idempresa") Integer idEmpresa, Model model) {
		Empresa empresa = empresaRepository.findByIdEmpresa(idEmpresa);
		
		try {
			colaboradorService.colaboradorImportar(empresa);
			model.addAttribute("msg-erro", "");
		} catch (WebServiceClientException e) {
			model.addAttribute("msg-erro", e.getMessage());
		}
		
		return "redirect:../../empresa/?idempresa=" + idEmpresa;
	}
}

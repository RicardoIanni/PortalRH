package br.com.ricardoianni.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.ricardoianni.application.service.ColaboradorService;
import br.com.ricardoianni.domain.administrator.Administrador;
import br.com.ricardoianni.domain.company.Empresa;
import br.com.ricardoianni.domain.company.EmpresaRepository;
import br.com.ricardoianni.domain.employee.Colaborador;
import br.com.ricardoianni.domain.employee.Competencia;
import br.com.ricardoianni.domain.employee.CompetenciaRepository;
import br.com.ricardoianni.domain.masteruser.MasterUser;
import br.com.ricardoianni.domain.user.Usuario;
import br.com.ricardoianni.util.SecurityUtils;
import br.com.ricardoianni.webservice.client.WebServiceClientException;

@Controller
@RequestMapping(path = {"/master/cliente/empresa/colab", "/admin/empresa/colab", "/colab" })
public class ColaboradorController {
	
	@Autowired
	private ColaboradorService colaboradorService;
	
	@Autowired
	private CompetenciaRepository competenciaRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;

	@GetMapping(path = {"/", "/home"})
	public String employeeUserLogged(@RequestParam(name = "idcolaborador", required = false) Integer idColaborador, Model model) {
		Usuario usuario = SecurityUtils.getUsuario();

		if (usuario instanceof MasterUser) {
			model.addAttribute("usuario", "master");
		} else if (usuario instanceof Administrador) {
			model.addAttribute("usuario", "administrador");
		} else if (usuario instanceof Colaborador) {
			model.addAttribute("usuario", "colaborador");
		}
		
		Colaborador colaborador;
		
		if (idColaborador != null) {
			colaborador = colaboradorService.colaboradorSearchID(idColaborador);			
		} else {
			colaborador = (Colaborador) usuario;
		}
		
		List<Competencia> competencias = competenciaRepository.findByColaboradorCompetenciaOrderByAnoDescMesDesc(colaborador);
		Empresa empresa = empresaRepository.findByIdEmpresa(colaborador.getEmpresasColaborador().get(0).getIdEmpresa());
		
		model.addAttribute("colaborador", colaborador);
		model.addAttribute("competencias", competencias);
		model.addAttribute("empresa", empresa);
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

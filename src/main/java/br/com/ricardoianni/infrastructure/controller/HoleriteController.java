package br.com.ricardoianni.infrastructure.controller;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.w3c.dom.Document;

import br.com.ricardoianni.application.pdf.PDFDocument;
import br.com.ricardoianni.application.service.ColaboradorService;
import br.com.ricardoianni.application.service.EmpresaService;
import br.com.ricardoianni.application.service.HoleriteService;
import br.com.ricardoianni.domain.company.Empresa;
import br.com.ricardoianni.domain.employee.Colaborador;
import br.com.ricardoianni.domain.employee.Competencia;
import br.com.ricardoianni.domain.holerite.Holerite;
import br.com.ricardoianni.domain.holerite.HoleriteException;
import br.com.ricardoianni.domain.holerite.TipoRecibo;
import br.com.ricardoianni.webservice.client.WebServiceClientException;

@Controller
@RequestMapping(path = { "/master/cliente/empresa/colab/holerite", "/admin/empresa/colab/holerite", "/colab/holerite" } )
public class HoleriteController {
	
	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private ColaboradorService colaboradorService;

	@Autowired
	private HoleriteService holeriteService;
	
	@PostMapping(path = "/visualizar")
	public String holeriteView(	@RequestParam(name = "idColaborador") Integer idColaborador,
								@RequestParam(name = "idEmpresa") Integer idEmpresa,
								@RequestParam(name = "idCompetencia") Integer idCompetencia,
								@RequestParam(name = "tipoRecibo") TipoRecibo tipoRecibo,
								Model model)  throws HoleriteException {
		Colaborador colaborador = colaboradorService.colaboradorSearchID(idColaborador);
		Empresa empresa = empresaService.empresaSearchID(idEmpresa);
		Competencia competencia = colaboradorService.competenciaSearchID(idCompetencia);
		
		Holerite holerite = holeriteLoad(colaborador, empresa, competencia, tipoRecibo);
		
		model.addAttribute("holerite", holerite);

		return "preview";
	}
	
	
	@PostMapping(path = "/emitir", produces = "application/pdf")
	public ResponseEntity<InputStreamResource> holeritePrint(	@RequestParam(name = "idColaborador") Integer idColaborador,
																@RequestParam(name = "idEmpresa") Integer idEmpresa,
																@RequestParam(name = "idCompetencia") Integer idCompetencia,
																@RequestParam(name = "tipoRecibo") TipoRecibo tipoRecibo,
																Model model)  throws HoleriteException {
		Colaborador colaborador = colaboradorService.colaboradorSearchID(idColaborador);
		Empresa empresa = empresaService.empresaSearchID(idEmpresa);
		Competencia competencia = colaboradorService.competenciaSearchID(idCompetencia);
		
		Holerite holerite = holeriteLoad(colaborador, empresa, competencia, tipoRecibo);
		
		return holeritePDF(holerite);
	}
	
	public Holerite holeriteLoad(	Colaborador colaborador, 
									Empresa empresa, 
									Competencia competencia,
									TipoRecibo tipoRecibo) throws HoleriteException {
		String mes = competencia.getMes();
		String ano = competencia.getAno();
		
		Holerite holerite = holeriteService.holeriteSearch(colaborador, empresa, mes, ano, tipoRecibo);
		
		if (holerite == null) {
			Document xmlDoc = null;
			
			try {
				xmlDoc = holeriteService.holeriteCarregar(colaborador, empresa, mes, ano, tipoRecibo);
			} catch (WebServiceClientException e) {
				// TODO: Retorno com mensagem de erro ao conectar no WebService
				e.printStackTrace();
			}
			
			if (xmlDoc == null) {
				throw new HoleriteException("Erro ao carregar o Holerite do WebService");
			} else {
				holerite = holeriteService.holeriteCriar(xmlDoc);
				holerite.setColaboradorHolerite(colaborador);
				holerite.setEmpresaHolerite(empresa);
				holerite.setMes(mes);
				holerite.setAno(ano);
				holerite.setTipoRecibo(tipoRecibo);
				holeriteService.holeriteGravar(holerite);
			}
		}
		
		return holerite;
	}

	public ResponseEntity<InputStreamResource> holeritePDF(Holerite holerite) {
		
		String filename = holerite.getColaboradorHolerite().getIdFunc() + holerite.getAno() + holerite.getMes() + ".pdf";
		
		PDFDocument pdf = new PDFDocument();
		ByteArrayInputStream byteInputStreamPDF = pdf.createHoleritePDF(holerite);
		
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=" + filename);
        
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(byteInputStreamPDF));
        
	}
}
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
import br.com.ricardoianni.application.service.HoleriteService;
import br.com.ricardoianni.domain.employee.Colaborador;
import br.com.ricardoianni.domain.employee.ColaboradorRepository;
import br.com.ricardoianni.domain.holerite.Holerite;
import br.com.ricardoianni.domain.holerite.HoleriteException;
import br.com.ricardoianni.webservice.client.WebServiceClientException;

@Controller
@RequestMapping(path = { "/master/holerite", "/admin/holerite", "/colab/holerite" } )
public class HoleriteController {
	
	// TODO: Repositório do Colaborador não  deve ser necessário, já deve ser recebido o idColaborador
	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	@Autowired
	private HoleriteService holeriteService;
	
	@PostMapping(path = "/visualizar")
	public String holeriteView(	@RequestParam(name = "idFunc") String idFunc,
								@RequestParam(name = "mes") String mes,
								@RequestParam(name = "ano") String ano, 
								Model model) throws HoleriteException {
		//TODO: Esta pesquisa não deve ser necessária
		Colaborador colaborador = colaboradorRepository.findByIdFunc(idFunc);
		
		Holerite holerite = holeriteService.holeriteSearch(colaborador, mes, ano);
		
		if (holerite == null) {
			Document xmlDoc = null;
			
			try {
				xmlDoc = holeriteService.holeriteCarregar(idFunc, mes, ano);
			} catch (WebServiceClientException e) {
				// TODO: Retorno com mensagem de erro ao conectar no WebService
				e.printStackTrace();
			}
			
			if (xmlDoc == null) {
				throw new HoleriteException("Erro ao carregar o Holerite do WebService");
			} else {
				holerite = holeriteService.holeriteCriar(xmlDoc);
				holerite.setMes(mes);
				holerite.setAno(ano);
				holeriteService.holeriteGravar(holerite);
			}
			
		}
		
		model.addAttribute("holerite", holerite);
		
		return "preview";
	}
	
	@PostMapping(path = "/pdf", produces = "application/pdf")
	public ResponseEntity<InputStreamResource> holeritePDF(	@RequestParam(name = "idFunc") String idFunc,
															@RequestParam(name = "mes") String mes,
															@RequestParam(name = "ano") String ano) {
		// TODO: Esta pesquisa não deve ser necessária
		Colaborador colaborador = colaboradorRepository.findByIdFunc(idFunc);
		
		Holerite holerite = holeriteService.holeriteSearch(colaborador, mes, ano);
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

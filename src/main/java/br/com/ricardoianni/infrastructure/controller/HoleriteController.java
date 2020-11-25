package br.com.ricardoianni.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.w3c.dom.Document;

import br.com.ricardoianni.application.service.HoleriteException;
import br.com.ricardoianni.application.service.HoleriteService;
import br.com.ricardoianni.domain.holerite.Holerite;

@Controller
@RequestMapping(path = "/master/holerite/")
public class HoleriteController {
	
	@Autowired
	private HoleriteService holeriteService;
	
	@PostMapping(path = "visualizar")
	public String holeriteView(	@RequestParam(name = "idFunc") String idFunc,
								@RequestParam(name = "mes") String mes,
								@RequestParam(name = "ano") String ano, 
								Model model) throws HoleriteException {
		Holerite holerite = holeriteService.holeriteSearch(idFunc, mes, ano);
		
		if (holerite == null) {
			Document xmlDoc = holeriteService.holeriteCarregar(idFunc, mes, ano);
			
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
	
}

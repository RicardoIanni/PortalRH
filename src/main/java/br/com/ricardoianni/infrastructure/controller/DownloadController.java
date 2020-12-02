package br.com.ricardoianni.infrastructure.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.ricardoianni.application.pdf.PDFDocument;
import br.com.ricardoianni.application.service.HoleriteService;
import br.com.ricardoianni.domain.holerite.Holerite;
import ch.qos.logback.core.util.Loader;

@Controller
@RequestMapping(path = "/pdf/")
public class DownloadController {
	
	@Autowired
	private HoleriteService holeriteService;

	@PostMapping(path = "download", produces = "application/pdf")
	public void holeritePDF(@RequestParam(name = "idFunc") String idFunc,
							@RequestParam(name = "mes") String mes,
							@RequestParam(name = "ano") String ano,
							HttpServletResponse response) throws IOException {
		Holerite holerite = holeriteService.holeriteSearch(idFunc, mes, ano);
		String filename = holerite.getIdFunc() + holerite.getAno() + holerite.getMes() + ".pdf";
		
		PDFDocument pdf = new PDFDocument();
		pdf.createHoleritePDF(holerite, filename);
		
		String filePath = "/mnt/sdb5/home/ricardo/Documents/Workspace/PortalRH/portal/src/main/resources/static/";
		File file = new File(filePath + filename);
		System.out.println(file.getCanonicalPath());
	
		FileInputStream fileInputStream = new FileInputStream(file);
		
		DefaultResourceLoader loader = new DefaultResourceLoader();
	    InputStream is = loader.getResource("classpath:" + file.getPath()).getInputStream();
	    IOUtils.copy(is, response.getOutputStream());
	    response.setHeader("Content-Disposition", "attachment; filename=" + filename);
	    response.flushBuffer();
		
	}
	
}

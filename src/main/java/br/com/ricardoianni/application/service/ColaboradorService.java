package br.com.ricardoianni.application.service;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import br.com.ricardoianni.domain.company.Empresa;
import br.com.ricardoianni.domain.customer.Cliente;
import br.com.ricardoianni.domain.employee.Colaborador;
import br.com.ricardoianni.domain.employee.ColaboradorRepository;
import br.com.ricardoianni.domain.employee.Competencia;
import br.com.ricardoianni.domain.employee.CompetenciaRepository;
import br.com.ricardoianni.domain.employee.Recibo;
import br.com.ricardoianni.domain.employee.ReciboRepository;
import br.com.ricardoianni.domain.holerite.TipoRecibo;
import br.com.ricardoianni.util.CollectionUtils;
import br.com.ricardoianni.util.StringUtils;
import br.com.ricardoianni.util.XMLUtils;
import br.com.ricardoianni.webservice.client.WebServiceClient;
import br.com.ricardoianni.webservice.client.WebServiceClientException;

@Service
public class ColaboradorService {

	@Autowired
	private ColaboradorRepository colaboradorRepository;

	@Autowired
	private CompetenciaRepository competenciaRepository;

	@Autowired
	private ReciboRepository reciboRepository;
	
	@Transactional
	public void colaboradorImportar(Empresa empresa) throws WebServiceClientException  {
		Cliente cliente = empresa.getClienteEmpresa();
		
		WebServiceClient webService = new WebServiceClient();
		
		webService.setCostumerID(cliente.getCustomerID());
		webService.setUsername(cliente.getUsername());
		webService.setPassword(cliente.getPassword());
		
		webService.webServiceStart(cliente.getEndpoint());
		
		Document xmlDoc = webService.webServiceColaboradores(empresa.getCodigo());
		
		NodeList nodeList = XMLUtils.getTagChildNodeList(xmlDoc, "colaboradores");

		NodeList nodeChildList;
		
		for (int i = 0; i < nodeList.getLength(); i++) {
			nodeChildList = nodeList.item(i).getChildNodes();
			
			String cpf = XMLUtils.getTagValue(nodeChildList, "cpf");
			
			if (colaboradorSearchCPF(cpf).size() > 0) {
				continue;
			}
		
			String dataNascto = XMLUtils.getTagValue(nodeChildList, "dt_nascto");
					
			String senha = cpf.substring(0, 4);
					
			if (StringUtils.isEmpty(dataNascto)) {
				senha = senha + Year.now().toString();
			} else {
				senha = senha + dataNascto.substring(dataNascto.length() - 4);
			}
			
			Colaborador colaborador = new Colaborador();
			
			colaborador.setUsername(cpf);
			colaborador.setPassword(senha);
			colaborador.encryptPassword();
			
			colaborador.setIdFunc(XMLUtils.getTagValue(nodeChildList, "idfunc"));
			colaborador.setCpf(cpf);
			colaborador.setCtps(XMLUtils.getTagValue(nodeChildList, "ctps"));
			colaborador.setSerieCTPS(XMLUtils.getTagValue(nodeChildList, "serie_ctps"));
			colaborador.setPisPasep(XMLUtils.getTagValue(nodeChildList, "pispasep"));
			colaborador.setNome(XMLUtils.getTagValue(nodeChildList, "nome"));
			colaborador.setDataNascimento(dataNascto);
			
			colaborador.setEmpresasColaborador(CollectionUtils.listOf(empresa));
			
			colaboradorSalvar(colaborador);
			
		}
	}
	
	@Transactional
	public List<Competencia> competenciaImportar(Colaborador colaborador) throws WebServiceClientException {
		
		// TODO: Ajustar para colaboradores com mais de uma empresa
		Cliente cliente = colaborador.getEmpresasColaborador().get(0).getClienteEmpresa();
		
		WebServiceClient webService = new WebServiceClient();
		
		webService.setCostumerID(cliente.getCustomerID());
		webService.setUsername(cliente.getUsername());
		webService.setPassword(cliente.getPassword());
		
		webService.webServiceStart(cliente.getEndpoint());
		
		Document xmlDoc = webService.webServiceCompetencias(colaborador.getIdFunc());
		
		NodeList xmlCompetencias = XMLUtils.getTagChildNodeList(xmlDoc, "competencias");
		  
		Competencia competencia; 
		String mes;
		String ano;
		
		List<Competencia> competencias = new ArrayList<>();
		
		for (int i = 0; i < xmlCompetencias.getLength(); i++) { 
				
			mes = XMLUtils.getAttributeValue(xmlCompetencias.item(i), "mes"); 
			ano = XMLUtils.getAttributeValue(xmlCompetencias.item(i), "ano");
			
			if (!xmlCompetencias.item(i).hasChildNodes()) {
				continue;
			}
			
			NodeList xmlRecibos = xmlCompetencias.item(i).getChildNodes();
			
			competencia = new Competencia();
		  
			competencia.setColaboradorCompetencia(colaborador); 
			competencia.setMes(mes);
			competencia.setAno(ano);
			
			competenciaSalvar(competencia); 

			String tipoRecibo;
			
			List<Recibo> recibos = new ArrayList<>();
			
			for (int j = 0; j < xmlRecibos.getLength(); j++) {
			
				tipoRecibo = XMLUtils.getNodeValue(xmlRecibos.item(j));
				
				Recibo recibo = new Recibo();
				
				recibo.setCompetenciaRecibo(competencia);
				recibo.setTipoRecibo(TipoRecibo.valueOf(tipoRecibo));
				
				reciboSalvar(recibo);
				
				recibos.add(recibo);
			}	
			
			competencia.setRecibos(recibos);
			
			competencias.add(competencia);
		}
		
		return competencias;
		 		
	}
	
	public Colaborador colaboradorSearchID(Integer idColaborador) {
		
		return colaboradorRepository.findByIdColaborador(idColaborador);
	}
	
	public List<Colaborador> colaboradorSearch() {
		return colaboradorRepository.findAll();
	}
	
	public List<Colaborador> colaboradorSearchCPF(String cpf) {
		
		return colaboradorRepository.findByCpf(cpf);
	}
	
	public List<Colaborador> colaboradorSearch(String texto) {
		
		//TODO: Alterar para bucar por texto
		return colaboradorRepository.findAll();
	}
	
	@Transactional
	public void colaboradorSalvar(Colaborador colaborador) {
		colaboradorRepository.save(colaborador);
	}
	
	public Competencia competenciaSearchID(Integer idCompetencia) {
		return competenciaRepository.findByIdCompetencia(idCompetencia);
	}
	
	public List<Competencia> competenciaList(Colaborador colaborador) throws WebServiceClientException {
		List<Competencia> competencias = competenciaRepository.findByColaboradorCompetenciaOrderByAnoDescMesDesc(colaborador);
		
		if (competencias.size() == 0) {
			competencias = competenciaImportar(colaborador);
		}
		
		return competencias;
	}
	
	@Transactional
	public void competenciaSalvar(Competencia competencia) {
		competenciaRepository.save(competencia);
	}
	
	@Transactional
	public void reciboSalvar(Recibo recibo) {
		reciboRepository.save(recibo);
	}
}

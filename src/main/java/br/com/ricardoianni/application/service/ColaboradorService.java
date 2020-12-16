package br.com.ricardoianni.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import br.com.ricardoianni.domain.company.Empresa;
import br.com.ricardoianni.domain.customer.Cliente;
import br.com.ricardoianni.domain.employee.Colaborador;
import br.com.ricardoianni.domain.employee.ColaboradorRepository;
import br.com.ricardoianni.domain.employee.Competencia;
import br.com.ricardoianni.domain.employee.CompetenciaRepository;
import br.com.ricardoianni.util.CollectionUtils;
import br.com.ricardoianni.util.XMLUtils;
import br.com.ricardoianni.webservice.client.WebServiceClient;
import br.com.ricardoianni.webservice.client.WebServiceClientException;

@Service
public class ColaboradorService {

	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	@Autowired
	private CompetenciaRepository competenciaRepository;
	
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
			
			if (colaboradorSearchCPF(XMLUtils.getTagValue(nodeChildList, "cpf")).size() > 0) {
				continue;
			}
		
			Colaborador colaborador = new Colaborador();

			colaborador.setIdFunc(XMLUtils.getTagValue(nodeChildList, "idfunc"));
			colaborador.setCpf(XMLUtils.getTagValue(nodeChildList, "cpf"));
			colaborador.setCtps(XMLUtils.getTagValue(nodeChildList, "ctps"));
			colaborador.setSerieCTPS(XMLUtils.getTagValue(nodeChildList, "serie_ctps"));
			colaborador.setPisPasep(XMLUtils.getTagValue(nodeChildList, "pispasep"));
			colaborador.setNome(XMLUtils.getTagValue(nodeChildList, "nome"));
			
			colaborador.setEmpresasColaborador(CollectionUtils.listOf(empresa));
			
			colaboradorSavar(colaborador);
			
			NodeList competencias = XMLUtils.getTagChildNodeList(nodeChildList, "competencias");
			
			if (competencias != null) {
				Competencia competencia;
				String mes;
				String ano;
				
				for (int j = 0; j < competencias.getLength(); j++) {
					mes = XMLUtils.getAttributeValue(competencias.item(j), "mes");
					ano = XMLUtils.getAttributeValue(competencias.item(j), "ano");
					
					if (competenciaRepository.findByColaboradorCompetenciaAndMesAndAno(colaborador, mes, ano).size() > 0) {
						continue;
					}
					
					competencia = new Competencia();
					
					competencia.setColaboradorCompetencia(colaborador);
					competencia.setMes(mes);
					competencia.setAno(ano);
					
					competenciaSavar(competencia);
				}
			}
					
		}
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
	
	public void colaboradorSavar(Colaborador colaborador) {
		colaboradorRepository.save(colaborador);
	}
	
	public Competencia competenciaSearchID(Integer idCompetencia) {
		return competenciaRepository.findByIdCompetencia(idCompetencia);
	}
	
	public void competenciaSavar(Competencia competencia) {
		competenciaRepository.save(competencia);
	}
}

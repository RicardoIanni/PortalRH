package br.com.ricardoianni.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import br.com.ricardoianni.domain.address.Cidade;
import br.com.ricardoianni.domain.address.Endereco;
import br.com.ricardoianni.domain.address.Estado;
import br.com.ricardoianni.domain.company.Empresa;
import br.com.ricardoianni.domain.company.EmpresaRepository;
import br.com.ricardoianni.domain.customer.Cliente;
import br.com.ricardoianni.util.XMLUtils;
import br.com.ricardoianni.webservice.client.WebServiceClient;
import br.com.ricardoianni.webservice.client.WebServiceClientException;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private EnderecoService enderecoService;
	
	public void empresaImportar(Cliente cliente) throws WebServiceClientException {
		WebServiceClient webService = new WebServiceClient();
		
		webService.setCostumerID(cliente.getCustomerID());
		webService.setUsername(cliente.getUsername());
		webService.setPassword(cliente.getPassword());
		
		webService.webServiceStart(cliente.getEndpoint());
		
		Document xmlDoc = webService.webServiceEmpresas();
		
		NodeList nodeList = XMLUtils.getTagChildNodeList(xmlDoc, "empresas");

		NodeList nodeChildList;
		
		Empresa empresa;
		Endereco endereco;
		Cidade cidade;
		Estado estado;
		
		for (int i = 0; i < nodeList.getLength(); i++) {
			nodeChildList = nodeList.item(i).getChildNodes();
			
			if (empresaSearch(XMLUtils.getTagValue(nodeChildList, "cnpj")).size() > 0) {
				continue;
			}
			
			empresa = new Empresa();
			
			estado = enderecoService.estadoSearch(XMLUtils.getTagValue(nodeChildList, "end_estado")).get(0);
			
			if (estado == null) {
				throw new WebServiceClientException("Endereço da empresa " + XMLUtils.getTagValue(nodeChildList, "razao") + " está com UF inválido.");
			}
			
			cidade = enderecoService.cidadeExactSearch(estado, XMLUtils.getTagValue(nodeChildList, "end_cidade"));
			
			if (cidade == null ) {
				cidade = new Cidade();
				
				cidade.setNomeCidade(XMLUtils.getTagValue(nodeChildList, "end_cidade"));
				cidade.setEstadoCidade(estado);
				
				enderecoService.cidadeSalvar(cidade);
			}
			
			endereco = enderecoService.enderecoExactSearch(	XMLUtils.getTagValue(nodeChildList, "endereco"), 
															XMLUtils.getTagValue(nodeChildList, "end_numero"), 
															XMLUtils.getTagValue(nodeChildList, "end_comple"), 
															XMLUtils.getTagValue(nodeChildList, "end_bairro"), 
															cidade);
			
			if (endereco == null) {
				endereco = new Endereco();
				
				endereco.setLogradouro(XMLUtils.getTagValue(nodeChildList, "endereco"));
				endereco.setLogradouro(XMLUtils.getTagValue(nodeChildList, "end_numero"));
				endereco.setLogradouro(XMLUtils.getTagValue(nodeChildList, "end_comple"));
				endereco.setLogradouro(XMLUtils.getTagValue(nodeChildList, "end_bairro"));
				endereco.setCidadeEndereco(cidade);
				
				enderecoService.enderecoSalvar(endereco);
			}
			
			empresa.setClienteEmpresa(cliente);
			empresa.setCnpj(XMLUtils.getTagValue(nodeChildList, "cnpj"));
			empresa.setRazaoSocial(XMLUtils.getTagValue(nodeChildList, "razao"));
			empresa.setEnderecoEmpresa(endereco);
	
			empresaSalvar(empresa);
			
		}
		
	}
	
	public List<Empresa> empresaSearch() {
		return empresaRepository.findAll();
	}
	
	public List<Empresa> empresaSearch(String texto) {
		List<Empresa> empresas = new ArrayList<>();
		List<Empresa> empresasCNPJ = empresaRepository.findByCnpjContaining(texto);
		List<Empresa> empresasRazao = empresaRepository.findByRazaoSocialContaining(texto);

		if (empresasCNPJ.size() > 0) {
			empresas.addAll(empresasCNPJ);
		}
		
		if (empresasRazao.size() > 0) {
			empresas.addAll(empresasRazao);
		}
		
		return empresas;
	}
	
	public void empresaSalvar(Empresa empresa) {
		empresaRepository.save(empresa);
	}
}

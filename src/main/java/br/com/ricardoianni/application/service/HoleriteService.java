package br.com.ricardoianni.application.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import br.com.ricardoianni.domain.empresa.Empresa;
import br.com.ricardoianni.domain.endereco.Cidade;
import br.com.ricardoianni.domain.endereco.Endereco;
import br.com.ricardoianni.domain.endereco.Estado;
import br.com.ricardoianni.domain.holerite.Holerite;
import br.com.ricardoianni.domain.holerite.HoleriteDesconto;
import br.com.ricardoianni.domain.holerite.HoleriteDescontoRepository;
import br.com.ricardoianni.domain.holerite.HoleriteRepository;
import br.com.ricardoianni.domain.holerite.HoleriteVencimento;
import br.com.ricardoianni.domain.holerite.HoleriteVencimentoRepository;
import br.com.ricardoianni.util.XMLUtils;
import br.com.ricardoianni.webservice.client.WebServiceClient;

@Service
public class HoleriteService {
	
	@Autowired
	private HoleriteRepository holeriteRepository;
	
	@Autowired
	private HoleriteVencimentoRepository holeriteVencimentoRepository;
	
	@Autowired
	private HoleriteDescontoRepository holeriteDescontoRepository;
	
	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private EnderecoService enderecoService;

	public Holerite holeriteSearch(String idFunc, String mes, String ano) {
		
		return holeriteRepository.findByIdFuncAndMesAndAno(idFunc, mes, ano);
	}
	
	public Document holeriteCarregar(String idFunc, String mes, String ano) {
		WebServiceClient webService = new WebServiceClient();
		
		webService.setCostumerID("Desenv_R16");
		webService.setUsername("hsolera");
		webService.setPassword("59030732");
		
		webService.webServiceStart("http://desenv.pdcore.com.br/NewAgeWebServiceSetup/EASWebService.asmx");
		
		return webService.webServiceHolerite(idFunc, mes, ano);
		
	}
	
	public Holerite holeriteCriar(Document xmlDoc) {
		Holerite holerite = new Holerite();

		holerite.setIdFunc(XMLUtils.getTagValue(xmlDoc, "idfunc"));
		holerite.setNome(XMLUtils.getTagValue(xmlDoc, "nome"));
		holerite.setCtps(XMLUtils.getTagValue(xmlDoc, "ctps"));
		holerite.setSerieCTPS(XMLUtils.getTagValue(xmlDoc, "ctps_serie"));
		holerite.setPis_pasep(XMLUtils.getTagValue(xmlDoc, "pispasep"));
		holerite.setCpf(XMLUtils.getTagValue(xmlDoc, "cpf"));
		holerite.setDataAdmissao(XMLUtils.convertContextToDate(xmlDoc, "dt_admissao"));
		holerite.setContrato(XMLUtils.getTagValue(xmlDoc, "contrato"));
		holerite.setFuncao(XMLUtils.getTagValue(xmlDoc, "funcao"));
		holerite.setCbo(XMLUtils.getTagValue(xmlDoc, "cbo"));
		holerite.setDepartamento(XMLUtils.getTagValue(xmlDoc, "departamento"));
		
		holerite.setTotalVencimento(XMLUtils.convertContextToBigDecimal(xmlDoc, "totalvenc"));
		holerite.setTotalDesconto(XMLUtils.convertContextToBigDecimal(xmlDoc, "totaldesc"));
		holerite.setSalarioLisquido(XMLUtils.convertContextToBigDecimal(xmlDoc, "liquidopgto"));
		holerite.setSalarioBase(XMLUtils.convertContextToBigDecimal(xmlDoc, "salariobase"));
		holerite.setSalarioINSS(XMLUtils.convertContextToBigDecimal(xmlDoc, "salarioinss"));
		holerite.setSalarioFGTS(XMLUtils.convertContextToBigDecimal(xmlDoc, "basefgts"));
		holerite.setFgtsMes(XMLUtils.convertContextToBigDecimal(xmlDoc, "fgtsmes"));
		holerite.setSalarioIRRF(XMLUtils.convertContextToBigDecimal(xmlDoc, "baseirrf"));
		holerite.setFaixaIRRF(XMLUtils.convertContextToBigDecimal(xmlDoc, "faixairrf"));
		
		String cnpj = XMLUtils.getTagValue(xmlDoc, "cnpj");
		
		List<Empresa> empresas = empresaService.empresaSearch(cnpj); 
		Empresa empresa;
		  
		if (empresas.size() == 0) { 
			empresa = new Empresa();
		  
			empresa.setCnpj(cnpj); empresa.setRazaoSocial(XMLUtils.getTagValue(xmlDoc,"razao"));
			  
			empresaService.empresaSalvar(empresa); 
		} else { 
			empresa = empresas.get(0); 
		}
		  
		holerite.setEmpresaHolerite(empresa);
		 
		String siglaEstado = XMLUtils.getTagValue(xmlDoc, "end_estado"); 
		List<Estado> estados = enderecoService.estadoSearch(siglaEstado); 
		Estado estado = estados.get(0);
		
		String nomeCidade = XMLUtils.getTagValue(xmlDoc, "end_cidade");
		List<Cidade> cidades = enderecoService.cidadeSearch(estado, nomeCidade); 
		Cidade cidade;
		  
		if (cidades.size() == 0) { 
			cidade = new Cidade();

			cidade.setEstadoCidade(estado);
			cidade.setNomeCidade(nomeCidade);
			enderecoService.cidadeSalvar(cidade); 
		} else { 
			cidade = cidades.get(0); 
		}
		 
		String logradouro = XMLUtils.getTagValue(xmlDoc, "endereco"); 
		String numero = XMLUtils.getTagValue(xmlDoc, "end_numero"); 
		String complemento = XMLUtils.getTagValue(xmlDoc, "end_comple"); 
		String bairro = XMLUtils.getTagValue(xmlDoc, "end_bairro"); 
		List<Endereco> enderecos = enderecoService.enderecoSearch(logradouro, numero, complemento, bairro, cidade); 
		Endereco endereco;
		
		if (enderecos.size() == 0) { 
			endereco = new Endereco();

			endereco.setLogradouro(logradouro); 
			endereco.setNumero(numero);
			endereco.setComplemento(complemento); 
			endereco.setBairro(bairro);
			endereco.setCidadeEndereco(cidade);
		  
			enderecoService.enderecoSalvar(endereco); 
		} else { 
			endereco = enderecos.get(0); 
		}
		  
		holerite.setEnderecoHolerite(endereco);
		 
		NodeList vencimentos = XMLUtils.getTagChildNodeList(xmlDoc, "vencimentos");
		
		List<HoleriteVencimento> holeriteVencimentos = new ArrayList<>(vencimentos.getLength());
		HoleriteVencimento holeriteVencimento;
		
		for (int i = 0; i < vencimentos.getLength(); i++) {
			holeriteVencimento = new HoleriteVencimento();

			holeriteVencimento.setClasse(XMLUtils.getAttributeValue(vencimentos.item(i), "classe"));
			holeriteVencimento.setDescricao(XMLUtils.getAttributeValue(vencimentos.item(i), "descricao"));
			holeriteVencimento.setReferencia(XMLUtils.getAttributeValue(vencimentos.item(i), "referencia"));
			holeriteVencimento.setValor(new BigDecimal(XMLUtils.getNodeValue(vencimentos.item(i))));
			
			holeriteVencimentos.add(holeriteVencimento);
		}
		
		holerite.setVencimentos(holeriteVencimentos);
		
		NodeList descontos = XMLUtils.getTagChildNodeList(xmlDoc, "descontos");
		
		List<HoleriteDesconto> holeriteDescontos = new ArrayList<>(descontos.getLength());
		HoleriteDesconto holeriteDesconto;
		
		for (int i = 0; i < descontos.getLength(); i++) {
			holeriteDesconto = new HoleriteDesconto();

			holeriteDesconto.setClasse(XMLUtils.getAttributeValue(descontos.item(i), "classe"));
			holeriteDesconto.setDescricao(XMLUtils.getAttributeValue(descontos.item(i), "descricao"));
			holeriteDesconto.setReferencia(XMLUtils.getAttributeValue(descontos.item(i), "referencia"));
			holeriteDesconto.setValor(new BigDecimal(XMLUtils.getNodeValue(descontos.item(i))));
			
			holeriteDescontos.add(holeriteDesconto);
		}
		
		holerite.setDescontos(holeriteDescontos);	
		
		return holerite;
	}
	
	public void holeriteGravar(Holerite holerite) {
		holeriteRepository.save(holerite);
		
		for (int i = 0; i < holerite.getVencimentos().size(); i++) {
			holerite.getVencimentos().get(i).setHoleriteVencimento(holerite);
			vencimentoGravar(holerite.getVencimentos().get(i));
		}
		
		for (int i = 0; i < holerite.getDescontos().size(); i++) {
			holerite.getDescontos().get(i).setHoleriteDesconto(holerite);
			descontoGravar(holerite.getDescontos().get(i));
		}
		
	}
	
	public void vencimentoGravar(HoleriteVencimento vencimento) {
		holeriteVencimentoRepository.save(vencimento);
	}
	
	public void descontoGravar(HoleriteDesconto desconto) {
		holeriteDescontoRepository.save(desconto);
	}
	
}
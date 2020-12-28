package br.com.ricardoianni.application.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import br.com.ricardoianni.domain.company.Empresa;
import br.com.ricardoianni.domain.employee.Colaborador;
import br.com.ricardoianni.domain.holerite.Holerite;
import br.com.ricardoianni.domain.holerite.HoleriteDesconto;
import br.com.ricardoianni.domain.holerite.HoleriteDescontoRepository;
import br.com.ricardoianni.domain.holerite.HoleriteRepository;
import br.com.ricardoianni.domain.holerite.HoleriteVencimento;
import br.com.ricardoianni.domain.holerite.HoleriteVencimentoRepository;
import br.com.ricardoianni.util.XMLUtils;
import br.com.ricardoianni.webservice.client.WebServiceClient;
import br.com.ricardoianni.webservice.client.WebServiceClientException;

@Service
public class HoleriteService {
	
	@Autowired
	private HoleriteRepository holeriteRepository;
	
	@Autowired
	private HoleriteVencimentoRepository holeriteVencimentoRepository;
	
	@Autowired
	private HoleriteDescontoRepository holeriteDescontoRepository;
	
	public Holerite holeriteSearchID(Integer idHolerite) {
		
		return holeriteRepository.findByIdHolerite(idHolerite);
	}

	public Holerite holeriteSearch(Colaborador colaborador, Empresa empresa, String mes, String ano) {
		
		return holeriteRepository.findByColaboradorHoleriteAndEmpresaHoleriteAndMesAndAno(colaborador, empresa, mes, ano);
	}
	
	public Document holeriteCarregar(Colaborador colaborador, Empresa empresa, String mes, String ano) throws WebServiceClientException {
		WebServiceClient webService = new WebServiceClient();
		
		String customerID = empresa.getClienteEmpresa().getCustomerID();
		String username = empresa.getClienteEmpresa().getUsername();
		String password = empresa.getClienteEmpresa().getPassword();
		String endPoint = empresa.getClienteEmpresa().getEndpoint();
		
		webService.setCostumerID(customerID);
		webService.setUsername(username);
		webService.setPassword(password);
		
		webService.webServiceStart(endPoint);
		
		return webService.webServiceHolerite(colaborador, mes, ano);
		
	}
	
	@Transactional
	public Holerite holeriteCriar(Document xmlDoc, Colaborador colaborador) {
		Holerite holerite = new Holerite();

		holerite.setColaboradorHolerite(colaborador);
		holerite.setDataAdmissao(XMLUtils.convertContextToDate(xmlDoc, "dt_admissao"));
		holerite.setContrato(XMLUtils.getTagValue(xmlDoc, "contrato"));
		holerite.setFuncao(XMLUtils.getTagValue(xmlDoc, "funcao"));
		holerite.setCbo(XMLUtils.getTagValue(xmlDoc, "cbo"));
		holerite.setDepartamento(XMLUtils.getTagValue(xmlDoc, "departamento"));
		
		holerite.setTotalVencimento(XMLUtils.convertContextToBigDecimal(xmlDoc, "totalvenc"));
		holerite.setTotalDesconto(XMLUtils.convertContextToBigDecimal(xmlDoc, "totaldesc"));
		holerite.setSalarioLiquido(XMLUtils.convertContextToBigDecimal(xmlDoc, "liquidopgto"));
		holerite.setSalarioBase(XMLUtils.convertContextToBigDecimal(xmlDoc, "salariobase"));
		holerite.setSalarioINSS(XMLUtils.convertContextToBigDecimal(xmlDoc, "salarioinss"));
		holerite.setSalarioFGTS(XMLUtils.convertContextToBigDecimal(xmlDoc, "basefgts"));
		holerite.setFgtsMes(XMLUtils.convertContextToBigDecimal(xmlDoc, "fgtsmes"));
		holerite.setSalarioIRRF(XMLUtils.convertContextToBigDecimal(xmlDoc, "baseirrf"));
		holerite.setFaixaIRRF(XMLUtils.convertContextToBigDecimal(xmlDoc, "faixairrf"));
		
		Empresa empresa = colaborador.getEmpresasColaborador().get(0);
		
		holerite.setEmpresaHolerite(empresa);
		 		  
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
	
	@Transactional
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
	
	@Transactional
	public void vencimentoGravar(HoleriteVencimento vencimento) {
		holeriteVencimentoRepository.save(vencimento);
	}

	@Transactional
	public void descontoGravar(HoleriteDesconto desconto) {
		holeriteDescontoRepository.save(desconto);
	}

}
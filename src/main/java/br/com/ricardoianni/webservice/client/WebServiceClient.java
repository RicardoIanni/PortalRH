package br.com.ricardoianni.webservice.client;

import org.tempuri.EASWebServiceLocator;
import org.tempuri.EASWebServiceSoap;
import org.tempuri.ExecutarComandoResponseExecutarComandoResult;
import org.w3c.dom.Document;

import br.com.ricardoianni.domain.employee.Colaborador;
import br.com.ricardoianni.domain.holerite.TipoRecibo;
import br.com.ricardoianni.util.XMLUtils;
import lombok.Data;

@Data
public class WebServiceClient {
	
	private EASWebServiceSoap webService;
	
	private String costumerID;
	
	private String username;
	
	private String password;
	
	public void webServiceStart(String endPoint) throws WebServiceClientException {
		EASWebServiceLocator locator = new EASWebServiceLocator();
		locator.setEASWebServiceSoapEndpointAddress(endPoint);
		
		try {
			webService = locator.getEASWebServiceSoap();
		} catch (Exception e) {
			throw new WebServiceClientException("Não foi possivel conectar ao WebService.");
		}

	}
	
	public Document webServiceHolerite(Colaborador colaborador, String mes, String ano, TipoRecibo tipoRecibo) {
		String comando = "XMLHolerite:Exec('" + colaborador.getIdFunc() + "', '" + mes + "', '" + ano + "', '" + tipoRecibo.name() + "')";
		ExecutarComandoResponseExecutarComandoResult retorno;
		Document xmlDoc = null;
		
		try {
			retorno = webService.executarComando(comando, costumerID, username, password);
			
			xmlDoc = XMLUtils.convertRetornoStringtoXML(retorno.get_any()[0].getAsString());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return xmlDoc;
		
	}
	
	public Document webServiceEmpresas() {
		String comando = "XMLEmpresa:Exec()";
		ExecutarComandoResponseExecutarComandoResult retorno;
		Document xmlDoc = null;
		
		try {
			retorno = webService.executarComando(comando, costumerID, username, password);
			
			xmlDoc = XMLUtils.convertRetornoStringtoXML(retorno.get_any()[0].getAsString());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return xmlDoc;
		
	}
	
	public Document webServiceColaboradores(String empresaCodigo) {
		String comando = "";
		
		if (empresaCodigo == null) {
			comando = "XMLColab:Exec()";
		} else {
			comando = "XMLColab:Exec(\"" + empresaCodigo + "\")";
		}
		
		ExecutarComandoResponseExecutarComandoResult retorno;
		Document xmlDoc = null;
		
		try {
			retorno = webService.executarComando(comando, costumerID, username, password);
			
			xmlDoc = XMLUtils.convertRetornoStringtoXML(retorno.get_any()[0].getAsString());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return xmlDoc;
	}
	
	public Document webServiceCompetencias(String colaboradorIdFunc) {
		String comando = "";
		
		comando = "XMLCompet:Exec(\"" + colaboradorIdFunc + "\")";
		
		ExecutarComandoResponseExecutarComandoResult retorno;
		Document xmlDoc = null;
		
		try {
			retorno = webService.executarComando(comando, costumerID, username, password);
			
			xmlDoc = XMLUtils.convertRetornoStringtoXML(retorno.get_any()[0].getAsString());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return xmlDoc;
	}

}

package br.com.ricardoianni.webservice.client;

import org.tempuri.EASWebServiceLocator;
import org.tempuri.EASWebServiceSoap;
import org.tempuri.ExecutarComandoResponseExecutarComandoResult;
import org.w3c.dom.Document;

import br.com.ricardoianni.util.XMLUtils;
import lombok.Data;

@Data
public class WebServiceClient {
	
	private EASWebServiceSoap webService;
	
	private String costumerID;
	
	private String username;
	
	private String password;
	
	public void webServiceStart(String endPoint) {
		EASWebServiceLocator locator = new EASWebServiceLocator();
		locator.setEASWebServiceSoapEndpointAddress(endPoint);
		
		try {
			webService = locator.getEASWebServiceSoap();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public Document webServiceHolerite(String idFunc, String mes, String ano) {
		String comando = "XMLHolerite:Exec('" + idFunc + "', '" + mes + "', '" + ano + "')";
		ExecutarComandoResponseExecutarComandoResult retorno;
		Document xmlDoc = null;
		
		try {
			retorno = webService.executarComando(comando, costumerID, username, password);
			String xmlString = retorno.get_any()[0].getAsString();
			
			xmlString = xmlString.replaceAll("><", ">\n<");
			String[] xmlArray = xmlString.split("\n");
			
			xmlString = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
			for (int i = 1; i < xmlArray.length - 1; i++) {
				xmlString += xmlArray[i].trim();
			}
			
			xmlDoc = XMLUtils.convertStringToXML(xmlString);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return xmlDoc;
		
	}

}

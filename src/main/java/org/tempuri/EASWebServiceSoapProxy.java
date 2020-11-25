package org.tempuri;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;
import javax.xml.rpc.Stub;

import org.apache.axis.types.UnsignedByte;

public class EASWebServiceSoapProxy implements EASWebServiceSoap {

	private String _endpoint = null;

	private EASWebServiceSoap eASWebServiceSoap = null;
  
 
	public EASWebServiceSoapProxy() {
		_initEASWebServiceSoapProxy();
    }

	public EASWebServiceSoapProxy(String endpoint) {
		_endpoint = endpoint;
		_initEASWebServiceSoapProxy();
    }
  
	private void _initEASWebServiceSoapProxy() {
		
		try {
			eASWebServiceSoap = (new org.tempuri.EASWebServiceLocator()).getEASWebServiceSoap();
			if (eASWebServiceSoap != null) {
				if (_endpoint != null) {
					((javax.xml.rpc.Stub)eASWebServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
				} else {
					_endpoint = (String)((javax.xml.rpc.Stub)eASWebServiceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
				}
			}
		}
		catch (ServiceException serviceException) {
			
		}
	
	}
  
	public String getEndpoint() {
		return _endpoint;
	}
	
	public void setEndpoint(String endpoint) {
		_endpoint = endpoint;
		if (eASWebServiceSoap != null) {
			( (Stub) eASWebServiceSoap )._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
		}
	}
	
	public EASWebServiceSoap getEASWebServiceSoap() {
		if (eASWebServiceSoap == null) {
			_initEASWebServiceSoapProxy();
		}
		
		return eASWebServiceSoap;
	}

	public String getVersion() throws RemoteException {
		if (eASWebServiceSoap == null) {
			_initEASWebServiceSoapProxy();
		}
		
		return eASWebServiceSoap.getVersion();
	}
	
	public ListObjectsResponseListObjectsResult listObjects(String costumerId, 
															String strUsername, 
															String strPassword) throws RemoteException {
		if (eASWebServiceSoap == null) {
			_initEASWebServiceSoapProxy();
		}
    
		return eASWebServiceSoap.listObjects(costumerId, strUsername, strPassword);
	}
	
	public SearchValueResponseSearchValueResult searchValue(UnsignedByte tipoPesquisa, 
															String stringBusca, 
															String costumerId, 
															String strUsername, 
															String strPassword) throws RemoteException {
		if (eASWebServiceSoap == null) {
	    	_initEASWebServiceSoapProxy();
	    }
	    
	    return eASWebServiceSoap.searchValue(tipoPesquisa, stringBusca, costumerId, strUsername, strPassword);
	    
	}
  
	public CreditAvaliationResponseCreditAvaliationResult creditAvaliation( String CNPJ, 
																			UnsignedByte tipoAnalise, 
																			String costumerId, 
																			String strUsername, 
																			String strPassword) throws RemoteException {
		if (eASWebServiceSoap == null) {
			_initEASWebServiceSoapProxy();
		}
		
		return eASWebServiceSoap.creditAvaliation(CNPJ, tipoAnalise, costumerId, strUsername, strPassword);

	}
	
	public FinancialHistoryResponseFinancialHistoryResult financialHistory( int codigoCliente, 
																			String dataInicial, 
																			String dataFinal, 
																			String moeda, 
																			String costumerId, 
																			String strUsername, 
																			String strPassword) throws RemoteException {
		if (eASWebServiceSoap == null) {
			_initEASWebServiceSoapProxy();
		}
		
		return eASWebServiceSoap.financialHistory(codigoCliente, dataInicial, dataFinal, moeda, costumerId, strUsername, strPassword);
		
	}
	
	public double saldoDeContaCorrente( String conta, 
										String data, 
										String costumerId, 
										String strUsername, 
										String strPassword) throws RemoteException {
		if (eASWebServiceSoap == null) {
			_initEASWebServiceSoapProxy();
		}
		
		return eASWebServiceSoap.saldoDeContaCorrente(conta, data, costumerId, strUsername, strPassword);

	}
	
	public double saldoEstoqueFisico(String codigo, 
									 int empresa, 
									 String local, 
									 String costumerId, 
									 String strUsername, 
									 String strPassword) throws RemoteException {
		if (eASWebServiceSoap == null) {
			_initEASWebServiceSoapProxy();
		}
		
		return eASWebServiceSoap.saldoEstoqueFisico(codigo, empresa, local, costumerId, strUsername, strPassword);

	}
	
	public double quantidadeReserva(String codigo, 
									int empresa, 
									String local, 
									String costumerId, 
									String strUsername, 
									String strPassword) throws RemoteException {
		if (eASWebServiceSoap == null) {
			_initEASWebServiceSoapProxy();
		}
		
		return eASWebServiceSoap.quantidadeReserva(codigo, empresa, local, costumerId, strUsername, strPassword);

	}
	
	public double quantidadeCarteira(String codigo, 
									 int empresa, 
									 String local, 
									 String costumerId, 
									 String strUsername, 
									 String strPassword) throws RemoteException {
		if (eASWebServiceSoap == null) {
			_initEASWebServiceSoapProxy();
		}

		return eASWebServiceSoap.quantidadeCarteira(codigo, empresa, local, costumerId, strUsername, strPassword);

	}
	
	public double quantidadeEstoqueRequisitado( String codigo, 
												int empresa, 
												String local, 
												String costumerId, 
												String strUsername, 
												String strPassword) throws RemoteException {
		if (eASWebServiceSoap == null) {
			_initEASWebServiceSoapProxy();
		}

		return eASWebServiceSoap.quantidadeEstoqueRequisitado(codigo, empresa, local, costumerId, strUsername, strPassword);

	}
	
	public double valorAPagarNoDia( int empresa, 
									String data, 
									String moeda, 
									String costumerId, 
									String strUsername, 
									String strPassword) throws RemoteException {
		if (eASWebServiceSoap == null) {
			_initEASWebServiceSoapProxy();
		}

		return eASWebServiceSoap.valorAPagarNoDia(empresa, data, moeda, costumerId, strUsername, strPassword);

	}
	
	public double valorAReceberNoDia(int empresa, 
									 String data, 
									 String moeda, 
									 String costumerId, 
									 String strUsername, 
									 String strPassword) throws RemoteException {
		if (eASWebServiceSoap == null) {
			_initEASWebServiceSoapProxy();
		}

		return eASWebServiceSoap.valorAReceberNoDia(empresa, data, moeda, costumerId, strUsername, strPassword);

	}
	
	public String descricaoDoProduto(String codigo, 
									 String costumerId, 
									 String strUsername, 
									 String strPassword) throws RemoteException {
		if (eASWebServiceSoap == null) {
			_initEASWebServiceSoapProxy();
		}

		return eASWebServiceSoap.descricaoDoProduto(codigo, costumerId, strUsername, strPassword);

	}
	
	public ExecutarComandoResponseExecutarComandoResult executarComando(String comando, 
																		String costumerId, 
																		String strUsername, 
																		String strPassword) throws RemoteException {
		if (eASWebServiceSoap == null) {
			_initEASWebServiceSoapProxy();
		}

		return eASWebServiceSoap.executarComando(comando, costumerId, strUsername, strPassword);

	}
	
	public String callXmlProcess(String processo, 
								 String xml1, 
								 String costumerId, 
								 String strUsername, 
								 String strPassword) throws RemoteException {
		if (eASWebServiceSoap == null) {
			_initEASWebServiceSoapProxy();
		}
		
		return eASWebServiceSoap.callXmlProcess(processo, xml1, costumerId, strUsername, strPassword);

	}
 
}
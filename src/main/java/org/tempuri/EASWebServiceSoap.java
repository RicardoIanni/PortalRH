/**
 * EASWebServiceSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.apache.axis.types.UnsignedByte;

public interface EASWebServiceSoap extends Remote {

	public String getVersion() throws RemoteException;

    public ListObjectsResponseListObjectsResult listObjects(String costumerId, 
    														String strUsername, 
    														String strPassword) throws RemoteException;
    
    public SearchValueResponseSearchValueResult searchValue(UnsignedByte tipoPesquisa, 
    														String stringBusca, 
    														String costumerId, 
    														String strUsername, 
    														String strPassword) throws RemoteException;
    
    public CreditAvaliationResponseCreditAvaliationResult creditAvaliation(	String CNPJ, 
    																		UnsignedByte tipoAnalise, 
    																		String costumerId, 
    																		String strUsername, 
    																		String strPassword) throws RemoteException;
    
    public FinancialHistoryResponseFinancialHistoryResult financialHistory(	int codigoCliente, 
    																		String dataInicial, 
    																		String dataFinal, 
    																		String moeda, 
    																		String costumerId, 
    																		String strUsername, 
    																		String strPassword) throws RemoteException;
    
    public double saldoDeContaCorrente(	String conta, 
    									String data, 
    									String costumerId, 
    									String strUsername, 
    									String strPassword) throws RemoteException;
    
    public double saldoEstoqueFisico(String codigo, 
    								 int empresa, 
    								 String local, 
    								 String costumerId, 
    								 String strUsername, 
    								 String strPassword) throws RemoteException;
    
    public double quantidadeReserva(String codigo, 
    								int empresa, 
    								String local, 
    								String costumerId, 
    								String strUsername, 
    								String strPassword) throws RemoteException;
    
    public double quantidadeCarteira(String codigo, 
    								 int empresa, 
    								 String local, 
    								 String costumerId, 
    								 String strUsername, 
    								 String strPassword) throws RemoteException;
    
    public double quantidadeEstoqueRequisitado( String codigo, 
    											int empresa, 
    											String local, 
    											String costumerId, 
    											String strUsername, 
    											String strPassword) throws RemoteException;
    
    public double valorAPagarNoDia( int empresa, 
    								String data, 
    								String moeda, 
    								String costumerId, 
    								String strUsername, 
    								String strPassword) throws RemoteException;
    
    public double valorAReceberNoDia(int empresa, 
    								 String data, 
    								 String moeda, 
    								 String costumerId, 
    								 String strUsername, 
    								 String strPassword) throws RemoteException;
    
    public String descricaoDoProduto(String codigo, 
    								 String costumerId, 
    								 String strUsername, 
    								 String strPassword) throws RemoteException;
    
    public ExecutarComandoResponseExecutarComandoResult executarComando(String comando, 
    																	String costumerId, 
    																	String strUsername, 
    																	String strPassword) throws RemoteException;    
    
    public String callXmlProcess(String processo, 
    							 String xml1, 
    							 String costumerId, 
    							 String strUsername, 
    							 String strPassword) throws RemoteException;

}

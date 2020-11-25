/**
 * EASWebServiceSoapStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.Enumeration;
import java.util.Vector;

import javax.xml.namespace.QName;
import javax.xml.rpc.Service;
import javax.xml.rpc.encoding.SerializerFactory;

import org.apache.axis.AxisEngine;
import org.apache.axis.AxisFault;
import org.apache.axis.NoEndPointException;
import org.apache.axis.client.Call;
import org.apache.axis.client.Stub;
import org.apache.axis.constants.Style;
import org.apache.axis.constants.Use;
import org.apache.axis.description.OperationDesc;
import org.apache.axis.description.ParameterDesc;
import org.apache.axis.encoding.ser.ArrayDeserializerFactory;
import org.apache.axis.encoding.ser.ArraySerializerFactory;
import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;
import org.apache.axis.encoding.ser.EnumDeserializerFactory;
import org.apache.axis.encoding.ser.EnumSerializerFactory;
import org.apache.axis.encoding.ser.SimpleDeserializerFactory;
import org.apache.axis.encoding.ser.SimpleListDeserializerFactory;
import org.apache.axis.encoding.ser.SimpleListSerializerFactory;
import org.apache.axis.encoding.ser.SimpleSerializerFactory;
import org.apache.axis.soap.SOAPConstants;
import org.apache.axis.types.UnsignedByte;
import org.apache.axis.utils.JavaUtils;

public class EASWebServiceSoapStub extends Stub implements EASWebServiceSoap {
    private Vector<Object> cachedSerClasses = new Vector<>();
    private Vector<Object> cachedSerQNames = new Vector<>();
    private Vector<Object> cachedSerFactories = new Vector<>();
    private Vector<Object> cachedDeserFactories = new Vector<>();

    static OperationDesc [] _operations;

    static {
        _operations = new OperationDesc[15];
        _initOperationDesc1();
        _initOperationDesc2();
    }

    private static void _initOperationDesc1(){
        OperationDesc oper;
        ParameterDesc param;
        oper = new OperationDesc();
        oper.setName("GetVersion");
        oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(String.class);
        oper.setReturnQName(new QName("http://tempuri.org/", "GetVersionResult"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[0] = oper;

        oper = new OperationDesc();
        oper.setName("ListObjects");
        param = new ParameterDesc(new QName("http://tempuri.org/", "CostumerId"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "strUsername"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "strPassword"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://tempuri.org/", ">>ListObjectsResponse>ListObjectsResult"));
        oper.setReturnClass(ListObjectsResponseListObjectsResult.class);
        oper.setReturnQName(new QName("http://tempuri.org/", "ListObjectsResult"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[1] = oper;

        oper = new OperationDesc();
        oper.setName("SearchValue");
        param = new ParameterDesc(new QName("http://tempuri.org/", "TipoPesquisa"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"), org.apache.axis.types.UnsignedByte.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "StringBusca"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "CostumerId"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "strUsername"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "strPassword"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://tempuri.org/", ">>SearchValueResponse>SearchValueResult"));
        oper.setReturnClass(SearchValueResponseSearchValueResult.class);
        oper.setReturnQName(new QName("http://tempuri.org/", "SearchValueResult"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[2] = oper;

        oper = new OperationDesc();
        oper.setName("CreditAvaliation");
        param = new ParameterDesc(new QName("http://tempuri.org/", "CNPJ"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "TipoAnalise"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"), org.apache.axis.types.UnsignedByte.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "CostumerId"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "strUsername"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "strPassword"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://tempuri.org/", ">>CreditAvaliationResponse>CreditAvaliationResult"));
        oper.setReturnClass(CreditAvaliationResponseCreditAvaliationResult.class);
        oper.setReturnQName(new QName("http://tempuri.org/", "CreditAvaliationResult"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[3] = oper;

        oper = new OperationDesc();
        oper.setName("FinancialHistory");
        param = new ParameterDesc(new QName("http://tempuri.org/", "CodigoCliente"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "DataInicial"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "DataFinal"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "Moeda"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "CostumerId"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "strUsername"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "strPassword"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://tempuri.org/", ">>FinancialHistoryResponse>FinancialHistoryResult"));
        oper.setReturnClass(FinancialHistoryResponseFinancialHistoryResult.class);
        oper.setReturnQName(new QName("http://tempuri.org/", "FinancialHistoryResult"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[4] = oper;

        oper = new OperationDesc();
        oper.setName("SaldoDeContaCorrente");
        param = new ParameterDesc(new QName("http://tempuri.org/", "Conta"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "Data"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "CostumerId"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "strUsername"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "strPassword"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "double"));
        oper.setReturnClass(double.class);
        oper.setReturnQName(new QName("http://tempuri.org/", "SaldoDeContaCorrenteResult"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[5] = oper;

        oper = new OperationDesc();
        oper.setName("SaldoEstoqueFisico");
        param = new ParameterDesc(new QName("http://tempuri.org/", "Codigo"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "Empresa"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "Local"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "CostumerId"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "strUsername"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "strPassword"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "double"));
        oper.setReturnClass(double.class);
        oper.setReturnQName(new QName("http://tempuri.org/", "SaldoEstoqueFisicoResult"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[6] = oper;

        oper = new OperationDesc();
        oper.setName("QuantidadeReserva");
        param = new ParameterDesc(new QName("http://tempuri.org/", "Codigo"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "Empresa"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "Local"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "CostumerId"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "strUsername"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "strPassword"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "double"));
        oper.setReturnClass(double.class);
        oper.setReturnQName(new QName("http://tempuri.org/", "QuantidadeReservaResult"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[7] = oper;

        oper = new OperationDesc();
        oper.setName("QuantidadeCarteira");
        param = new ParameterDesc(new QName("http://tempuri.org/", "Codigo"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "Empresa"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "Local"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "CostumerId"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "strUsername"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "strPassword"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "double"));
        oper.setReturnClass(double.class);
        oper.setReturnQName(new QName("http://tempuri.org/", "QuantidadeCarteiraResult"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[8] = oper;

        oper = new OperationDesc();
        oper.setName("QuantidadeEstoqueRequisitado");
        param = new ParameterDesc(new QName("http://tempuri.org/", "Codigo"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "Empresa"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "Local"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "CostumerId"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "strUsername"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "strPassword"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "double"));
        oper.setReturnClass(double.class);
        oper.setReturnQName(new QName("http://tempuri.org/", "QuantidadeEstoqueRequisitadoResult"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        OperationDesc oper;
        ParameterDesc param;
        oper = new OperationDesc();
        oper.setName("ValorAPagarNoDia");
        param = new ParameterDesc(new QName("http://tempuri.org/", "Empresa"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "Data"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "Moeda"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "CostumerId"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "strUsername"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "strPassword"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "double"));
        oper.setReturnClass(double.class);
        oper.setReturnQName(new QName("http://tempuri.org/", "ValorAPagarNoDiaResult"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[10] = oper;

        oper = new OperationDesc();
        oper.setName("ValorAReceberNoDia");
        param = new ParameterDesc(new QName("http://tempuri.org/", "Empresa"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "Data"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "Moeda"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "CostumerId"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "strUsername"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "strPassword"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "double"));
        oper.setReturnClass(double.class);
        oper.setReturnQName(new QName("http://tempuri.org/", "ValorAReceberNoDiaResult"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[11] = oper;

        oper = new OperationDesc();
        oper.setName("DescricaoDoProduto");
        param = new ParameterDesc(new QName("http://tempuri.org/", "Codigo"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "CostumerId"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "strUsername"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "strPassword"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(String.class);
        oper.setReturnQName(new QName("http://tempuri.org/", "DescricaoDoProdutoResult"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[12] = oper;

        oper = new OperationDesc();
        oper.setName("executarComando");
        param = new ParameterDesc(new QName("http://tempuri.org/", "comando"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "CostumerId"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "strUsername"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "strPassword"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://tempuri.org/", ">>executarComandoResponse>executarComandoResult"));
        oper.setReturnClass(ExecutarComandoResponseExecutarComandoResult.class);
        oper.setReturnQName(new QName("http://tempuri.org/", "executarComandoResult"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[13] = oper;

        oper = new OperationDesc();
        oper.setName("callXmlProcess");
        param = new ParameterDesc(new QName("http://tempuri.org/", "processo"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "xml1"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "CostumerId"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "strUsername"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("http://tempuri.org/", "strPassword"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(String.class);
        oper.setReturnQName(new QName("http://tempuri.org/", "callXmlProcessResult"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        _operations[14] = oper;

    }

    public EASWebServiceSoapStub() throws AxisFault {
         this(null);
    }

    public EASWebServiceSoapStub(URL endpointURL, Service service) throws AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    @SuppressWarnings({ "rawtypes", "unused" })
	public EASWebServiceSoapStub(Service service) throws AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            Class cls;
            QName qName;
            QName qName2;
            Class beansf = BeanSerializerFactory.class;
            Class beandf = BeanDeserializerFactory.class;
            Class enumsf = EnumSerializerFactory.class;
            Class enumdf = EnumDeserializerFactory.class;
            Class arraysf = ArraySerializerFactory.class;
            Class arraydf = ArrayDeserializerFactory.class;
            Class simplesf = SimpleSerializerFactory.class;
            Class simpledf = SimpleDeserializerFactory.class;
            Class simplelistsf = SimpleListSerializerFactory.class;
            Class simplelistdf = SimpleListDeserializerFactory.class;
            qName = new QName("http://tempuri.org/", ">>CreditAvaliationResponse>CreditAvaliationResult");
            cachedSerQNames.add(qName);
            cls = CreditAvaliationResponseCreditAvaliationResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("http://tempuri.org/", ">>executarComandoResponse>executarComandoResult");
            cachedSerQNames.add(qName);
            cls = ExecutarComandoResponseExecutarComandoResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("http://tempuri.org/", ">>FinancialHistoryResponse>FinancialHistoryResult");
            cachedSerQNames.add(qName);
            cls = FinancialHistoryResponseFinancialHistoryResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("http://tempuri.org/", ">>ListObjectsResponse>ListObjectsResult");
            cachedSerQNames.add(qName);
            cls = ListObjectsResponseListObjectsResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("http://tempuri.org/", ">>SearchValueResponse>SearchValueResult");
            cachedSerQNames.add(qName);
            cls = SearchValueResponseSearchValueResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("http://tempuri.org/", ">callXmlProcess");
            cachedSerQNames.add(qName);
            cls = CallXmlProcess.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("http://tempuri.org/", ">callXmlProcessResponse");
            cachedSerQNames.add(qName);
            cls = CallXmlProcessResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("http://tempuri.org/", ">CreditAvaliation");
            cachedSerQNames.add(qName);
            cls = CreditAvaliation.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("http://tempuri.org/", ">CreditAvaliationResponse");
            cachedSerQNames.add(qName);
            cls = CreditAvaliationResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("http://tempuri.org/", ">DescricaoDoProduto");
            cachedSerQNames.add(qName);
            cls = DescricaoDoProduto.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("http://tempuri.org/", ">DescricaoDoProdutoResponse");
            cachedSerQNames.add(qName);
            cls = DescricaoDoProdutoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("http://tempuri.org/", ">executarComando");
            cachedSerQNames.add(qName);
            cls = ExecutarComando.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("http://tempuri.org/", ">executarComandoResponse");
            cachedSerQNames.add(qName);
            cls = ExecutarComandoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("http://tempuri.org/", ">FinancialHistory");
            cachedSerQNames.add(qName);
            cls = FinancialHistory.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("http://tempuri.org/", ">FinancialHistoryResponse");
            cachedSerQNames.add(qName);
            cls = FinancialHistoryResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("http://tempuri.org/", ">QuantidadeCarteira");
            cachedSerQNames.add(qName);
            cls = QuantidadeCarteira.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("http://tempuri.org/", ">QuantidadeCarteiraResponse");
            cachedSerQNames.add(qName);
            cls = QuantidadeCarteiraResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("http://tempuri.org/", ">QuantidadeEstoqueRequisitado");
            cachedSerQNames.add(qName);
            cls = QuantidadeEstoqueRequisitado.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("http://tempuri.org/", ">QuantidadeEstoqueRequisitadoResponse");
            cachedSerQNames.add(qName);
            cls = QuantidadeEstoqueRequisitadoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("http://tempuri.org/", ">QuantidadeReserva");
            cachedSerQNames.add(qName);
            cls = QuantidadeReserva.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("http://tempuri.org/", ">QuantidadeReservaResponse");
            cachedSerQNames.add(qName);
            cls = QuantidadeReservaResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("http://tempuri.org/", ">SaldoDeContaCorrente");
            cachedSerQNames.add(qName);
            cls = SaldoDeContaCorrente.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("http://tempuri.org/", ">SaldoDeContaCorrenteResponse");
            cachedSerQNames.add(qName);
            cls = SaldoDeContaCorrenteResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("http://tempuri.org/", ">SaldoEstoqueFisico");
            cachedSerQNames.add(qName);
            cls = SaldoEstoqueFisico.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("http://tempuri.org/", ">SaldoEstoqueFisicoResponse");
            cachedSerQNames.add(qName);
            cls = SaldoEstoqueFisicoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("http://tempuri.org/", ">SearchValue");
            cachedSerQNames.add(qName);
            cls = SearchValue.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("http://tempuri.org/", ">SearchValueResponse");
            cachedSerQNames.add(qName);
            cls = SearchValueResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("http://tempuri.org/", ">ValorAPagarNoDia");
            cachedSerQNames.add(qName);
            cls = ValorAPagarNoDia.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("http://tempuri.org/", ">ValorAPagarNoDiaResponse");
            cachedSerQNames.add(qName);
            cls = ValorAPagarNoDiaResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("http://tempuri.org/", ">ValorAReceberNoDia");
            cachedSerQNames.add(qName);
            cls = ValorAReceberNoDia.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("http://tempuri.org/", ">ValorAReceberNoDiaResponse");
            cachedSerQNames.add(qName);
            cls = ValorAReceberNoDiaResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    @SuppressWarnings("rawtypes")
	protected Call createCall() throws RemoteException {
        try {
            Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            Enumeration<?> keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                String key = (String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        Class cls = (Class) cachedSerClasses.get(i);
                        QName qName =
                                (QName) cachedSerQNames.get(i);
                        Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            Class sf = (Class)
                                 cachedSerFactories.get(i);
                            Class df = (Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (Throwable _t) {
            throw new AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public String getVersion() throws RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/GetVersion");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("http://tempuri.org/", "GetVersion"));

        setRequestHeaders(_call);
        setAttachments(_call);
        try {
        	Object _resp = _call.invoke(new Object[] {});

        	if (_resp instanceof RemoteException) {
        		throw (RemoteException)_resp;
        	} else {
        		extractAttachments(_call);
        		try {
        			return (String) _resp;
        		} catch (Exception _exception) {
        			return (String) JavaUtils.convert(_resp, String.class);
        		}
        	}
        } catch (AxisFault axisFaultException) {
        	throw axisFaultException;
        }
    }

    public ListObjectsResponseListObjectsResult listObjects(String costumerId, String strUsername, String strPassword) throws RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/ListObjects");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("http://tempuri.org/", "ListObjects"));

        setRequestHeaders(_call);
        setAttachments(_call);
 
        try {
        	Object _resp = _call.invoke(new Object[] {costumerId, strUsername, strPassword});

        	if (_resp instanceof RemoteException) {
        		throw (RemoteException)_resp;
        	} else {
        		extractAttachments(_call);
        		
        		try {
        			return (ListObjectsResponseListObjectsResult) _resp;
        		} catch (Exception _exception) {
        			return (ListObjectsResponseListObjectsResult) JavaUtils.convert(_resp, ListObjectsResponseListObjectsResult.class);
        		}
        	}
        } catch (AxisFault axisFaultException) {
        	throw axisFaultException;
        }
    }

    public SearchValueResponseSearchValueResult searchValue(org.apache.axis.types.UnsignedByte tipoPesquisa, String stringBusca, String costumerId, String strUsername, String strPassword) throws RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/SearchValue");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("http://tempuri.org/", "SearchValue"));

        setRequestHeaders(_call);
        setAttachments(_call);
        
        try {
        	Object _resp = _call.invoke(new Object[] {tipoPesquisa, stringBusca, costumerId, strUsername, strPassword});

        	if (_resp instanceof RemoteException) {
        		throw (RemoteException)_resp;
        	} else {
        		extractAttachments(_call);
        		try {
        			return (SearchValueResponseSearchValueResult) _resp;
        		} catch (Exception _exception) {
        			return (SearchValueResponseSearchValueResult) JavaUtils.convert(_resp, SearchValueResponseSearchValueResult.class);
        		}
        	}
        } catch (AxisFault axisFaultException) {
        	throw axisFaultException;
        }
    }

    public CreditAvaliationResponseCreditAvaliationResult creditAvaliation(String CNPJ, UnsignedByte tipoAnalise, String costumerId, String strUsername, String strPassword) throws RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }

        Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/CreditAvaliation");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("http://tempuri.org/", "CreditAvaliation"));

        setRequestHeaders(_call);
        setAttachments(_call);
        
        try {
        	Object _resp = _call.invoke(new Object[] {CNPJ, tipoAnalise, costumerId, strUsername, strPassword});

        	if (_resp instanceof RemoteException) {
        		throw (RemoteException)_resp;
        	} else {
        		extractAttachments(_call);
        		try {
        			return (CreditAvaliationResponseCreditAvaliationResult) _resp;
        		} catch (Exception _exception) {
        			return (CreditAvaliationResponseCreditAvaliationResult) JavaUtils.convert(_resp, CreditAvaliationResponseCreditAvaliationResult.class);
        		}
        	}
        } catch (AxisFault axisFaultException) {
        	throw axisFaultException;
        }
    }

	public FinancialHistoryResponseFinancialHistoryResult financialHistory(int codigoCliente, String dataInicial, String dataFinal, String moeda, String costumerId, String strUsername, String strPassword) throws RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/FinancialHistory");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("http://tempuri.org/", "FinancialHistory"));

        setRequestHeaders(_call);
        setAttachments(_call);
 
        try {
        	Object _resp = _call.invoke(new Object[] { Integer.valueOf(codigoCliente), dataInicial, dataFinal, moeda, costumerId, strUsername, strPassword});

        	if (_resp instanceof RemoteException) {
        		throw (RemoteException)_resp;
        	} else {
        		extractAttachments(_call);
        		
        		try {
        			return (FinancialHistoryResponseFinancialHistoryResult) _resp;
        		} catch (Exception _exception) {
        			return (FinancialHistoryResponseFinancialHistoryResult) JavaUtils.convert(_resp, FinancialHistoryResponseFinancialHistoryResult.class);
        		}
        	}
        } catch (AxisFault axisFaultException) {
        	throw axisFaultException;
        }
    }

    public double saldoDeContaCorrente(String conta, String data, String costumerId, String strUsername, String strPassword) throws RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/SaldoDeContaCorrente");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("http://tempuri.org/", "SaldoDeContaCorrente"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {conta, data, costumerId, strUsername, strPassword});

        if (_resp instanceof RemoteException) {
            throw (RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Double) _resp).doubleValue();
            } catch (Exception _exception) {
                return ((java.lang.Double) JavaUtils.convert(_resp, double.class)).doubleValue();
            }
        }
  } catch (AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public double saldoEstoqueFisico(String codigo, int empresa, String local, String costumerId, String strUsername, String strPassword) throws RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/SaldoEstoqueFisico");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("http://tempuri.org/", "SaldoEstoqueFisico"));

        setRequestHeaders(_call);
        setAttachments(_call);
        
        try {        
        	Object _resp = _call.invoke(new Object[] {codigo, Integer.valueOf(empresa), local, costumerId, strUsername, strPassword});

	        if (_resp instanceof RemoteException) {
	            throw (RemoteException)_resp;
	        } else {
	            extractAttachments(_call);
	            try {
	                return ((java.lang.Double) _resp).doubleValue();
	            } catch (Exception _exception) {
	                return ((java.lang.Double) JavaUtils.convert(_resp, double.class)).doubleValue();
	            }
	        }
		} catch (AxisFault axisFaultException) {
			throw axisFaultException;
		}
    }

    public double quantidadeReserva(String codigo, int empresa, String local, String costumerId, String strUsername, String strPassword) throws RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/QuantidadeReserva");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("http://tempuri.org/", "QuantidadeReserva"));

        setRequestHeaders(_call);
        setAttachments(_call);
    
        try {        
        	Object _resp = _call.invoke(new Object[] {codigo, Integer.valueOf(empresa), local, costumerId, strUsername, strPassword});

        	if (_resp instanceof RemoteException) {
        		throw (RemoteException)_resp;
        	} else {
        		extractAttachments(_call);
        		try {
        			return ((java.lang.Double) _resp).doubleValue();
        		} catch (Exception _exception) {
        			return ((java.lang.Double) JavaUtils.convert(_resp, double.class)).doubleValue();
        		}
        	}
        } catch (AxisFault axisFaultException) {
        	throw axisFaultException;
        }
    }

    public double quantidadeCarteira(String codigo, int empresa, String local, String costumerId, String strUsername, String strPassword) throws RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/QuantidadeCarteira");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("http://tempuri.org/", "QuantidadeCarteira"));

        setRequestHeaders(_call);
        setAttachments(_call);
        try {
        	Object _resp = _call.invoke(new Object[] {codigo, Integer.valueOf(empresa), local, costumerId, strUsername, strPassword});

	        if (_resp instanceof RemoteException) {
	            throw (RemoteException)_resp;
	        } else {
	            extractAttachments(_call);
	            try {
	                return ((java.lang.Double) _resp).doubleValue();
	            } catch (Exception _exception) {
	                return ((java.lang.Double) JavaUtils.convert(_resp, double.class)).doubleValue();
	            }
	        }
        } catch (AxisFault axisFaultException) {
        	throw axisFaultException;
        }
    }

    public double quantidadeEstoqueRequisitado(String codigo, int empresa, String local, String costumerId, String strUsername, String strPassword) throws RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/QuantidadeEstoqueRequisitado");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("http://tempuri.org/", "QuantidadeEstoqueRequisitado"));

        setRequestHeaders(_call);
        setAttachments(_call);
        try {        
        	Object _resp = _call.invoke(new Object[] {codigo, Integer.valueOf(empresa), local, costumerId, strUsername, strPassword});

	        if (_resp instanceof RemoteException) {
	            throw (RemoteException)_resp;
	        } else {
	            extractAttachments(_call);
	            try {
	                return ((java.lang.Double) _resp).doubleValue();
	            } catch (Exception _exception) {
	                return ((java.lang.Double) JavaUtils.convert(_resp, double.class)).doubleValue();
	            }
	        }
		} catch (AxisFault axisFaultException) {
			throw axisFaultException;
		}
    }

    public double valorAPagarNoDia(int empresa, String data, String moeda, String costumerId, String strUsername, String strPassword) throws RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/ValorAPagarNoDia");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("http://tempuri.org/", "ValorAPagarNoDia"));

        setRequestHeaders(_call);
        setAttachments(_call);
        try {        
        	Object _resp = _call.invoke(new Object[] {Integer.valueOf(empresa), data, moeda, costumerId, strUsername, strPassword});

        	if (_resp instanceof RemoteException) {
	            throw (RemoteException)_resp;
	        } else {
	            extractAttachments(_call);
	            try {
	                return ((java.lang.Double) _resp).doubleValue();
	            } catch (Exception _exception) {
	                return ((java.lang.Double) JavaUtils.convert(_resp, double.class)).doubleValue();
	            }
	        }
		} catch (AxisFault axisFaultException) {
			throw axisFaultException;
		}
    }

    public double valorAReceberNoDia(int empresa, String data, String moeda, String costumerId, String strUsername, String strPassword) throws RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/ValorAReceberNoDia");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("http://tempuri.org/", "ValorAReceberNoDia"));

        setRequestHeaders(_call);
        setAttachments(_call);
        try {        
        	Object _resp = _call.invoke(new Object[] {Integer.valueOf(empresa), data, moeda, costumerId, strUsername, strPassword});

	        if (_resp instanceof RemoteException) {
	            throw (RemoteException)_resp;
	        } else {
	            extractAttachments(_call);
	            try {
	                return ((java.lang.Double) _resp).doubleValue();
	            } catch (Exception _exception) {
	                return ((java.lang.Double) JavaUtils.convert(_resp, double.class)).doubleValue();
	            }
	        }
		} catch (AxisFault axisFaultException) {
			throw axisFaultException;
		}
    }

    public String descricaoDoProduto(String codigo, String costumerId, String strUsername, String strPassword) throws RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/DescricaoDoProduto");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("http://tempuri.org/", "DescricaoDoProduto"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {codigo, costumerId, strUsername, strPassword});

        if (_resp instanceof RemoteException) {
            throw (RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (String) _resp;
            } catch (Exception _exception) {
                return (String) JavaUtils.convert(_resp, String.class);
            }
        }
  } catch (AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ExecutarComandoResponseExecutarComandoResult executarComando(String comando, String costumerId, String strUsername, String strPassword) throws RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/executarComando");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("http://tempuri.org/", "executarComando"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {comando, costumerId, strUsername, strPassword});

        if (_resp instanceof RemoteException) {
            throw (RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ExecutarComandoResponseExecutarComandoResult) _resp;
            } catch (Exception _exception) {
                return (ExecutarComandoResponseExecutarComandoResult) JavaUtils.convert(_resp, ExecutarComandoResponseExecutarComandoResult.class);
            }
        }
  } catch (AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public String callXmlProcess(String processo, String xml1, String costumerId, String strUsername, String strPassword) throws RemoteException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://tempuri.org/callXmlProcess");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("http://tempuri.org/", "callXmlProcess"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {processo, xml1, costumerId, strUsername, strPassword});

        if (_resp instanceof RemoteException) {
            throw (RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (String) _resp;
            } catch (Exception _exception) {
                return (String) JavaUtils.convert(_resp, String.class);
            }
        }
  } catch (AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}

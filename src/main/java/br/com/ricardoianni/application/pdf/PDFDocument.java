package br.com.ricardoianni.application.pdf;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import br.com.ricardoianni.domain.holerite.Holerite;
import br.com.ricardoianni.domain.holerite.HoleriteDesconto;
import br.com.ricardoianni.domain.holerite.HoleriteVencimento;

public class PDFDocument {

	public void createHoleritePDF(Holerite holerite, String filename) {
		Document document = new Document();
		String filePath = "/mnt/sdb5/home/ricardo/Documents/Workspace/PortalRH/portal/src/main/resources/static/";
		
		
		try {
			PdfWriter.getInstance(document, new FileOutputStream(filePath + filename));
		} catch (DocumentException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		document.setMargins(20, 20, 30, 30);
		document.open();
		
		String fontFamily = "helvetica";
		
		Font title = new Font();
		title.setFamily(fontFamily);
		title.setSize(14);
		
		Font standard = new Font();
		standard.setFamily(fontFamily);
		standard.setSize(8);
		
		Font bold = new Font(standard);
		bold.setStyle("bold");
		
		Font bold10 = new Font();
		bold10.setFamily(fontFamily);
		bold10.setStyle("bold");
		bold10.setSize(10);
		
		Color gray   = new Color(220, 220, 220);
		Color silver = new Color(192, 192, 192);

		PdfPCell cellGray = new PdfPCell();
		cellGray.setBackgroundColor(gray);
		
		PdfPCell cellSilver = new PdfPCell();
		cellSilver.setBackgroundColor(silver);
		
		PdfPTable principalTable   = new PdfPTable(1);
		principalTable.setWidthPercentage(100);
		
		PdfPCell cellTitle = new PdfPCell(cellGray);
		cellTitle.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellTitle.setVerticalAlignment(Element.ALIGN_TOP);
		cellTitle.setPhrase(new Phrase("Demostrativo Salarial", title));
		cellTitle.setFixedHeight(20);
		
		PdfPCell cellSubtitle = new PdfPCell();
		cellSubtitle.setVerticalAlignment(Element.ALIGN_TOP);
		cellSubtitle.setFixedHeight(14);
		
		PdfPCell cellContent = new PdfPCell();
		cellContent.setVerticalAlignment(Element.ALIGN_TOP);
		cellContent.setFixedHeight(14);
		
		int[] setColumnsDados = {15, 85};
		int[] setColumnsContrato = {25, 25, 50};
		int[] setColumns50 = {50, 50};
		int[] setColPgto = {15, 40, 20, 25};
		float[] setColTotal = {(float) 27.5,(float) 22.5,(float) 27.5,(float) 22.5};
		float[] setColLiquido = {(float) 77.5,(float) 22.5};
		float[] setColBase = {(float) 16.666, (float) 16.667, (float) 16.667, (float) 16.667, (float) 16.667, (float) 16.666};
		
		PdfPTable dadosColaborador = new PdfPTable(2);
		dadosColaborador.setWidths(setColumnsDados);
		
		PdfPTable dadosContrato = new PdfPTable(3);
		dadosContrato.setWidths(setColumnsContrato);
		
		PdfPTable pagamentos = new PdfPTable(2);
		pagamentos.setWidths(setColumns50);
		
		PdfPTable headerPagamentos = new PdfPTable(4);
		headerPagamentos.setWidths(setColPgto);

		PdfPTable vencimentos = new PdfPTable(4);
		vencimentos.setWidths(setColPgto);
		
		PdfPTable descontos = new PdfPTable(4);
		descontos.setWidths(setColPgto);

		PdfPTable totalPagamentos = new PdfPTable(4);
		totalPagamentos.setWidths(setColTotal);
		
		PdfPTable pagamentoLiquido = new PdfPTable(2);
		pagamentoLiquido.setWidths(setColLiquido);
		
		PdfPTable baseImpostos = new PdfPTable(6);
		baseImpostos.setWidths(setColBase);
		
		String empresa;
		String endereco;
		String nome;
		String departamento;
		String funcao;
		String mesAno;
		String dtAdmissao;
		String contrato;
		
		empresa = holerite.getEmpresaHolerite().getRazaoSocial();
		
		endereco  = holerite.getEnderecoHolerite().getLogradouro() + ",";
		endereco += holerite.getEnderecoHolerite().getNumero() + " - ";
		if (! holerite.getEnderecoHolerite().getComplemento().isEmpty()) {
			endereco += holerite.getEnderecoHolerite().getComplemento() + " - ";
		}
		endereco += holerite.getEnderecoHolerite().getBairro() + " - ";
		endereco += holerite.getEnderecoHolerite().getCidadeEndereco().getNomeCidade() + "/";
		endereco += holerite.getEnderecoHolerite().getCidadeEndereco().getEstadoCidade().getSigla();
		
		nome  = holerite.getIdFunc().toString() + " - ";
		nome += holerite.getNome() + " - ";
		nome += "CTPS: " + holerite.getCtps() + " ";
		nome += "PIS: " + holerite.getPis_pasep() + " ";
		nome += "CPF: " + holerite.getCpf();
		
		departamento = holerite.getDepartamento();
		
		funcao = holerite.getFuncao();
		
		String mes = Month.of(Integer.valueOf(holerite.getMes())).getDisplayName(TextStyle.FULL, new Locale("pt", "BR"));
		mes = mes.substring(0, 1).toUpperCase() + mes.substring(1);
		
		mesAno = mes + "/" + holerite.getAno();
		
		dtAdmissao = "Data de Admissão: " + holerite.getDataAdmissaoFormated();
		
		contrato = "Contrato: " + holerite.getContrato();
		
		PdfPCell cellEmpresaTitle = new PdfPCell(cellSubtitle);
		PdfPCell cellEmpresa = new PdfPCell(cellContent);
		PdfPCell cellEnderecoTitle = new PdfPCell(cellSubtitle);
		PdfPCell cellEndereco = new PdfPCell(cellContent);
		PdfPCell cellNomeTitle = new PdfPCell(cellSubtitle);
		PdfPCell cellNome = new PdfPCell(cellContent);
		PdfPCell cellDepartamentoTitle = new PdfPCell(cellSubtitle);
		PdfPCell cellDepartamento = new PdfPCell(cellContent);
		PdfPCell cellFuncaoTitle = new PdfPCell(cellSubtitle);
		PdfPCell cellFuncao = new PdfPCell(cellContent);

		cellEmpresaTitle.setPhrase(new Phrase("Empresa", standard));
		cellEmpresa.setPhrase(new Phrase(empresa, bold));
		cellEnderecoTitle.setPhrase(new Phrase("Endereço", standard));
		cellEndereco.setPhrase(new Phrase(endereco, standard));
		cellNomeTitle.setPhrase(new Phrase("Nome", standard));
		cellNome.setPhrase(new Phrase(nome, bold));
		cellDepartamentoTitle.setPhrase(new Phrase("Departamento", standard));
		cellDepartamento.setPhrase(new Phrase(departamento, standard));
		cellFuncaoTitle.setPhrase(new Phrase("Função", standard));
		cellFuncao.setPhrase(new Phrase(funcao, standard));
		
		dadosColaborador.addCell(cellEmpresaTitle);
		dadosColaborador.addCell(cellEmpresa);
		dadosColaborador.addCell(cellEnderecoTitle);
		dadosColaborador.addCell(cellEndereco);
		dadosColaborador.addCell(cellNomeTitle);
		dadosColaborador.addCell(cellNome);
		dadosColaborador.addCell(cellDepartamentoTitle);
		dadosColaborador.addCell(cellDepartamento);
		dadosColaborador.addCell(cellFuncaoTitle);
		dadosColaborador.addCell(cellFuncao);
		
		PdfPCell cellColaborador = new PdfPCell(dadosColaborador);
		cellColaborador.setUseBorderPadding(false);
		
		PdfPCell cellMesAno = new PdfPCell();
		cellMesAno.setBackgroundColor(gray);
		cellMesAno.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellMesAno.setVerticalAlignment(Element.ALIGN_TOP);
		cellMesAno.setFixedHeight(16);
		
		PdfPCell cellDtAdmissao = new PdfPCell(cellContent);
		cellDtAdmissao.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellDtAdmissao.setPaddingTop(3);
		
		PdfPCell cellContrato = new PdfPCell(cellContent);
		cellContrato.setPaddingTop(3);
		
		cellMesAno.setPhrase(new Phrase(mesAno, bold10));
		cellDtAdmissao.setPhrase(new Phrase(dtAdmissao, standard));
		cellContrato.setPhrase(new Phrase(contrato, standard));
		
		dadosContrato.addCell(cellMesAno);
		dadosContrato.addCell(cellDtAdmissao);
		dadosContrato.addCell(cellContrato);
		
		PdfPCell cellContratoLine = new PdfPCell(dadosContrato);
		cellContrato.setUseBorderPadding(false);		
		
		PdfPCell cellTitleVencimentos = new PdfPCell(cellGray);
		cellTitleVencimentos.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellTitleVencimentos.setVerticalAlignment(Element.ALIGN_TOP);
		cellTitleVencimentos.setPhrase(new Phrase("Vencimentos", bold10));
		cellTitleVencimentos.setFixedHeight(16);
		
		PdfPCell cellTitleDescontos = new PdfPCell(cellGray);
		cellTitleDescontos.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellTitleDescontos.setVerticalAlignment(Element.ALIGN_TOP);
		cellTitleDescontos.setPhrase(new Phrase("Descontos", bold10));
		cellTitleVencimentos.setFixedHeight(16);

		PdfPCell cellHeader = new PdfPCell(cellGray);
		cellHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellHeader.setFixedHeight(14);
		
		PdfPCell cellCodeHead = new PdfPCell(cellHeader);
		cellCodeHead.setPhrase(new Phrase("Código", bold));
		PdfPCell cellDescriptionHead = new PdfPCell(cellHeader);
		cellDescriptionHead.setPhrase(new Phrase("Descrição", bold));
		PdfPCell cellReferenceHead = new PdfPCell(cellHeader);
		cellReferenceHead.setPhrase(new Phrase("Ref.", bold));
		PdfPCell cellValueHead = new PdfPCell(cellHeader);
		cellValueHead.setPhrase(new Phrase("Valor", bold));
		
		headerPagamentos.addCell(cellCodeHead);
		headerPagamentos.addCell(cellDescriptionHead);
		headerPagamentos.addCell(cellReferenceHead);
		headerPagamentos.addCell(cellValueHead);
		
		PdfPCell cellHeaderPagamentos = new PdfPCell(headerPagamentos);
		cellHeaderPagamentos.setUseBorderPadding(false);
		
		PdfPCell cellCode = new PdfPCell();
		cellCode.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellCode.setFixedHeight(14);
		cellCode.setBorder(0);
		
		PdfPCell cellDescription = new PdfPCell();
		cellDescription.setHorizontalAlignment(Element.ALIGN_LEFT);
		cellDescription.setFixedHeight(14);
		cellDescription.setBorder(0);

		PdfPCell cellReference = new PdfPCell();
		cellReference.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellReference.setFixedHeight(14);
		cellReference.setBorder(0);

		PdfPCell cellValue = new PdfPCell();
		cellValue.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cellValue.setFixedHeight(14);
		cellValue.setBorder(0);
		
		List<HoleriteVencimento> holeriteVencimentos = holerite.getVencimentos();
		HoleriteVencimento holeriteVencimento;
		
		for (int i = 0; i < holeriteVencimentos.size(); i++) {
			holeriteVencimento = holeriteVencimentos.get(i);
			
			cellCode.setPhrase(new Phrase(holeriteVencimento.getClasse(), standard));
			cellDescription.setPhrase(new Phrase(holeriteVencimento.getDescricao(), standard));
			cellReference.setPhrase(new Phrase(holeriteVencimento.getReferencia(), standard));
			cellValue.setPhrase(new Phrase(holeriteVencimento.getValor().toString(), standard));
			
			vencimentos.addCell(cellCode);
			vencimentos.addCell(cellDescription);
			vencimentos.addCell(cellReference);
			vencimentos.addCell(cellValue);
			
		}
		
		List<HoleriteDesconto> holeriteDescontos = holerite.getDescontos();
		HoleriteDesconto holeriteDesconto;
		
		for (int i = 0; i < holeriteDescontos.size(); i++) {
			holeriteDesconto = holeriteDescontos.get(i);
			
			cellCode.setPhrase(new Phrase(holeriteDesconto.getClasse(), standard));
			cellDescription.setPhrase(new Phrase(holeriteDesconto.getDescricao(), standard));
			cellReference.setPhrase(new Phrase(holeriteDesconto.getReferencia(), standard));
			cellValue.setPhrase(new Phrase(holeriteDesconto.getValor().toString(), standard));
			
			descontos.addCell(cellCode);
			descontos.addCell(cellDescription);
			descontos.addCell(cellReference);
			descontos.addCell(cellValue);
			
		}
		
		PdfPCell cellVencimentos = new PdfPCell(vencimentos);
		cellVencimentos.setUseBorderPadding(false);
		cellVencimentos.setMinimumHeight(300);
		
		PdfPCell cellDescontos = new PdfPCell(descontos);
		cellDescontos.setUseBorderPadding(false);
		cellDescontos.setMinimumHeight(300);
		
		pagamentos.addCell(cellTitleVencimentos);
		pagamentos.addCell(cellTitleDescontos);
		
		pagamentos.addCell(cellHeaderPagamentos);
		pagamentos.addCell(cellHeaderPagamentos);
		
		pagamentos.addCell(cellVencimentos);
		pagamentos.addCell(cellDescontos);
		
		PdfPCell cellPagamentos = new PdfPCell(pagamentos);
		cellPagamentos.setUseBorderPadding(false);
		
		PdfPCell cellTotVencHead = new PdfPCell(cellGray);
		cellTotVencHead.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellTotVencHead.setPhrase(new Phrase("Total de Vencimentos", bold10));
		cellTotVencHead.setFixedHeight(16);
		
		PdfPCell cellTotVencValue = new PdfPCell(cellGray);
		cellTotVencValue.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cellTotVencValue.setPhrase(new Phrase(holerite.getTotalVencimento().toString(), bold10));
		cellTotVencValue.setFixedHeight(16);
		
		PdfPCell cellTotDescHead = new PdfPCell(cellGray);
		cellTotDescHead.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellTotDescHead.setPhrase(new Phrase("Total de Descontos", bold10));
		cellTotDescHead.setFixedHeight(16);
		
		PdfPCell cellTotDescValue = new PdfPCell(cellGray);
		cellTotDescValue.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cellTotDescValue.setPhrase(new Phrase(holerite.getTotalDesconto().toString(), bold10));
		cellTotDescValue.setFixedHeight(16);
		
		totalPagamentos.addCell(cellTotVencHead);
		totalPagamentos.addCell(cellTotVencValue);
		totalPagamentos.addCell(cellTotDescHead);
		totalPagamentos.addCell(cellTotDescValue);
		
		PdfPCell cellTotais = new PdfPCell(totalPagamentos);
		cellTotais.setUseBorderPadding(false);
		
		PdfPCell cellLiquidoHead = new PdfPCell(cellGray);
		cellLiquidoHead.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellLiquidoHead.setPhrase(new Phrase("Líquido de Pagamento", bold10));
		cellLiquidoHead.setFixedHeight(16);
		
		PdfPCell cellLiquidoValue = new PdfPCell(cellGray);
		cellLiquidoValue.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cellLiquidoValue.setPhrase(new Phrase(holerite.getSalarioLiquido().toString(), bold10));
		cellLiquidoValue.setFixedHeight(16);
		
		pagamentoLiquido.addCell(cellLiquidoHead);
		pagamentoLiquido.addCell(cellLiquidoValue);
		
		PdfPCell cellLiquido = new PdfPCell(pagamentoLiquido);
		cellLiquido.setUseBorderPadding(false);
		
		PdfPCell cellBaseHeader = new PdfPCell(cellSilver);
		cellBaseHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellBaseHeader.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cellBaseHeader.setFixedHeight(20);
		
		PdfPCell cellBaseContent = new PdfPCell();
		cellBaseContent.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cellBaseContent.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cellBaseContent.setFixedHeight(20);
		
		PdfPCell cellSalarioBaseHead = new PdfPCell(cellBaseHeader);
		cellSalarioBaseHead.setPhrase(new Phrase("Salário Base", standard));
		
		PdfPCell cellBaseINSSHead = new PdfPCell(cellBaseHeader);
		cellBaseINSSHead.setPhrase(new Phrase("Salário Contr. INSS", standard));
		
		PdfPCell cellBaseFGTSHead = new PdfPCell(cellBaseHeader);
		cellBaseFGTSHead.setPhrase(new Phrase("Base Calc. FGTS", standard));
		
		PdfPCell cellFGTSMesHead = new PdfPCell(cellBaseHeader);
		cellFGTSMesHead.setPhrase(new Phrase("FGTS do Mês", standard));
	
		PdfPCell cellBaseIRRFHead = new PdfPCell(cellBaseHeader);
		cellBaseIRRFHead.setPhrase(new Phrase("Base Imp. de Renda", standard));
		
		PdfPCell cellFaixaIRRFHead = new PdfPCell(cellBaseHeader);
		cellFaixaIRRFHead.setPhrase(new Phrase("Faixa de IRRF", standard));
		
		PdfPCell cellSalarioBase = new PdfPCell(cellBaseContent);
		cellSalarioBase.setPhrase(new Phrase(holerite.getSalarioBase().toString(), standard));
		
		PdfPCell cellBaseINSS = new PdfPCell(cellBaseContent);
		cellBaseINSS.setPhrase(new Phrase(holerite.getSalarioINSS().toString(), standard));
		
		PdfPCell cellBaseFGTS = new PdfPCell(cellBaseContent);
		cellBaseFGTS.setPhrase(new Phrase(holerite.getSalarioFGTS().toString(), standard));
		
		PdfPCell cellFGTSMes = new PdfPCell(cellBaseContent);
		cellFGTSMes.setPhrase(new Phrase(holerite.getFgtsMes().toString(), standard));
	
		PdfPCell cellBaseIRRF = new PdfPCell(cellBaseContent);
		cellBaseIRRF.setPhrase(new Phrase(holerite.getSalarioIRRF().toString(), standard));
		
		PdfPCell cellFaixaIRRF = new PdfPCell(cellBaseContent);
		cellFaixaIRRF.setPhrase(new Phrase(holerite.getFaixaIRRF().toString(), standard));
	
		baseImpostos.addCell(cellSalarioBaseHead);
		baseImpostos.addCell(cellBaseINSSHead);
		baseImpostos.addCell(cellBaseFGTSHead);
		baseImpostos.addCell(cellFGTSMesHead);
		baseImpostos.addCell(cellBaseIRRFHead);
		baseImpostos.addCell(cellFaixaIRRFHead);
		
		baseImpostos.addCell(cellSalarioBase);
		baseImpostos.addCell(cellBaseINSS);
		baseImpostos.addCell(cellBaseFGTS);
		baseImpostos.addCell(cellFGTSMes);
		baseImpostos.addCell(cellBaseIRRF);
		baseImpostos.addCell(cellFaixaIRRF);
		
		PdfPCell cellBaseImpostos = new PdfPCell(baseImpostos);
		cellBaseImpostos.setUseBorderPadding(false);
		
		principalTable.addCell(cellTitle);
		principalTable.addCell(cellColaborador);
		principalTable.addCell(cellContratoLine);
		principalTable.addCell(cellPagamentos);
		principalTable.addCell(cellTotais);
		principalTable.addCell(cellLiquido);
		principalTable.addCell(cellBaseImpostos);
		
		document.add(principalTable);
		
		document.close();
		
		/*
		 * File file = new File(filePath + filename); System.out.println(
		 * file.isFile()); FileInputStream fileInputStream;
		 * 
		 * try { fileInputStream = new FileInputStream(file); } catch
		 * (FileNotFoundException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
	}
}

package br.com.ricardoianni.application.pdf;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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
import br.com.ricardoianni.domain.holerite.HoleritePagamento;
import br.com.ricardoianni.util.FormatUtils;
import br.com.ricardoianni.util.StringUtils;

public class PDFDocument {
	
	private Holerite holerite;

	private Font title    = new Font(Font.HELVETICA, 14, Font.NORMAL);
	private Font standard = new Font(Font.HELVETICA,  8, Font.NORMAL);
	private Font bold     = new Font(Font.HELVETICA,  8, Font.BOLD);
	private Font bold10   = new Font(Font.HELVETICA, 10, Font.BOLD);
	
	private Color gray   = new Color(220, 220, 220);
	private Color silver = new Color(192, 192, 192);
	
	private PdfPCell cellGray   = new PdfPCell();
	private PdfPCell cellSilver = new PdfPCell();
	private PdfPCell cellSubtitle = new PdfPCell();
	private PdfPCell cellContent = new PdfPCell();
	
	private PdfPTable dadosColaborador() {
		int[] setColumnsDados = {15, 85};
		
		PdfPTable dadosColaborador = new PdfPTable(2);
		dadosColaborador.setWidths(setColumnsDados);
		
		String empresa = holerite.getEmpresaHolerite().getRazaoSocial();
		String departamento = holerite.getDepartamento();
		String funcao = holerite.getFuncao();
		
		String endereco = holerite.getEmpresaHolerite().getEnderecoEmpresa().getLogradouro();
		
		if (! StringUtils.isEmpty(holerite.getEmpresaHolerite().getEnderecoEmpresa().getNumero())) {
			endereco += ", " + holerite.getEmpresaHolerite().getEnderecoEmpresa().getNumero();
		}
		
		if (! StringUtils.isEmpty(holerite.getEmpresaHolerite().getEnderecoEmpresa().getComplemento())) {
			endereco += " - " + holerite.getEmpresaHolerite().getEnderecoEmpresa().getComplemento();
		}
		
		if (! StringUtils.isEmpty(holerite.getEmpresaHolerite().getEnderecoEmpresa().getBairro())) {
			endereco += " - " + holerite.getEmpresaHolerite().getEnderecoEmpresa().getBairro();
		}
		
		endereco += " - " + holerite.getEmpresaHolerite().getEnderecoEmpresa().getCidadeEndereco().getNomeCidade() + "/" +
					holerite.getEmpresaHolerite().getEnderecoEmpresa().getCidadeEndereco().getEstadoCidade().getSigla();
		
		String nome = holerite.getColaboradorHolerite().getIdFunc().toString() + " - " +
					  holerite.getColaboradorHolerite().getNome() + " - " +
					  "CTPS: " + holerite.getColaboradorHolerite().getCtps() + " " +
					  "PIS: "  + holerite.getColaboradorHolerite().getPisPasep() + " " +
					  "CPF: "  + holerite.getColaboradorHolerite().getCpf();
		

		PdfPCell cellEmpresaTitle = new PdfPCell(cellSubtitle);
		cellEmpresaTitle.setPhrase(new Phrase("Empresa", standard));
		
		PdfPCell cellEmpresa = new PdfPCell(cellContent);
		cellEmpresa.setPhrase(new Phrase(empresa, bold));
		
		dadosColaborador.addCell(cellEmpresaTitle);
		dadosColaborador.addCell(cellEmpresa);
		
		
		PdfPCell cellEnderecoTitle = new PdfPCell(cellSubtitle);
		cellEnderecoTitle.setPhrase(new Phrase("Endereço", standard));
		
		PdfPCell cellEndereco = new PdfPCell(cellContent);
		cellEndereco.setPhrase(new Phrase(endereco, standard));
		
		dadosColaborador.addCell(cellEnderecoTitle);
		dadosColaborador.addCell(cellEndereco);
		
		
		PdfPCell cellNomeTitle = new PdfPCell(cellSubtitle);
		cellNomeTitle.setPhrase(new Phrase("Nome", standard));
		
		PdfPCell cellNome = new PdfPCell(cellContent);
		cellNome.setPhrase(new Phrase(nome, bold));
		
		dadosColaborador.addCell(cellNomeTitle);
		dadosColaborador.addCell(cellNome);
		
		
		PdfPCell cellDepartamentoTitle = new PdfPCell(cellSubtitle);
		cellDepartamentoTitle.setPhrase(new Phrase("Departamento", standard));
		
		PdfPCell cellDepartamento = new PdfPCell(cellContent);
		cellDepartamento.setPhrase(new Phrase(departamento, standard));
		
		dadosColaborador.addCell(cellDepartamentoTitle);
		dadosColaborador.addCell(cellDepartamento);
		
		
		PdfPCell cellFuncaoTitle = new PdfPCell(cellSubtitle);
		cellFuncaoTitle.setPhrase(new Phrase("Função", standard));
		
		PdfPCell cellFuncao = new PdfPCell(cellContent);
		cellFuncao.setPhrase(new Phrase(funcao, standard));
		
		dadosColaborador.addCell(cellFuncaoTitle);
		dadosColaborador.addCell(cellFuncao);

		return dadosColaborador;
	}
	
	private PdfPTable dadosContrato() {
		int[] setColumnsContrato = {25, 25, 50};
		
		PdfPTable dadosContrato = new PdfPTable(3);
		dadosContrato.setWidths(setColumnsContrato);
		
		String mes = Month.of(Integer.valueOf(holerite.getMes())).getDisplayName(TextStyle.FULL, new Locale("pt", "BR"));
		mes = mes.substring(0, 1).toUpperCase() + mes.substring(1);
		
		String mesAno = mes + "/" + holerite.getAno();
		String dtAdmissao = "Data de Admissão: " + holerite.getDataAdmissaoFormated();
		String contrato = "Contrato: " + holerite.getContrato();
		
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
		
		return dadosContrato;
	}
	
	private PdfPTable pagamentos(List<HoleritePagamento> holeritePagamentos, String title) {
		int[] setColPgto = {15, 40, 20, 25};
		
		PdfPTable pagamentos = new PdfPTable(4);
		pagamentos.setWidths(setColPgto);

		PdfPCell cellTitle = new PdfPCell(cellGray);
		cellTitle.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellTitle.setVerticalAlignment(Element.ALIGN_TOP);
		cellTitle.setPhrase(new Phrase(title, bold10));
		cellTitle.setFixedHeight(16);
		cellTitle.setColspan(4);
		
		pagamentos.addCell(cellTitle);
		
		
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
		
		pagamentos.addCell(cellCodeHead);
		pagamentos.addCell(cellDescriptionHead);
		pagamentos.addCell(cellReferenceHead);
		pagamentos.addCell(cellValueHead);
		
		
		PdfPCell cellRecords = new PdfPCell();
		cellRecords.setFixedHeight(14);
		cellRecords.setBorder(0);
		
		PdfPCell cellCode = new PdfPCell(cellRecords);
		cellCode.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cellDescription = new PdfPCell(cellRecords);
		cellDescription.setHorizontalAlignment(Element.ALIGN_LEFT);
		
		PdfPCell cellReference = new PdfPCell(cellRecords);
		cellReference.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cellValue = new PdfPCell(cellRecords);
		cellValue.setHorizontalAlignment(Element.ALIGN_RIGHT);
		
		HoleritePagamento holeritePagamento;
		
		if (holeritePagamentos.size() == 0) {
			
			cellCode.setPhrase(new Phrase("", standard));
			cellDescription.setPhrase(new Phrase("", standard));
			cellReference.setPhrase(new Phrase("", standard));
			cellValue.setPhrase(new Phrase("", standard));
			
			pagamentos.addCell(cellCode);
			pagamentos.addCell(cellDescription);
			pagamentos.addCell(cellReference);
			pagamentos.addCell(cellValue);
		}
		
		for (int i = 0; i < holeritePagamentos.size(); i++) {
			holeritePagamento = holeritePagamentos.get(i);
			
			cellCode.setPhrase(new Phrase(holeritePagamento.getClasse(), standard));
			cellDescription.setPhrase(new Phrase(holeritePagamento.getDescricao(), standard));
			cellReference.setPhrase(new Phrase(holeritePagamento.getReferencia(), standard));
			cellValue.setPhrase(new Phrase(FormatUtils.formatCurrency(holeritePagamento.getValor()), standard));
			
			pagamentos.addCell(cellCode);
			pagamentos.addCell(cellDescription);
			pagamentos.addCell(cellReference);
			pagamentos.addCell(cellValue);
			
		}
		
		return pagamentos;
	}
	
	private PdfPTable totais() {
		float[] setColTotal = {(float) 27.5,(float) 22.5,(float) 27.5,(float) 22.5};
		
		PdfPTable totais = new PdfPTable(4);
		totais.setWidths(setColTotal);
		
		PdfPCell cellHead = new PdfPCell(cellGray);
		cellHead.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellHead.setFixedHeight(16);
				
		PdfPCell cellValue = new PdfPCell(cellGray);
		cellHead.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cellHead.setFixedHeight(16);
				
		PdfPCell cellVencHead = new PdfPCell(cellHead);
		cellVencHead.setPhrase(new Phrase("Total de Vencimentos", bold10));
		PdfPCell cellVencValue = new PdfPCell(cellValue);
		cellVencValue.setPhrase(new Phrase(FormatUtils.formatCurrency(holerite.getTotalVencimento()), bold10));
		
		PdfPCell cellDescHead = new PdfPCell(cellHead);
		cellDescHead.setPhrase(new Phrase("Total de Descontos", bold10));
		PdfPCell cellDescValue = new PdfPCell(cellValue);
		cellDescValue.setPhrase(new Phrase(FormatUtils.formatCurrency(holerite.getTotalDesconto()), bold10));
		
		totais.addCell(cellVencHead);
		totais.addCell(cellVencValue);
		totais.addCell(cellDescHead);
		totais.addCell(cellDescValue);
		
		PdfPCell cellLiquidoHead = new PdfPCell(cellHead);
		cellLiquidoHead.setPhrase(new Phrase("Líquido de Pagamento", bold10));
		cellLiquidoHead.setColspan(3);
		PdfPCell cellLiquidoValue = new PdfPCell(cellValue);
		cellLiquidoValue.setPhrase(new Phrase(FormatUtils.formatCurrency(holerite.getSalarioLiquido()), bold10));
		
		totais.addCell(cellLiquidoHead);
		totais.addCell(cellLiquidoValue);
		
		return totais;
	}
	
	private PdfPTable baseImpostos() {
		float[] setColBase = {(float) 16.666, (float) 16.667, (float) 16.667, (float) 16.667, (float) 16.667, (float) 16.666};
		
		PdfPTable baseImpostos = new PdfPTable(6);
		baseImpostos.setWidths(setColBase);
		
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
		cellSalarioBase.setPhrase(new Phrase(FormatUtils.formatCurrency(holerite.getSalarioBase()), standard));
		PdfPCell cellBaseINSS = new PdfPCell(cellBaseContent);
		cellBaseINSS.setPhrase(new Phrase(FormatUtils.formatCurrency(holerite.getSalarioINSS()), standard));
		PdfPCell cellBaseFGTS = new PdfPCell(cellBaseContent);
		cellBaseFGTS.setPhrase(new Phrase(FormatUtils.formatCurrency(holerite.getSalarioFGTS()), standard));
		PdfPCell cellFGTSMes = new PdfPCell(cellBaseContent);
		cellFGTSMes.setPhrase(new Phrase(FormatUtils.formatCurrency(holerite.getFgtsMes()), standard));
		PdfPCell cellBaseIRRF = new PdfPCell(cellBaseContent);
		cellBaseIRRF.setPhrase(new Phrase(FormatUtils.formatCurrency(holerite.getSalarioIRRF()), standard));
		PdfPCell cellFaixaIRRF = new PdfPCell(cellBaseContent);
		cellFaixaIRRF.setPhrase(new Phrase(FormatUtils.formatCurrency(holerite.getFaixaIRRF()), standard));
	
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
		
		return baseImpostos;
	}
	
	public ByteArrayInputStream createHoleritePDF(Holerite holerite) {
		this.holerite = holerite;
		
		ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
		
		cellGray.setBackgroundColor(gray);
		cellSilver.setBackgroundColor(silver);
		
		Document document = new Document();
		document.setMargins(20, 20, 30, 30);
		
		PdfPTable principalTable   = new PdfPTable(1);
		principalTable.setWidthPercentage(100);
		
		PdfPCell cellTitle = new PdfPCell(cellGray);
		cellTitle.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellTitle.setVerticalAlignment(Element.ALIGN_TOP);
		cellTitle.setPhrase(new Phrase("Demostrativo Salarial", title));
		cellTitle.setFixedHeight(20);
		
		cellSubtitle.setVerticalAlignment(Element.ALIGN_TOP);
		cellSubtitle.setFixedHeight(14);
		
		cellContent.setVerticalAlignment(Element.ALIGN_TOP);
		cellContent.setFixedHeight(14);
		
		int[] setColumns50 = {50, 50};
		
		PdfPTable pagamentos = new PdfPTable(2);
		pagamentos.setWidths(setColumns50);
		
		PdfPCell cellColaborador = new PdfPCell(dadosColaborador());
		cellColaborador.setUseBorderPadding(false);
		
		PdfPCell cellContrato = new PdfPCell(dadosContrato());
		cellContrato.setUseBorderPadding(false);		
		
		List<HoleritePagamento> holeriteVencimentos = List.copyOf(holerite.getVencimentos());
		List<HoleritePagamento> holeriteDescontos = List.copyOf(holerite.getDescontos());
		
		PdfPCell cellVencimentos = new PdfPCell(pagamentos(holeriteVencimentos, "Vencimentos"));
		cellVencimentos.setUseBorderPadding(false);
		cellVencimentos.setMinimumHeight(300);
		
		PdfPCell cellDescontos = new PdfPCell(pagamentos(holeriteDescontos, "Descontos"));
		cellDescontos.setUseBorderPadding(false);
		cellDescontos.setMinimumHeight(300);
		
		pagamentos.addCell(cellVencimentos);
		pagamentos.addCell(cellDescontos);
		
		PdfPCell cellPagamentos = new PdfPCell(pagamentos);
		cellPagamentos.setUseBorderPadding(false);
		
		PdfPCell cellTotais = new PdfPCell(totais());
		cellTotais.setUseBorderPadding(false);
		
		PdfPCell cellBaseImpostos = new PdfPCell(baseImpostos());
		cellBaseImpostos.setUseBorderPadding(false);
		
		principalTable.addCell(cellTitle);
		principalTable.addCell(cellColaborador);
		principalTable.addCell(cellContrato);
		principalTable.addCell(cellPagamentos);
		principalTable.addCell(cellTotais);
		principalTable.addCell(cellBaseImpostos);

		try {
			PdfWriter.getInstance(document, byteOutputStream);
			document.open();
			document.add(principalTable);

			document.close();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ByteArrayInputStream(byteOutputStream.toByteArray());
	}
}

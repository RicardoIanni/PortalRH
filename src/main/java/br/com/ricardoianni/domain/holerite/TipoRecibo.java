package br.com.ricardoianni.domain.holerite;

public enum TipoRecibo {

	FP("Recibo Mensal"), 
	AD("Adiantamento"), 
	D1("1ª Parcela do 13º"),
	D2("2ª Parcela do 13º");
	
	String descricao;
	
	TipoRecibo(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}

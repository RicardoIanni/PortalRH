package br.com.ricardoianni.domain.holerite;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@MappedSuperclass
public class HoleritePagamento implements Serializable {
	
	private String classe;
	
	private String descricao;
	
	private String referencia;
	
	private BigDecimal valor;
	
	
}

package br.com.ricardoianni.domain.holerite;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Getter
@Setter
public class HoleriteDesconto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iddesconto")
	private Integer idDesconto;
	
	private String classe;
	
	private String descricao;
	
	private String referencia;
	
	private BigDecimal valor;
	
	@ManyToOne
	@JoinColumn(name = "idholerite")
	private Holerite holeriteDesconto;

}

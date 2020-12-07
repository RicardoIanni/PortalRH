package br.com.ricardoianni.domain.holerite;

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
public class HoleriteDesconto extends HoleritePagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iddesconto")
	private Integer idDesconto;
	
	@ManyToOne
	@JoinColumn(name = "idholerite")
	private Holerite holeriteDesconto;

}
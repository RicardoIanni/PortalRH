package br.com.ricardoianni.domain.employee;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.ricardoianni.domain.holerite.TipoRecibo;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Getter
@Setter
public class Recibo implements Serializable {

	@Id
	@Column(name = "idrecibo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRecibo;
	
	private TipoRecibo tipoRecibo;
	
	@ManyToOne
	@JoinColumn(name = "idcompetencia")
	private Competencia competenciaRecibo;
	
}

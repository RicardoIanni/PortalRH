package br.com.ricardoianni.domain.employee;

import java.io.Serializable;

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
public class Competencia implements Serializable {

	@Id
	@Column(name = "idcompetencia")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCompetencia;
	
	private String mes;
	
	private String ano;
	
	@ManyToOne
	@JoinColumn(name = "idcolaborador")
	private Colaborador colaboradorCompetencia;
}

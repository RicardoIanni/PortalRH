package br.com.ricardoianni.domain.company;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.ricardoianni.domain.customer.Cliente;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Empresa implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idempresa")
	private Integer idEmpresa;
	
	@EqualsAndHashCode.Include
	private String cnpj;
	
	private String razaoSocial;
	
	@ManyToOne
	@JoinColumn(name = "idcliente")
	private Cliente clienteEmpresa;
	
}
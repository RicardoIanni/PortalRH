package br.com.ricardoianni.domain.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import br.com.ricardoianni.domain.address.Endereco;
import br.com.ricardoianni.domain.customer.Cliente;
import br.com.ricardoianni.domain.employee.Colaborador;
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
	@Column(name = "CNPJ")
	private String cnpj;
	
	private String codigo;
	
	private String razaoSocial;
	
	@ManyToOne
	@JoinColumn(name = "idendereco")
	private Endereco enderecoEmpresa;
	
	@ManyToOne
	@JoinColumn(name = "idcliente")
	private Cliente clienteEmpresa;

	@ManyToMany(mappedBy = "empresasColaborador", fetch = FetchType.EAGER)
	private List<Colaborador> colaboradoresEmpresa = new ArrayList<>(0);
	
}
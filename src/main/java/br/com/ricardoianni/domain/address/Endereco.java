package br.com.ricardoianni.domain.address;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.ricardoianni.domain.company.Empresa;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Endereco implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idendereco")
	private Integer idEndereco;
	
	@EqualsAndHashCode.Include
	private String logradouro;
	
	@EqualsAndHashCode.Include
	private String numero;
	
	@EqualsAndHashCode.Include
	private String complemento;
	
	@EqualsAndHashCode.Include
	private String bairro;
	
	@ManyToOne
	@JoinColumn(name = "idcidade")
	@EqualsAndHashCode.Include
	private Cidade cidadeEndereco;
	
	@OneToMany(mappedBy = "enderecoEmpresa")
	private List<Empresa> empresas = new ArrayList<>();
	
}

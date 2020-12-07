package br.com.ricardoianni.domain.address;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Getter
@Setter
public class Cidade implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcidade")
	private Integer idCidade;
	
	private String nomeCidade;
	
	@ManyToOne
	@JoinColumn(name = "idestado")
	private Estado estadoCidade;
	
	@OneToMany(mappedBy = "cidadeEndereco")
	private Set<Endereco> enderecos = new HashSet<>(0);
}
